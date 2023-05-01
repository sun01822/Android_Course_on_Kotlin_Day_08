package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.listview.data.Name

class MainActivity : AppCompatActivity() {
    private lateinit var list: ListView
    private lateinit var editText: EditText
    private lateinit var button1 : Button
    var nameList = Name().name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.listView)
        editText = findViewById(R.id.editText)
        button1 = findViewById(R.id.button1)

        val myadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)

        list.adapter = myadapter

        list.setOnItemClickListener { adapterView, view, position, l ->
            nameList.removeAt(position)
            myadapter.notifyDataSetChanged()
        }

        button1.setOnClickListener {
            val name = editText.text.toString()
            nameList.add(0,name)
            myadapter.notifyDataSetChanged()
            editText.text.clear()
        }

    }
}