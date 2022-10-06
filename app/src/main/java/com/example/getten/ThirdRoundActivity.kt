package com.example.getten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class ThirdRoundActivity : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var textView4: TextView
    lateinit var textView5: TextView
    lateinit var textView6: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_round)
        textView1 = findViewById(R.id.textViewOne)
        textView2 = findViewById(R.id.textViewTwo)
        textView3 = findViewById(R.id.textViewThree)
        textView4 = findViewById(R.id.textViewFour)
        textView5 = findViewById(R.id.textViewSavedLeft)
        textView6 = findViewById(R.id.textViewSavedRight)
        var cardView1 = findViewById<CardView>(R.id.cardViewOne)
        var cardView2 = findViewById<CardView>(R.id.cardViewTwo)
        var cardView3 = findViewById<CardView>(R.id.cardViewThree)
        var cardView4 = findViewById<CardView>(R.id.cardViewFour)
        var operatorImageView = findViewById<ImageView>(R.id.operatorImageView)


        val mIntent = intent
        val chosenCard1 = intent.getSerializableExtra("CARD_1") as? Card
        val chosenCard2 = intent.getSerializableExtra("CARD_2") as? Card
        var playersTurn = intent.getIntExtra("PLAYERS_TURN", 0)
        var player1Score = intent.getIntExtra("PLAYER_1_SCORE", 0)
        var player2Score = intent.getIntExtra("PLAYER_2_SCORE", 0)
        var nrOfPlayers = intent.getIntExtra("NR_OF_PLAYERS", 0)
        var rounds = intent.getIntExtra("NR_OF_ROUNDS", 0)


        var cardOne = CardDeck.drawCard()
        var cardTwo = CardDeck.drawCard()
        var cardThree = CardDeck.drawCard()
        var cardFour = CardDeck.drawCard()
        textView1.text = "${cardOne.value}"
        textView2.text = "${cardTwo.value}"
        textView3.text = "${cardThree.value}"
        textView4.text = "${cardFour.value}"
        textView5.text = "${chosenCard2?.value}"
        textView6.text = "${chosenCard1?.value}"

        var sum =chosenCard1!!.value+chosenCard2!!.value
        Log.d("ThirdRoundActivity","what is the value of $sum")
        if (sum>=10){
            operatorImageView.setImageResource(R.drawable.minus)
        }else{
            operatorImageView.setImageResource(R.drawable.plusiconblack2)

        }


        cardView1.setOnClickListener() {

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("CARD_1", chosenCard1)
            intent.putExtra("CARD_2", chosenCard2)
            intent.putExtra("CARD_3", cardOne)
            intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
            intent.putExtra("PLAYERS_TURN", playersTurn)
            intent.putExtra("PLAYER_1_SCORE", player1Score)
            intent.putExtra("PLAYER_2_SCORE", player2Score)
            intent.putExtra("NR_OF_ROUNDS", rounds)
            startActivity(intent)
        }

        cardView2.setOnClickListener() {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("CARD_1", chosenCard1)
            intent.putExtra("CARD_2", chosenCard2)
            intent.putExtra("CARD_3", cardTwo)
            intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
            intent.putExtra("PLAYERS_TURN", playersTurn)
            intent.putExtra("PLAYER_1_SCORE", player1Score)
            intent.putExtra("PLAYER_2_SCORE", player2Score)
            intent.putExtra("NR_OF_ROUNDS", rounds)

            startActivity(intent)

        }

        cardView3.setOnClickListener() {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("CARD_1", chosenCard1)
            intent.putExtra("CARD_2", chosenCard2)
            intent.putExtra("CARD_3", cardThree)
            intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
            intent.putExtra("PLAYERS_TURN", playersTurn)
            intent.putExtra("PLAYER_1_SCORE", player1Score)
            intent.putExtra("PLAYER_2_SCORE", player2Score)
            intent.putExtra("NR_OF_ROUNDS", rounds)


            startActivity(intent)
        }

        cardView4.setOnClickListener() {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("CARD_1", chosenCard1)
            intent.putExtra("CARD_2", chosenCard2)
            intent.putExtra("CARD_3", cardFour)
            intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
            intent.putExtra("PLAYERS_TURN", playersTurn)
            intent.putExtra("PLAYER_1_SCORE", player1Score)
            intent.putExtra("PLAYER_2_SCORE", player2Score)
            intent.putExtra("NR_OF_ROUNDS", rounds)

            startActivity(intent)
        }
    }

}

