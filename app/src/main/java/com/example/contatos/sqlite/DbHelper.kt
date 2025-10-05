package com.example.contatos.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(
  context,
  DATABASE_NAME,
  null,
  DATABASE_VERSION
) {
  companion object {
    const val DATABASE_NAME = "contatos_db"
    const val DATABASE_VERSION = 1
    const val TABLE_CONTATOS_NAME = "contatos"
    const val COLUMN_ID = "id"
    const val COLUMN_NAME = "name"
    const val CREATE_TABLE_CONTATOS =
      "CREATE TABLE $TABLE_CONTATOS_NAME (" +
          "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
          " $COLUMN_NAME TEXT" + ")"
  }

  override fun onCreate(db: SQLiteDatabase?) {
    db?.execSQL(CREATE_TABLE_CONTATOS)
  }

  override fun onUpgrade(
    db: SQLiteDatabase?,
    oldVersion: Int,
    newVersion: Int
  ) {
    TODO("Not yet implemented")
  }

}