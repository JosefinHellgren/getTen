package com.example.getten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class firstActivity : AppCompatActivity() {
    lateinit var textViewPlayer1 : TextView
    lateinit var textViewPlayer2 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        textViewPlayer1 = findViewById(R.id.textViewplayer1)
        textViewPlayer2 = findViewById(R.id.textViewplayer2)
        textViewPlayer1.text = "1 player"
        textViewPlayer2.text = "2 players"

        var turns = 0
        var whoseTurn = 0
        var player1Score=0
        var player2Score=0
        var score=0
        textViewPlayer1.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("TURNS", turns)
            intent.putExtra("WHOOSE_TURN", whoseTurn)
            intent.putExtra("SINGLESCORE",score)



            startActivity(intent)
        }
        textViewPlayer2.setOnClickListener(){
            turns++
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("TURNS", turns)
            intent.putExtra("WHOOSE_TURN", whoseTurn)
            intent.putExtra("PLAYERONESCORE",player1Score)
            intent.putExtra("PLAYERTWOSCORE", player2Score)

            startActivity(intent)
        }

    }
}