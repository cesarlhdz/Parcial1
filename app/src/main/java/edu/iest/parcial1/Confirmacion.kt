package edu.iest.parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Confirmacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        var horario = intent.getStringExtra("horario")
        Toast.makeText(this,"El horario Seleccionado fue: "+ horario, Toast.LENGTH_LONG).show()
    }
}