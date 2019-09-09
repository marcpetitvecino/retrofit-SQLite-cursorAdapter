package com.example.cursoradapterv2real

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView
import org.w3c.dom.Text

class MyCursorAdapter(val context: Context, cursor: Cursor): CursorAdapter(context, cursor, true) { // Creació d'una classe que extén CursorAdapter, ha de tenir una funció newView i una bindView

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {

        return LayoutInflater.from(context).inflate(R.layout.test_cell, parent, false) // En el LayoutInflater posem la cel·la que hem creat que volem que es repeteixi

    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {

        var resultview = view?.findViewById<TextView>(R.id.result) // Declaració del camp on anira el resultat

        var body = cursor!!.getString(cursor.getColumnIndexOrThrow(COL_BODY)) // Aquí agafo la columna de la BDD que conté el que vull mostrar

        resultview!!.text = body // I aquí la passo com a text del textView de resultat

    }
}