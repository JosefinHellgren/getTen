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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        interactiveCard1 = findViewById(R.id.kort1)
        interactiveCard2 = findViewById(R.id.kort2)
        cardContentLeft = findViewById(R.id.cardContentLeft)
        cardContentRight = findViewById(R.id.cardContentRight)
        textViewScore = findViewById(R.id.textViewscore)
        /*buttonLeft = findViewById(R.id.choiceButtonLeft)
        buttonRight = findViewById(R.id.choiceButtonRight)*/
        val mIntent = intent
        val turns = intent.getSerializableExtra("TURNS")
        val whooseTurn = intent.getSerializableExtra("WHOOSE_TURN")


        var rightCard = CardDeck.drawCard()
        var leftCard = CardDeck.drawCard()
        cardContentLeft.text = "${leftCard.value}"
        cardContentRight.text = "${rightCard.value}"

        interactiveCard1.setOnClickListener {
            val intent = Intent(this, secondRound::class.java)
            intent.putExtra("CARD", leftCard)

            startActivity(intent)
        }

        interactiveCard2.setOnClickListener {
            val intent = Intent(this, secondRound::class.java)
            intent.putExtra("CARD", rightCard)

            startActivity(intent)
        }
    }

}

class Card(var value: Int) : Serializable

object CardDeck {
    var cards = mutableListOf<Card>()
    fun drawCard(): Card{

        return cards.removeAt(0)
    }
    init{

        for (i in (1..100)) {
            var value = (1..9).random()
            var card = Card(value)
            CardDeck.cards.add(card)
        }
    }

}






