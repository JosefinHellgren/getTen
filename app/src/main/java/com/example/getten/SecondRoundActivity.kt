package com.example.getten

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class SecondRoundActivity : AppCompatActivity() {
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
        val mIntent = intent
        val chosenCard1 = intent.getSerializableExtra("CARD_1") as Card
        var nrOfPlayers = intent.getIntExtra("NR_OF_PLAYERS", 0)
        var playersTurn = intent.getIntExtra("PLAYERS_TURN", 0)
        var player1Score = intent.getIntExtra("PLAYER_1_SCORE", 0)
        var player2Score = intent.getIntExtra("PLAYER_2_SCORE", 0)
        var rounds = intent.getIntExtra("NR_OF_ROUNDS", 0)
        var cardOne = CardDeck.drawCard()
        var cardTwo = CardDeck.drawCard()
        var cardThree = CardDeck.drawCard()
        cardFromActivityOne.text = "${chosenCard1.value}"
        cardOneContent.text = "${cardOne.value}"
        cardContentTwo.text = "${cardTwo.value}"
        cardThreeContent.text = "${cardThree.value}"

        var sum3 = cardThree.value + chosenCard1.value
        var sum2 = cardTwo.value + chosenCard1.value
        var sum1 = cardOne.value + chosenCard1.value

        cardView1.setOnClickListener() {
            if (sum1 == 10) {
                //när jag skickar med korten som finns här blir det crash
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("SUM_OF_SECOND_ROUNDS",sum1)
                intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
                intent.putExtra("NR_OF_ROUNDS", rounds)
                intent.putExtra("PLAYER_1_SCORE", player1Score)
                intent.putExtra("PLAYER_2_SCORE", player2Score)
                intent.putExtra("PLAYERS_TURN", playersTurn)
                intent.putExtra("CARD_1", cardOne)
                intent.putExtra("CARD_2", chosenCard1)

                startActivity(intent)


            } else {
                val intent = Intent(this, ThirdRoundActivity::class.java)
                intent.putExtra("CARD_1", cardOne)
                intent.putExtra("CARD_2", chosenCard1)
                intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
                intent.putExtra("PLAYERS_TURN", playersTurn)
                intent.putExtra("PLAYER_1_SCORE", player1Score)
                intent.putExtra("PLAYER_2_SCORE", player2Score)
                intent.putExtra("NR_OF_ROUNDS", rounds)
                intent.putExtra("SUM_IF_TEN", sum1)
                startActivity(intent)

            }
        }




        cardView2.setOnClickListener() {
            if (sum2 == 10) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("SUM_OF_SECOND_ROUND",sum2)
                intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
                intent.putExtra("NR_OF_ROUNDS", rounds)
                intent.putExtra("PLAYER_1_SCORE", player1Score)
                intent.putExtra("PLAYER_2_SCORE", player2Score)
                intent.putExtra("PLAYERS_TURN", playersTurn)
                intent.putExtra("CARD_1", cardOne)
                intent.putExtra("CARD_2", chosenCard1)

                startActivity(intent)
            } else {
                val intent = Intent(this, ThirdRoundActivity::class.java)
                intent.putExtra("CARD_1", cardTwo)
                intent.putExtra("CARD_2", chosenCard1)
                intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
                intent.putExtra("PLAYERS_TURN", playersTurn)
                intent.putExtra("PLAYER_1_SCORE", player1Score)
                intent.putExtra("PLAYER_2_SCORE", player2Score)
                intent.putExtra("NR_OF_ROUNDS", rounds)
                intent.putExtra("SUM_IF_TEN", sum2)

                startActivity(intent)
            }
        }


        cardView3.setOnClickListener() {
            if (sum3 == 10) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("SUM_OF_SECOND_ROUND",sum3)
                intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
                intent.putExtra("NR_OF_ROUNDS", rounds)
                intent.putExtra("PLAYER_1_SCORE", player1Score)
                intent.putExtra("PLAYER_2_SCORE", player2Score)
                intent.putExtra("PLAYERS_TURN", playersTurn)
                intent.putExtra("CARD_1", cardThree)
                intent.putExtra("CARD_2", chosenCard1)

                startActivity(intent)

            } else {
                val intent = Intent(this, ThirdRoundActivity::class.java)
                intent.putExtra("CARD_1", cardThree)
                intent.putExtra("CARD_2", chosenCard1)
                intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
                intent.putExtra("PLAYERS_TURN", playersTurn)
                intent.putExtra("PLAYER_1_SCORE", player1Score)
                intent.putExtra("PLAYER_2_SCORE", player2Score)
                intent.putExtra("NR_OF_ROUNDS", rounds)
                intent.putExtra("SUM_IF_TEN", sum3)

                startActivity(intent)


            }

        }
    }
}











































