package com.example.ejercicio1_2023_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.ejercicio1_2023_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View){
        //funcion encargada de comprobar los valores del no. de cuenta
        if (binding.etnNoDeCuenta.text.isNotEmpty()){
            val numeroCuenta = binding.etnNoDeCuenta.text.toString()
            if (noCuenta(numeroCuenta)) {
                Toast.makeText(this@MainActivity,"Valido",Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this@MainActivity,"Campo del No. de cuenta vacio",Toast.LENGTH_SHORT).show()
        }




    }

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

}