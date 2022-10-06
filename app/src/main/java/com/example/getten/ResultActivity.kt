package com.example.getten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var textview1: TextView
    lateinit var textView2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        textView = findViewById(R.id.textViewresult)
        textview1 = findViewById(R.id.score)
        var buttonPlay = findViewById<Button>(R.id.buttonPlay)
        var buttonRestart = findViewById<Button>(R.id.restartButton)
        var resultImageView =findViewById<ImageView>(R.id.totoroWinimageView)
        val mIntent = intent
        val chosenCard1 = intent.getSerializableExtra("CARD_1") as Card
        val chosenCard2 = intent.getSerializableExtra("CARD_2") as Card
        val chosenCard3 = intent.getSerializableExtra("CARD_3") as? Card
        var nrOfPlayers = intent.getIntExtra("NR_OF_PLAYERS", 0)
        var playersTurn = intent.getIntExtra("PLAYERS_TURN", 0)
        var player1Score = intent.getIntExtra("PLAYER_1_SCORE", 0)
        var player2Score = intent.getIntExtra("PLAYER_2_SCORE", 0)
        var rounds = intent.getIntExtra("NR_OF_ROUNDS", 0)
        var sumOfSecondRounds = intent.getIntExtra("SUM_OF_SECOND_ROUNDS", 0)
        rounds++
        var  sum = chosenCard1.value + chosenCard2.value

        if (chosenCard3 != null) {
            if (sum >= 10) {
                sum -= chosenCard3.value
            } else if (sum <= 10) {
                sum += chosenCard3.value
            }
        }

        if (sum == 10) {
            if (playersTurn == 1) {
                player1Score++

            } else if (playersTurn == 2) {
                player2Score++

            }

            textview1.text = "You got ${sum} good job!"
            resultImageView.setImageResource(R.drawable.totoroleaf)


        } else {
            textview1.text = "you got ${sum},not 10."
            resultImageView.setImageResource(R.drawable.tototonowin)

        }

        if (rounds == 2) {


            if (player2Score > player1Score) {
                textView.text = "Player 2"
                textview1.text ="your the winner"
            resultImageView.setImageResource(R.drawable.totoroovinn)

            } else if (player1Score > player2Score) {
                textView.text = "Player 1 "
                textview1.text = "your the winner"
                resultImageView.setImageResource(R.drawable.totoroovinn)

            } else if(player1Score==1&&player2Score==1) {
                textView.text = "WIN WIN"
                textview1.text="both of you"
                resultImageView.setImageResource(R.drawable.totoroovinn)

            }else{
                textView.text="LOSE LOSE"
                textview1.text="both of you"
                resultImageView.setImageResource(R.drawable.tototonowin)
            }

        }

        if (nrOfPlayers == 2 && rounds<2) {
            buttonPlay.visibility = View.VISIBLE

        } else {
            buttonPlay.visibility = View.GONE

        }

        buttonPlay.setOnClickListener()
        {


            if (playersTurn == 1) {
                playersTurn = 2

            } else {
                playersTurn = 1

            }

            val intent = Intent(this, FirstRoundActivity::class.java)
            intent.putExtra("NR_OF_PLAYERS", nrOfPlayers)
            intent.putExtra("PLAYERS_TURN", playersTurn)
            intent.putExtra("PLAYER_1_SCORE", player1Score)
            intent.putExtra("PLAYER_2_SCORE", player2Score)
            intent.putExtra("NR_OF_ROUNDS", rounds)
            startActivity(intent)
        }
        buttonRestart.setOnClickListener()
        {




            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }
    }
}
