package com.example.myapplication1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_tree.*


class MyTrees : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_trees)

        recyclerviewTree.layoutManager = LinearLayoutManager(this)
        recyclerviewTree.adapter = MyTreesAdapter()


    }
}