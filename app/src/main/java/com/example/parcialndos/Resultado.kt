package com.example.parcialndos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_resultado.*

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        //Se llama a la funcion Obtener
        Obtener()

    }
    /*
    Se crea una funcion para mandar a llamar los datos del SharedPreferences
    y se muestren en el activity
     */
    private fun Obtener(){
        @Suppress("DEPRECATION")
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        val name:TextView=txtName
        val clinic:TextView=txtClinic
        val number:TextView=txtNumber

        val myprefs = prefs.getString("key1", "Nombre: No hay registro ")
        val myprefs1 = prefs.getString("key2", "Clinica: No hay registro ")
        val myprefs2 = prefs.getString("key3", "N° de la dosis: No hay  registro ")

        name.text=myprefs
        clinic.text=myprefs1
        number.text=myprefs2
    }
}