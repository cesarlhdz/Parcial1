package edu.iest.parcial1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var spHorarios: Spinner
    private var cambioIcono : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spHorarios = findViewById(R.id.spHorarios)
        var ivCover = findViewById<ImageView>(R.id.ivCover)
        spHorarios.setOnItemSelectedListener(this)

        ivCover.setOnClickListener{
            var arregloImagenes = arrayOf<Int>(R.drawable.antman, R.drawable.cover2)
            if (cambioIcono) {
                ivCover.setImageResource(arregloImagenes[0])
            }else {
                ivCover.setImageResource(arregloImagenes[1])
            }
            cambioIcono = !cambioIcono
        }

        var tvCerrar= findViewById<TextView>(R.id.tvSlogan)
        tvCerrar.setOnClickListener {
            finish()
        }

    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, posicion: Int, l: Long) {
        val horario: String = adapterView?.getItemAtPosition(posicion).toString()
        if (adapterView != null) {
            if (posicion == 0 || posicion == 2 || posicion == 4) {
                Toast.makeText(this, "Lo sentimos se han agotado las entradas", Toast.LENGTH_LONG)
                    .show()
            } else {
                Snackbar.make(
                    adapterView, "Horario seleccionado $horario", Snackbar.LENGTH_LONG
                ).show()
            }
        }

        var bnComprar = findViewById<Button>(R.id.bnComprar)
        bnComprar.setOnClickListener {
            if (posicion == 0 || posicion == 2 || posicion == 4 ) {
            } else  {
                val i = Intent(this, Confirmacion::class.java)
                i.putExtra("horario", horario)
                startActivity(i)
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}

