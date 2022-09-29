package com.example.getten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class thirdRound : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var textView4: TextView
    lateinit var textView5: TextView
    lateinit var textView6: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_round)
        /*var buttonCardOne = findViewById<Button>(R.id.button)
        var buttonCardTwo = findViewById<Button>(R.id.button2)
        var buttonCardThree = findViewById<Button>(R.id.button3)
        var buttonCardFour = findViewById<Button>(R.id.button4)*/
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
        val chosenCard2 = intent.getSerializableExtra("CARD") as? Card
        val firstSavedCard = intent.getSerializableExtra("FirstSavedCard") as? Card

        var cardOne = CardDeck.drawCard()
        var cardTwo = CardDeck.drawCard()
        var cardThree = CardDeck.drawCard()
        var cardFour = CardDeck.drawCard()
        operatorImageView.drawable
        textView1.text = "${cardOne.value}"
        textView2.text = "${cardTwo.value}"
        textView3.text = "${cardThree.value}"
        textView4.text = "${cardFour.value}"

        textView5.text = "${firstSavedCard?.value}"
        textView6.text = "${chosenCard2?.value}"

        val sumOfSaved = firstSavedCard!!.value + chosenCard2!!.value


        if (sumOfSaved == 10) {
            val intent = Intent(this, resultActivity::class.java)
            intent.putExtra("CARD",chosenCard2)
            intent.putExtra("FirstSavedCard", firstSavedCard)
            startActivity(intent)
        }
        else{

        cardView1.setOnClickListener() {

            val intent = Intent(this, resultActivity::class.java)
            intent.putExtra("CARD", chosenCard2)
            intent.putExtra("FirstSavedCard", firstSavedCard)
            intent.putExtra("secondCard",cardOne)
            startActivity(intent)
        }

        cardView2.setOnClickListener() {
            val intent = Intent(this, resultActivity::class.java)
            intent.putExtra("CARD", chosenCard2)
            intent.putExtra("FirstSavedCard", firstSavedCard)
            intent.putExtra("secondCard",cardTwo)
            startActivity(intent)

        }

        cardView3.setOnClickListener() {
            val intent = Intent(this, resultActivity::class.java)
            intent.putExtra("CARD", chosenCard2)
            intent.putExtra("FirstSavedCard", firstSavedCard)
            intent.putExtra("secondCard",cardThree)
            startActivity(intent)
        }

        cardView4.setOnClickListener() {
            val intent = Intent(this, resultActivity::class.java)
            intent.putExtra("CARD", chosenCard2)
            intent.putExtra("FirstSavedCard", firstSavedCard)
            intent.putExtra("secondCard", cardFour)
            startActivity(intent)
        }
        }

    }
}
