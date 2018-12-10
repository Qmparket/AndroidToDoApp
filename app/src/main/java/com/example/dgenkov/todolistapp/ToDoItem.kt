package com.example.dgenkov.todolistapp

import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class ToDoItem: RealmObject() {
    @PrimaryKey
    private var id = UUID.randomUUID().toString()
    var title = ""
    var important = false

    fun getId() : String {
        return id
    }

    override fun toString() : String {
        return "${title}"
    }
}