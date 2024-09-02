package com.example.knb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        val paperChoiceCardView = findViewById<CardView>(R.id.paperChoiceCardView)
        val scissorsChoiceCardView = findViewById<CardView>(R.id.scissorsChoiceCardView)
        val rockChoiceCardView = findViewById<CardView>(R.id.rockChoiceCardView)

        scissorsChoiceCardView.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("key","Ножницы")
            startActivity(intent)
        }
        rockChoiceCardView.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("key", "Камень")
            startActivity(intent)
        }
        paperChoiceCardView.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("key","Бумага")
            startActivity(intent)
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}