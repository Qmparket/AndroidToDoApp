package com.example.dgenkov.todolistapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import io.realm.Realm

class AddTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)
        title = "New To Do"

        var realm = Realm.getDefaultInstance()

        var toDoTextField = findViewById<EditText>(R.id.addToDoText)
        var importantCheckbox = findViewById<CheckBox>(R.id.importantCheckbox)
        var addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            if(toDoTextField.text.toString() != "") {
                var newToDo = ToDoItem()
                newToDo.title = toDoTextField.text.toString()
                newToDo.important = importantCheckbox.isChecked

                realm.beginTransaction()
                realm.copyToRealm(newToDo)
                realm.commitTransaction()

                finish()
            }
        }
    }
}
