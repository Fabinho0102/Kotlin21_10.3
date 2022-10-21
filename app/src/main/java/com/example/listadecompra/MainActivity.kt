package com.example.listadecompra

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val listViewProduto = findViewById<ListView>(R.id.listViewProdutos)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtAfazer = findViewById<TextView>(R.id.txtProduto)
        val txtHora = findViewById<TextView>(R.id.txtHoras)

        listViewProduto.adapter = produtosAdapter

        btnInserir.setOnClickListener {
            val afazer = txtAfazer.text.toString()
            val hora = txtHora.text.toString()
            if (afazer.isNotEmpty()) {
                if (hora.isNotEmpty()) {
                    produtosAdapter.add("As: $hora, Você irá:$afazer")

                }else{
                    txtHora.error = "Coloque um Horario"

                }
            }
            else{
                    txtAfazer.error = "Coloque uma Tarefa"

            }


            }


        listViewProduto.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)

        }
    }
}