package com.example.contatos.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.contatos.model.Contato
import com.example.contatos.sqlite.DbHelper

class ContatoDao {
  private val db: SQLiteDatabase

  constructor(context: Context) {
    val dbHelper = DbHelper(context)
    db = dbHelper.writableDatabase
  }

  fun inserirContato(contato: Contato) {
    val values = ContentValues()
    values.put(DbHelper.COLUMN_NAME, contato.name)

    db.insert(DbHelper.TABLE_CONTATOS_NAME, null, values)
  }

  fun listarContatos(): List<Contato> {
    val contatos = mutableListOf<Contato>()
    val cursor = db.query(
      DbHelper.TABLE_CONTATOS_NAME,
      arrayOf(DbHelper.COLUMN_ID, DbHelper.COLUMN_NAME),
      null,
      null,
      null,
      null,
      null
    )

    if (cursor.moveToFirst()) {
      while (!cursor.isAfterLast) {
        val id = cursor.getInt(0).toString()
        val name = cursor.getString(1)

        val contato = Contato(id, name)
        contatos.add(contato)
      }
    }

    cursor.close()

    return contatos
  }
}
