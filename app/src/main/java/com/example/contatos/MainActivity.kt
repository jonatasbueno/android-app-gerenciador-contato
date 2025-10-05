package com.example.contatos

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contatos.adapter.ContatoAdapter
import com.example.contatos.dao.ContatoDao
import com.example.contatos.model.Contato

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    loadContatos()
  }

  private fun loadContatos() {
    val dao = ContatoDao(this)
    val contatos = dao.listarContatos()
    val adapter = ContatoAdapter(contatos, this)
    val lvContatos = findViewById<ListView>(R.id.lvContatos)

    lvContatos.adapter = adapter
  }

  private fun fakeContatos(): List<Contato> {
    val constao1 = Contato("1", "Jonatas")
    val contato2 = Contato("2", "Maria")
    val contato3 = Contato("3", "João")
    val contato4 = Contato("4", "José")
    val contato5 = Contato("5", "Pedro")
    val contatos = mutableListOf<Contato>()

    contatos.add(constao1)
    contatos.add(contato2)
    contatos.add(contato3)
    contatos.add(contato4)
    contatos.add(contato5)

    return contatos
  }
}