package com.example.dgenkov.todolistapp

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import io.realm.Realm




class ToDoListItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list_item)
        title = "Finish ToDo"
        val toDoItemId = intent.getStringExtra("toDoItem")
        val realm = Realm.getDefaultInstance()
        val item = realm.where(ToDoItem::class.java).equalTo("id", toDoItemId).findFirst()
        var itemTitle = findViewById<TextView>(R.id.itemTitle)
        var finishButton = findViewById<Button>(R.id.finishButton)

        itemTitle.text = item!!.title
        if (item.important) {
            itemTitle.setTypeface(Typeface.DEFAULT_BOLD)
        }
        finishButton.setOnClickListener {
            realm.beginTransaction()
            item.deleteFromRealm()
            realm.commitTransaction()
            finish()
        }


    }
}
