package com.example.recyclerviewmedbill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var theAdapter = AdapterForRecycleView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var theRecycler = findViewById<RecyclerView>(R.id.theRecycler)

        //theRecycler.layoutManager = LinearLayoutManager(this)

        //theRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        theRecycler.layoutManager = GridLayoutManager(this,3, GridLayoutManager.HORIZONTAL, false )
        theRecycler.adapter = theAdapter

        var addButton = findViewById<Button>(R.id.addPersonButton)
        addButton.setOnClickListener {
            var editTextPerson = findViewById<EditText>(R.id.editTextPerson)

            var personName = editTextPerson.text.toString()

            editTextPerson.setText("")


            theAdapter.myList.add(personName)
            theAdapter.notifyDataSetChanged()

        }







    }
}