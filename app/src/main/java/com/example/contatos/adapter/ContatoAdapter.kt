package com.example.contatos.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.contatos.R
import com.example.contatos.model.Contato


class ContatoAdapter(
  val contatos: List<Contato> = mutableListOf<Contato>(),
  val activity: Activity = Activity()
) : BaseAdapter() {

  override fun getCount(): Int {
    return contatos.size
  }

  override fun getItem(position: Int): Contato? {
    return contatos.get(position)
  }

  override fun getItemId(position: Int): Long {
    return 0
  }

  @SuppressLint("ViewHolder")
  override fun getView(
    position: Int,
    convertView: View?,
    parent: ViewGroup?
  ): View? {
    val view = activity.layoutInflater.inflate(
      R.layout.lista_contato,
      parent,
      false
    )
    val contato = contatos.get(position)
    val textViewListName = view.findViewById<TextView>(R.id.textViewLista)

    textViewListName.text = contato.name

    return view
  }
}