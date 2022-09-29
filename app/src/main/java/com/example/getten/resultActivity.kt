package com.example.getten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var textview1: TextView
    lateinit var textView2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        textView = findViewById(R.id.textViewresult)
        textview1 = findViewById(R.id.score)
        textView2 = findViewById(R.id.scorekeeper)
        var buttonPlay = findViewById<Button>(R.id.buttonPlay)


        val mIntent = intent
        val chosenCard2 = intent.getSerializableExtra("CARD") as Card
        val firstSavedCard = intent.getSerializableExtra("FirstSavedCard") as Card
        val secondCard = intent.getSerializableExtra("secondCard") as Card


        var sum = 0
        var sum3 = chosenCard2.value + firstSavedCard.value
        if (sum3 >= 10) {
             sum = sum3 - secondCard!!.value
        } else if (sum3 <= 10) {
            sum = sum3 + secondCard.value /*?:0*/
        }

        if (sum == 10) {

            textview1.text = "You got ${sum} good job!"

        } else {
            textview1.text = "you got ${sum},not 10, sorry"
        }

        textView2.text

        buttonPlay.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}