package com.example.ejercicio1_2023_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.example.ejercicio1_2023_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View){

        if (binding.ETNombre.text.isNotEmpty()){
            val nombre = binding.ETNombre.text.toString()
            Toast.makeText(this@MainActivity,"Campo de nombre correcto",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@MainActivity,"Campo de nombre vacio",Toast.LENGTH_SHORT).show()
        }

        if (binding.etnNoDeCuenta.text.isNotEmpty()){
            val numeroCuenta = binding.etnNoDeCuenta.text.toString()
            if (noCuenta(numeroCuenta)) {
                Toast.makeText(this@MainActivity,"No de cuenta valido",Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this@MainActivity,"Campo del No. de cuenta vacio",Toast.LENGTH_SHORT).show()
        }

        if (binding.ETCorreo.text.isNotEmpty()){
            val correo = binding.ETCorreo.text.toString()
            if (Correo(correo)){
                Toast.makeText(this@MainActivity,"Correo valido",Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this@MainActivity,"Campo de correo vacio",Toast.LENGTH_SHORT).show()
        }

    }

    //funcion encargada de comprobar los valores del no. de cuenta
    fun noCuenta(numero: String): Boolean{
        if(numero.length == 9){
            Toast.makeText(this@MainActivity, "El número de cuenta valido",Toast.LENGTH_SHORT).show()
            return true
        }
        else {
            Toast.makeText(this@MainActivity, "El número de cuenta no tiene 9 digitos",Toast.LENGTH_SHORT).show()
            return false
        }
    }

    fun Correo(correo: String): Boolean{
        if (PatternsCompat.EMAIL_ADDRESS.matcher(correo).matches()){
            Toast.makeText(this@MainActivity,"Correo valido",Toast.LENGTH_SHORT).show()
            return true
        }
        else {
            Toast.makeText(this@MainActivity, "El correo no tiene un formato valido",Toast.LENGTH_SHORT).show()
            return false
        }
    }

}