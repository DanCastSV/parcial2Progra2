package com.example.parcialndos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.progressindicator.BaseProgressIndicator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val save:Button=btnSave
        val show:Button=btnShow
        @Suppress("DEPRECATION")
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)


        save.setOnClickListener {
            val name: String = etxName.text.toString()
            val clinic: String = etxClinic.text.toString()
            val number: String = etxNumber.text.toString()
                val edit = prefs.edit()
                edit.putString("key1", "Nombre: $name")
                edit.putString("key2", "Clinica: $clinic")
                edit.putString("key3", "N° de la dosis: $number")
                edit.apply()
                Alerta("Hemos actualizado los datos")


        }
        show.setOnClickListener {
            val intent = Intent(this, Resultado::class.java).apply {

            }
            startActivity(intent)

        }


    }
    private fun Alerta(message: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Registro")
        builder.setMessage(message)
        val dialog = builder.create()
        dialog.show()

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.info -> {
                val intent = Intent(this, about_us::class.java).apply {

                }
                startActivity(intent)
                true
            }
            R.id.contacto-> {
                val intent = Intent(this, Contacto::class.java).apply {

                }
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}