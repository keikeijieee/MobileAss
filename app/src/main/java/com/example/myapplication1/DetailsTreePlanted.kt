package com.example.myapplication1

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_details_tree_planted.*


class DetailsTreePlanted : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_tree_planted)


        database = FirebaseDatabase.getInstance().reference
        val uid= FirebaseAuth.getInstance().uid
        val intent = intent
        database.child("tree_user").child("$uid").push().key
        val key =database.child("tree_user").child("$uid").push().key
        textViewId.setText(key)
        textViewTree.setText(intent.getStringExtra("tree"))
        textViewLocation.setText(intent.getStringExtra("location"))
        imageViewTree.setImageResource(intent.getIntExtra("image",0))

        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)/// location activity
            startActivity(intent)
        }

        writeNewTree(uid,key,intent.getStringExtra("tree"),
            intent.getStringExtra("location") )
    }


    private fun writeNewTree(uid: String?,key:String?, treeName: String, treeLocation: String) {

        database.child("tree_user").child("$uid").child("$key").child("location").setValue(treeLocation)
        database.child("tree_user").child("$uid").child("$key").child("tree_id").setValue(key.toString())
        database.child("tree_user").child("$uid").child("$key").child("tree_name").setValue(treeName)
    }
}
