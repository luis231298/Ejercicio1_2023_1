package com.example.ejercicio1_2023_1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.util.PatternsCompat
import com.example.ejercicio1_2023_1.databinding.ActivityMainBinding
import java.time.Instant

class MainActivity : AppCompatActivity() {

    var txtFecha:EditText?=null
    var btnFecha:ImageButton?=null
    var dpFecha:DatePicker?=null

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtFecha = binding.txtFecha
        btnFecha = binding.btnFecha
        dpFecha = binding.dpFecha

        txtFecha?.setText(getDataPicker())

        dpFecha?.setOnDateChangedListener {
            dpFecha,anio,mes,dia ->
            txtFecha?.setText(getDataPicker())
            dpFecha?.visibility=View.GONE
        }



    }

    @RequiresApi(Build.VERSION_CODES.O)
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

        if (Fecha()){
            Toast.makeText(this@MainActivity,"Fecha Correcta", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@MainActivity,"Fecha Incorrecta", Toast.LENGTH_SHORT).show()
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun Fecha(): Boolean{
        val horaActual = Instant.now().toString()
        val delimit = "T"
        val delim = "-"



        val time2 = horaActual.split(delimit)
        val fecha2 = time2[0].split(delim)

        val fecha1 = txtFecha?.text.toString().split(delim)

        //Toast.makeText(this@MainActivity,fecha1.toString(),Toast.LENGTH_LONG).show()

        return fecha1[2] <= fecha2[0]



        /*Toast.makeText(this@MainActivity,fecha2.toString(),Toast.LENGTH_LONG).show()
        Toast.makeText(this@MainActivity,anio,Toast.LENGTH_LONG).show()*/

        //return true
    }

    fun getDataPicker():String{
        var dia = dpFecha?.dayOfMonth.toString().padStart(2,'0')
        var mes = (dpFecha!!.month+1).toString().padStart(2,'0')
        var anio = dpFecha?.year.toString().padStart(4,'0')
        return dia+"-"+mes+"-"+anio
    }

    fun muestraCalendario(view: View){
        dpFecha?.visibility= View.VISIBLE
    }

}