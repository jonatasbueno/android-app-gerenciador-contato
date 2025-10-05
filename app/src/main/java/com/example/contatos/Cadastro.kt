package com.example.contatos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contatos.dao.ContatoDao
import com.example.contatos.model.Contato

class Cadastro : AppCompatActivity() {
  lateinit var progressBarRef: ProgressBar
  lateinit var edtNomeRef: EditText
  lateinit var btnCadastrarRef: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_cadastro)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    progressBarRef = findViewById(R.id.pbCadastro)
    edtNomeRef = findViewById(R.id.edtNome)
    btnCadastrarRef = findViewById(R.id.btnCadastrar)
    btnCadastrarRef.setOnClickListener {
      if (edtNomeRef.text.toString().isEmpty()) {
        Toast.makeText(
          this,
          "Preencha o nome",
          Toast.LENGTH_LONG
        )
          .show()
      } else {
        cadastrar()
      }
    }
  }

  private fun cadastrar() {
    val nome = edtNomeRef.text.toString()
    val dao = ContatoDao(this)
    val contato = Contato("", nome)

    progressBarRef.visibility = ProgressBar.VISIBLE
    btnCadastrarRef.isEnabled = false
    edtNomeRef.isEnabled = false
    
    try {
      dao.inserirContato(contato)

      val intent = Intent(this, MainActivity::class.java)

      startActivity(intent)
      finish()
    } catch (erro: Exception) {
      Toast.makeText(
        this,
        "Erro ao cadastrar",
        Toast.LENGTH_LONG
      )
        .show()

      progressBarRef.visibility = ProgressBar.GONE
      btnCadastrarRef.isEnabled = true
      edtNomeRef.isEnabled = true
    }
  }
}