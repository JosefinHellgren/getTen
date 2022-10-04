package com.example.getten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
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

        //känns som att ifall jag kunde ta med korten 1 och 2 så vore det sum3
        //och isåfall kunde jag kolla if(sum3==10 || sum==10)

       var  sum = chosenCard1.value + chosenCard2.value

        if (chosenCard3 != null) {
            if (sum >= 10) {
                sum -= chosenCard3.value
            } else if (sum <= 10) {
                sum += chosenCard3.value
            }
        }
        //adds to the playersscore if reached 10
        //and tells the user if they reached ten or not
        //här skulle jag vilja kunna skriva if(sum3==10||sum==10)
        if (sum == 10) {
            if (playersTurn == 1) {
                player1Score++

            } else if (playersTurn == 2) {
                player2Score++

            }

            textview1.text = "You got ${sum} good job!"


        } else {
            textview1.text = "you got ${sum},not 10."

        }

        if (rounds == 2) {


            if (player2Score > player1Score) {
                textView.text = "Winner: Player 2"


            } else if (player1Score > player2Score) {
                textView.text = "Winner: Player 1"


            } else {
                textView.text = "win n loose"


            }

        }
        Log.d("resultActivity", "nr of Players: $nrOfPlayers")
        if (nrOfPlayers == 2 && rounds<2) {
            buttonPlay.visibility = View.VISIBLE

        } else {
            buttonPlay.visibility = View.GONE

        }
        Log.i("resultActivity", "playerOneScore:$player1Score")
        Log.i("resultActivity", "playertwoScore:$player2Score")
        Log.i("resultActivity", "roundsCount:$rounds")
        //when clicking the playbutton players turn changes to the other player
        //here i want to count the rounds so i can stop the game at x amount of rounds in the if
        //statement higher up
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
