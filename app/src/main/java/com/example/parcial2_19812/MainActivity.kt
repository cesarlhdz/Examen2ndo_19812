package com.example.parcial2_19812

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2_19812.adapters.ImageAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val images = listOf(
            R.drawable.cat,
            R.drawable.profile,
            R.drawable.config,
            R.drawable.close
        )

        val texts = arrayOf("Gatos", "Perfil", "Configurar", "Cerrar")

        recyclerView.adapter = ImageAdapter(images, texts,this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_wifi -> {
                val connectivityManager =
                    getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo = connectivityManager.activeNetworkInfo

                if (networkInfo != null && networkInfo.isConnected) {
                    Toast.makeText(
                        this,
                        "El dispositivo está conectado a una red",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "El dispositivo no está conectado a una red",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}