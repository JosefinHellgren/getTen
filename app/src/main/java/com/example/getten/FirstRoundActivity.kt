package com.example.getten

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class FirstRoundActivity : AppCompatActivity() {
    lateinit var cardleftTextView: TextView
    lateinit var cardRightTextView: TextView
    lateinit var cardLeftCardView: CardView
    lateinit var cardRightCardView: CardView
    lateinit var textViewScore: TextView
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_round)
        cardLeftCardView = findViewById(R.id.kort1)
        cardRightCardView = findViewById(R.id.kort2)
        cardleftTextView = findViewById(R.id.cardContentLeft)
        cardRightTextView = findViewById(R.id.cardContentRight)

        textView = findViewById<TextView>(R.id.textView2)
        /*buttonLeft = findViewById(R.id.choiceButtonLeft)
        buttonRight = findViewById(R.id.choiceButtonRight)*/
        val mIntent = intent
        var numberOfPLayers = intent.getIntExtra("NR_OF_PLAYERS", 0)
        var playersTurn = intent.getIntExtra("PLAYERS_TURN", 0)
        var player1Score = intent.getIntExtra("PLAYER_1_SCORE", 0)
        var player2Score = intent.getIntExtra("PLAYER_2_SCORE", 0)
        var rounds = intent.getIntExtra("NR_OF_ROUNDS", 0)



        textView.text = "Your turn P$playersTurn"
        var rightCard = CardDeck.drawCard()
        var leftCard = CardDeck.drawCard()
        cardleftTextView.text = "${leftCard.value}"
        cardRightTextView.text = "${rightCard.value}"

        cardLeftCardView.setOnClickListener {
            val intent = Intent(this, SecondRoundActivity::class.java)
            intent.putExtra("CARD_1", leftCard)
            intent.putExtra("NR_OF_PLAYERS", numberOfPLayers)
            intent.putExtra("PLAYERS_TURN", playersTurn)
            intent.putExtra("PLAYER_1_SCORE", player1Score)
            intent.putExtra("PLAYER_2_SCORE", player2Score)
            intent.putExtra("NR_OF_ROUNDS", rounds)


            startActivity(intent)
        }

        cardRightCardView.setOnClickListener {
            val intent = Intent(this, SecondRoundActivity::class.java)
            intent.putExtra("CARD_1", rightCard)
            intent.putExtra("NR_OF_PLAYERS", numberOfPLayers)
            intent.putExtra("PLAYERS_TURN", playersTurn)
            intent.putExtra("PLAYER_1_SCORE", player1Score)
            intent.putExtra("PLAYER_2_SCORE", player2Score)
            intent.putExtra("NR_OF_ROUNDS", rounds)


            startActivity(intent)
        }
    }
}













