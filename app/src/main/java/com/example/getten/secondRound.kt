package com.example.getten

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class secondRound : AppCompatActivity() {
    lateinit var cardOneContent: TextView
    lateinit var cardContentTwo: TextView
    lateinit var cardThreeContent: TextView
    lateinit var cardFromActivityOne: TextView
    lateinit var card1: CardView
    lateinit var card2: CardView
    lateinit var card3: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_round)
        cardOneContent = findViewById(R.id.cardOneContent)
        cardContentTwo = findViewById(R.id.cardTwoContent)
        cardThreeContent = findViewById(R.id.cardThreeContent)
        cardFromActivityOne = findViewById(R.id.CardFromActivityOne)
        var cardView1 = findViewById<CardView>(R.id.card1)
        var cardView2 = findViewById<CardView>(R.id.card2)
        var cardView3 = findViewById<CardView>(R.id.card3)


/*
        var score = 0
        var sumOfCards = 0
        textViewScore.text = "current score: $score"
        textViewSumOfCards.text = "The sum of your card is: $sumOfCards"*/
        //get the sent cards

        val mIntent = intent
        val chosenCard = intent.getSerializableExtra("CARD") as Card

        var cardOne = CardDeck.drawCard()
        var cardTwo = CardDeck.drawCard()
        var cardThree = CardDeck.drawCard()
        cardFromActivityOne.text = "${chosenCard.value}"


        //how to not have to manually put in the index of the cardDeck
        cardOneContent.text = "${cardOne.value}"
        cardContentTwo.text = "${cardTwo.value}"
        cardThreeContent.text = "${cardThree.value}"


        cardView1.setOnClickListener() {
            val intent = Intent(this, thirdRound::class.java)
            intent.putExtra("CARD", cardOne)
            intent.putExtra("FirstSavedCard", chosenCard)

            startActivity(intent)

        }
        cardView2.setOnClickListener() {

            val intent = Intent(this, thirdRound::class.java)
            intent.putExtra("CARD", cardTwo)
            intent.putExtra("FirstSavedCard", chosenCard)

            startActivity(intent)

        }
        cardView3.setOnClickListener() {

            val intent = Intent(this, thirdRound::class.java)
            intent.putExtra("CARD", cardThree)
            intent.putExtra("FirstSavedCard", chosenCard)

            startActivity(intent)
        }
    }
}








































