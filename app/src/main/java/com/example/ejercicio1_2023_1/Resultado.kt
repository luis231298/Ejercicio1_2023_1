package com.example.ejercicio1_2023_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.ejercicio1_2023_1.databinding.ActivityMainBinding
import com.example.ejercicio1_2023_1.databinding.ActivityResultadoBinding


class Resultado : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    //var txtPres: TextView?=null
    var txtNombre: TextView?=null
    var txtCorreo: TextView?=null
    var txtEdad: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val correo = bundle?.getString("Correo",  "")
        val nombre = bundle?.getString("Nombre",  "")
        val noCuenta = bundle?.getString("noCuenta","")
        val fecha = bundle?.getString("Fecha","")
        val edad = bundle?.getString("Edad","")


        /*Toast.makeText(this@Resultado, "Tu correo es: $correo", Toast.LENGTH_LONG).show()
        Toast.makeText(this@Resultado, "Tu nombre es: $nombre", Toast.LENGTH_LONG).show()
        Toast.makeText(this@Resultado, "Tu No de cuenta es: $noCuenta", Toast.LENGTH_LONG).show()
        Toast.makeText(this@Resultado, "Tu Fecha es: $fecha", Toast.LENGTH_LONG).show()
        Toast.makeText(this@Resultado, "Tu Edad es: $edad", Toast.LENGTH_LONG).show()*/

        //txtPres = binding.txtNombre
        txtNombre = binding.txtNombre2
        txtCorreo = binding.txtCorreo2
        txtEdad = binding.txtEdad2

        //txtPres?.setText(R.string.Saludo)
        txtNombre?.setText(nombre)
        txtCorreo?.setText(correo)
        txtEdad?.setText(edad)
    }


}