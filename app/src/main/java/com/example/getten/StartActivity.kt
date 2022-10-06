package com.example.getten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class StartActivity : AppCompatActivity() {
    lateinit var textViewPlayer1: TextView
    lateinit var textViewPlayer2: TextView
    lateinit var  ortryAgainTextView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        ortryAgainTextView=findViewById(R.id.orTryAgainTextView)
        var onePlayerCardview1 = findViewById<CardView>(R.id.onePlayerCardview1)
        var twoPlayerCardView2 = findViewById<CardView>(R.id.twoPlayerCardview2)



        onePlayerCardview1.setOnClickListener() {
            val intent = Intent(this, FirstRoundActivity::class.java)
            intent.putExtra("NR_OF_PLAYERS", 1)
            intent.putExtra("PLAYERS_TURN", 1)

            startActivity(intent)
        }
        twoPlayerCardView2.setOnClickListener() {
            val intent = Intent(this, FirstRoundActivity::class.java)
            intent.putExtra("NR_OF_PLAYERS", 2)
            intent.putExtra("PLAYERS_TURN", 1)



            startActivity(intent)
        }

    }
}