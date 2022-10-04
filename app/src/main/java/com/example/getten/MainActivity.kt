package com.example.getten

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    lateinit var cardContentLeft: TextView
    lateinit var cardContentRight: TextView
    lateinit var interactiveCard1: CardView
    lateinit var interactiveCard2: CardView
    lateinit var textViewScore: TextView
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        interactiveCard1 = findViewById(R.id.kort1)
        interactiveCard2 = findViewById(R.id.kort2)
        cardContentLeft = findViewById(R.id.cardContentLeft)
        cardContentRight = findViewById(R.id.cardContentRight)
        textViewScore = findViewById(R.id.textViewscore)
        textView = findViewById<TextView>(R.id.textView2)
        /*buttonLeft = findViewById(R.id.choiceButtonLeft)
        buttonRight = findViewById(R.id.choiceButtonRight)*/
        val mIntent = intent
        var numberOfPLayers =intent.getIntExtra("NR_OF_PLAYERS",0)
        var playersTurn = intent.getIntExtra("PLAYERS_TURN",0)
        var player1Score =intent.getIntExtra("PLAYER_1_SCORE",0)
        var player2Score = intent.getIntExtra("PLAYER_2_SCORE",0)
        var rounds =intent.getIntExtra("NR_OF_ROUNDS",0)



        textView.text="Player: $playersTurn"
        var rightCard = CardDeck.drawCard()
        var leftCard = CardDeck.drawCard()
        cardContentLeft.text = "${leftCard.value}"
        cardContentRight.text = "${rightCard.value}"

        interactiveCard1.setOnClickListener {
            val intent = Intent(this, secondRound::class.java)
            intent.putExtra("CARD", leftCard)
            intent.putExtra("NR_OF_PLAYERS",numberOfPLayers)
            intent.putExtra("PLAYERS_TURN",playersTurn)
            intent.putExtra("PLAYER_1_SCORE",player1Score)
            intent.putExtra("PLAYER_2_SCORE",player2Score)
            intent.putExtra("NR_OF_ROUNDS", rounds)


            startActivity(intent)
        }

        interactiveCard2.setOnClickListener {
            val intent = Intent(this, secondRound::class.java)
            intent.putExtra("CARD", rightCard)
            intent.putExtra("NR_OF_PLAYERS",numberOfPLayers)
            intent.putExtra("PLAYERS_TURN",playersTurn)
            intent.putExtra("PLAYER_1_SCORE",player1Score)
            intent.putExtra("PLAYER_2_SCORE",player2Score)


            startActivity(intent)
        }
    }
}

class Card(var value: Int) : Serializable

object CardDeck {
    fun drawCard(): Card {
        var value = (1..9).random()
        var card = Card(value)

        return card
    }




}






