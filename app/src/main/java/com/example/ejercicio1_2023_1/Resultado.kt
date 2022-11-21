package com.example.ejercicio1_2023_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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
    var txtSigno: TextView?=null
    var imgvSigno: ImageView?=null

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
        val mes = bundle?.getString("Mes","")
        val dia = bundle?.getInt("Dia", 0)

        val horoz = dia?.let { horozcopo(mes.toString(), it) }

        //Toast.makeText(this@Resultado, "Tu Signo es: $horoz", Toast.LENGTH_LONG).show()

        /*Toast.makeText(this@Resultado, "Tu correo es: $correo", Toast.LENGTH_LONG).show()
        Toast.makeText(this@Resultado, "Tu nombre es: $nombre", Toast.LENGTH_LONG).show()
        Toast.makeText(this@Resultado, "Tu No de cuenta es: $noCuenta", Toast.LENGTH_LONG).show()
        Toast.makeText(this@Resultado, "Tu Fecha es: $fecha", Toast.LENGTH_LONG).show()
        Toast.makeText(this@Resultado, "Tu Edad es: $edad", Toast.LENGTH_LONG).show()*/

        //txtPres = binding.txtNombre
        txtNombre = binding.txtNombre2
        txtCorreo = binding.txtCorreo2
        txtEdad = binding.txtEdad2
        txtSigno = binding.txtSigno2


        //txtPres?.setText(R.string.Saludo)
        txtNombre?.setText(nombre)
        txtCorreo?.setText(correo)
        txtEdad?.setText(edad)
        txtSigno?.setText(horoz)
    }

    fun horozcopo(mes:String, dia: Int):String{
        imgvSigno = binding.imgvSigno
        when (mes) {
            "01" -> {//Enero
                if (dia <= 20){
                    imgvSigno?.setImageResource(R.drawable.capricornio)
                    return "Capricornio"
                }else{
                    imgvSigno?.setImageResource(R.drawable.acuario)
                    return "Acuario"
                }
            }
            "02" -> {//Febrero
                if (dia <= 19){
                    imgvSigno?.setImageResource(R.drawable.acuario)
                    return "Acuario"
                }else{
                    imgvSigno?.setImageResource(R.drawable.piscis)
                    return "Piscis"
                }
            }
            "03" -> {//Marzo
                if (dia <= 20){
                    imgvSigno?.setImageResource(R.drawable.piscis)
                    return "Piscis"
                }else{
                    imgvSigno?.setImageResource(R.drawable.aries)
                    return "Aries"
                }
            }
            "04" -> {//Abril
                if (dia <= 20){
                    imgvSigno?.setImageResource(R.drawable.aries)
                    return "Aries"
                }else{
                    imgvSigno?.setImageResource(R.drawable.tauro)
                    return "Tauro"
                }
            }
            "05" -> {//Mayo
                if (dia <= 20){
                    imgvSigno?.setImageResource(R.drawable.tauro)
                    return "Tauro"
                }else{
                    imgvSigno?.setImageResource(R.drawable.geminis)
                    return "Geminis"
                }
            }
            "06" -> {//Junio
                if (dia <= 20){
                    imgvSigno?.setImageResource(R.drawable.geminis)
                    return "Geminis"
                }else{
                    imgvSigno?.setImageResource(R.drawable.cancer)
                    return "Cancer"
                }
            }
            "07" -> {//Julio
                if (dia <= 20){
                    imgvSigno?.setImageResource(R.drawable.cancer)
                    return "Cancer"
                }else{
                    imgvSigno?.setImageResource(R.drawable.leo)
                    return "Leo"
                }
            }
            "08" -> {//Agosto
                if (dia <= 21){
                    imgvSigno?.setImageResource(R.drawable.leo)
                    return "Leo"
                }else{
                    imgvSigno?.setImageResource(R.drawable.virgo)
                    return "Virgo"
                }
            }
            "09" -> {//Septiembre
                if (dia <= 20){
                    imgvSigno?.setImageResource(R.drawable.virgo)
                    return "Virgo"
                }else{
                    imgvSigno?.setImageResource(R.drawable.libra)
                    return "Libra"
                }
            }
            "10" -> {//Octubre
                if (dia <= 20){
                    imgvSigno?.setImageResource(R.drawable.libra)
                    return "Libra"
                }else{
                    imgvSigno?.setImageResource(R.drawable.escorpio)
                    return "Escorpio"
                }
            }
            "11" -> {//NOviembre
                if (dia <= 22){
                    imgvSigno?.setImageResource(R.drawable.escorpio)
                    return "Escorpio"
                }else{
                    imgvSigno?.setImageResource(R.drawable.sagitario)
                    return "Sagitario"
                }
            }
            "12" -> {
                if (dia <= 21){
                    imgvSigno?.setImageResource(R.drawable.sagitario)
                    return "Sagitario"
                }else{
                    imgvSigno?.setImageResource(R.drawable.capricornio)
                    return "Capricornio"
                }
            }
            else -> { // Note the block
                Toast.makeText(this@Resultado,"Mes no encontrado", Toast.LENGTH_SHORT).show()
                return ""
            }
        }
    }


}