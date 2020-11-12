package com.example.ataia

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class AtaiaDatabase(context: Context) :
    ManagedSQLiteOpenHelper(ctx = context, name = "ataia.db", version = 1) {

    companion object {
        private var instance: AtaiaDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): AtaiaDatabase {
            if (instance == null) {
                instance = AtaiaDatabase(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("question", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "question" to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}

val Context.database: AtaiaDatabase
    get() = AtaiaDatabase.getInstance(getApplicationContext())