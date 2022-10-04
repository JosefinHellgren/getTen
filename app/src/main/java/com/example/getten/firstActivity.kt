package com.example.getten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class firstActivity : AppCompatActivity() {
    lateinit var textViewPlayer1: TextView
    lateinit var textViewPlayer2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        textViewPlayer1 = findViewById(R.id.textViewplayer1)
        textViewPlayer2 = findViewById(R.id.textViewplayer2)
        textViewPlayer1.text = "1 player"
        textViewPlayer2.text = "2 players"



        textViewPlayer1.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NR_OF_PLAYERS",1)
            intent.putExtra("PLAYERS_TURN",1)
            intent.putExtra("NR_OF_ROUNDS", 0)
            startActivity(intent)
        }
        textViewPlayer2.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NR_OF_PLAYERS",2)
            intent.putExtra("PLAYERS_TURN",1)
            intent.putExtra("NR_OF_ROUNDS", 0)


            startActivity(intent)
        }

    }
}