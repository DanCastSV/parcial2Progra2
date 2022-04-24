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


        /*Se configura lo que hará el boton "Guardar" y
        se envían los datos del "SharedPreferences"
         */
        save.setOnClickListener {
            //Se crea una con
            if(etxName.text.isEmpty()||etxClinic.text.isEmpty()||etxNumber.text.isEmpty()){
                Alerta("Por favor rellene los datos")
            }
            else {
                val name: String = etxName.text.toString()
                val clinic: String = etxClinic.text.toString()
                val number: String = etxNumber.text.toString()
                val edit = prefs.edit()
                edit.putString("key1", "Nombre: $name")
                edit.putString("key2", "Clinica: $clinic")
                edit.putString("key3", "N° de la dosis: $number")
                edit.apply()
                Alerta("Hemos actualizado los datos")
                etxClinic.setText("")
                etxName.setText("")
                etxNumber.setText("")
            }


        }
        /*Se configura lo que hará el boton "Guardar"
        Y se se llama al Intent
 */
    show.setOnClickListener {
    val intent = Intent(this, Resultado::class.java).apply {

    }
    startActivity(intent)

}

//Crea una funcion para que muestre una alerta a la hora de guradar los datos
}
private fun Alerta(message: String){
val builder = AlertDialog.Builder(this)
builder.setTitle("Registro")
builder.setMessage(message)
val dialog = builder.create()
dialog.show()

}
    //Se crea la funcion para que se muestre el menu sobre la BarAction
override fun onCreateOptionsMenu(menu: Menu): Boolean {
val inflater: MenuInflater = menuInflater
inflater.inflate(R.menu.menu, menu)
return true
}
    /*Se crea una funcion para que al tapear sobre un item nos lleve
    al inten deseado
     */
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