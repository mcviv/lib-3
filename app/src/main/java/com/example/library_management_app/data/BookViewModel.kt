package com.example.library_management_app.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.library_management_app.models.Book
import com.example.library_management_app.navigation.ROUTE_BOOK_LIST
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


class BookViewModel(var navController: NavController, var context: Context){

    fun addBook(title: String,author: String) {
        val title = System.currentTimeMillis().toString()
        var storageReference = FirebaseStorage.getInstance().getReference().child("passport/$title$author")


        storageReference.downloadUrl.addOnCompleteListener{
            if (it.isSuccessful){
                storageReference.downloadUrl.addOnSuccessListener{

                    var houseData =Book(title,author)
                    var dbRef = FirebaseDatabase.getInstance().getReference().child("Book/$title$author")
                    dbRef.setValue(houseData)
                    Toast.makeText(context," added successfully", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
            }
        }

    }
    fun BookList(book: MutableState<Book>, books: SnapshotStateList<Book>): SnapshotStateList<Book>{
        var ref = FirebaseDatabase.getInstance().getReference().child("Book")


        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                books.clear()
                for (snap in snapshot.children){
                    val value = snap.getValue(Book::class.java)
                    book.value = value!!
                    books.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return books
    }
    fun BookUpdate(context: Context,navController: NavController,title: String,author: String){
        val databaseReference = FirebaseDatabase.getInstance().getReference("Book/$title$author")

        if (title != title.trim()) {
            val storageReference = FirebaseStorage.getInstance().reference
storageReference


            val updatedClient = Book(title,author)

            databaseReference.setValue(updatedClient)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context, "Updated successfully", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_BOOK_LIST)
                    } else {
                        Toast.makeText(context, "Update failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }

        } else {
            // Keep the current image URL if no new image is selected
            val updatedClient = Book(author,title)
            databaseReference.setValue(updatedClient)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context, "Updated successfully", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_BOOK_LIST)
                    } else {
                        Toast.makeText(context, "Update failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    fun DeleteBook(context: Context, navController: NavController, title: String,author: String) {
//        Initialize a ProgressDialog(if desired, or use another indicator)
        val progressDialog = ProgressDialog(context).apply {
            setMessage("Deleting Book...")
            setCancelable(false)
            show()

//        }

            // Reference to Firebase Realtime Database for the specific client
            val delRef = FirebaseDatabase.getInstance().getReference("Book/$title$author")

            // Perform the delete operation
            delRef.removeValue().addOnCompleteListener { task ->
                // Dismiss the progress dialog
//            progressDialog.dismiss()

                if (task.isSuccessful) {
                    // If deletion was successful, show success message
                    Toast.makeText(context, "Book deleted successfully", Toast.LENGTH_SHORT).show()

                    // Navigate to a different screen after deletion
                    navController.navigate(ROUTE_BOOK_LIST)
                } else {
                    // If deletion failed, show error message
                    Toast.makeText(
                        context,
                        task.exception?.message ?: "Deletion failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }}

        fun BorrowedBook(context: Context, navController: NavController, title: String,author: String) {
            var title = System.currentTimeMillis().toString()
            var storageReference = FirebaseStorage.getInstance().getReference().child("passport/$title")

            storageReference.downloadUrl.addOnCompleteListener{
                if (it.isSuccessful){
                    storageReference.downloadUrl.addOnSuccessListener{

                        var houseData =Book(title,author)
                        var dbRef = FirebaseDatabase.getInstance().getReference().child("Book/$title")
                        dbRef.setValue(houseData)
                        Toast.makeText(context," Borrowed successfully", Toast.LENGTH_LONG).show()
                    }

                }else{
                    Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                }
        }
    

    }

    

    fun returnBook(context: Context, navController: NavController, title: String, author: String) {
//        Initialize a ProgressDialog(if desired, or use another indicator)
        val progressDialog = ProgressDialog(context).apply {
            setMessage("Returning Book...")
            setCancelable(false)
            show()
//        }

            // Reference to Firebase Realtime Database for the specific book
            val delRef = FirebaseDatabase.getInstance().getReference("Book/$title$author")

            // Perform the delete operation
            delRef.removeValue().addOnCompleteListener { task ->
                // Dismiss the progress dialog
//            progressDialog.dismiss()

                if (task.isSuccessful) {
                    // If deletion was successful, show success message
                    Toast.makeText(context, "Book Returned successfully", Toast.LENGTH_SHORT).show()

                    // Navigate to a different screen after deletion
                    navController.navigate(ROUTE_BOOK_LIST)
                } else {
                    // If deletion failed, show error message
                    Toast.makeText(
                        context,
                        task.exception?.message ?: "Returning failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
    }
