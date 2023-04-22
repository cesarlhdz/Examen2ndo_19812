package com.example.parcial2_19812

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PerfilActivity : AppCompatActivity() {
    private lateinit var etDueno: EditText
    private lateinit var etGato: EditText
    private lateinit var etEdad: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        etDueno = findViewById(R.id.etDueno)
        etEdad = findViewById(R.id.etEdad)
        etGato = findViewById(R.id.etGato)

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener {
            Toast.makeText(this, "Preferencias Guardadas", Toast.LENGTH_SHORT).show()
            val dueno = etDueno.text.toString()
            val edad = etEdad.text.toString()
            val gato = etGato.text.toString()

            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
            val editor = sharedPreferences.edit()

            editor.putString("Nombre", dueno)
            editor.putString("Edad", edad)
            editor.putString("Gato", gato)
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    /*
    override fun onResume() {
        super.onResume()
        val sharedPref = getSharedPreferences("Datos Guardados", Context.MODE_PRIVATE)
        etDueno.text = sharedPref.getString("Nombre", "")
        etEdad.text = sharedPref.getInt("Edad", 0).toString()
        etGato.text = sharedPref.getString("Gato", "")
    }
     */
}

