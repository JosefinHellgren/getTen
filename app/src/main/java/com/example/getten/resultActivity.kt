package com.example.getten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
        var buttonRestart = findViewById<Button>(R.id.restartButton)


        val mIntent = intent
        val chosenCard2 = intent.getSerializableExtra("CARD") as Card
        val firstSavedCard = intent.getSerializableExtra("FirstSavedCard") as Card
        val secondCard = intent.getSerializableExtra("secondCard") as Card
        var nrOfPlayers = intent.getIntExtra("NR_OF_PLAYERS",0)
        var playersTurn = intent.getIntExtra("PLAYERS_TURN",0)
        var player1Score = intent.getIntExtra("PLAYER_1_SCORE",0)
        var player2Score = intent.getIntExtra("PLAYER_2_SCORE",0)
        var rounds = intent.getIntExtra("NR_OF_TURNS",0)

        /*if(rounds==2){
            rounds++
            player1Score=0
            player2Score=0
            playersTurn=1
            buttonPlay.visibility =View.GONE
            if(player1Score>player2Score){
                textView.text="Player 1 is the winner, congratulation"
                 if (player2Score>player1Score){
                    textView.text = "Player 2 is the winner, congratulation"


                }else{
                    textView.text = "Both of you are either winner or losers"
                }

            }
        }*/
        //counts so it gets addition when overload and subtraction when underload
        var sum = 0
        var sum3 = chosenCard2.value + firstSavedCard.value
        if (sum3 >= 10) {
            sum = sum3 - secondCard!!.value
        } else if (sum3 <= 10) {
            sum = sum3 + secondCard.value
        }
        //adds to the playersscore if reached 10
        //and tells the user if they reached ten or not
        if (sum == 10) {
            if(playersTurn==1){
                player1Score++
            }else{
                player2Score++
            }

            textview1.text = "You got ${sum} good job!"

        } else {
            textview1.text = "you got ${sum},not 10, sorry,not sorry"
        }

        //if its one player only the restart button is visible
        //
        if(nrOfPlayers==2) {
         buttonPlay.visibility= View.VISIBLE

        }
        else{
            buttonPlay.visibility= View.GONE

        }
              Log.i("resultActivity","playerOneScore:$player1Score")
                Log.i("resultActivity", "playertwoScore:$player2Score")
        //when clicking the playbutton players turn changes to the other player
        //here i want to count the rounds so i can stop the game at x amount of rounds in the if
        //statement higher up
        buttonPlay.setOnClickListener() {
            rounds++
            if(rounds==2){
                player1Score=0
                player2Score=0
                playersTurn=1
                buttonPlay.visibility =View.GONE
                if(player1Score>player2Score){
                    textView.text="Player 1 is the winner, congratulation"
                    if (player2Score>player1Score){
                        textView.text = "Player 2 is the winner, congratulation"


                    }else{
                        textView.text = "Both of you are either winner or losers"
                    }

                }
            }
            Log.i("resultActivity","roundsCount:$rounds")
             if(playersTurn==1){
                 playersTurn=2

             }
            else{
                playersTurn=1

             }

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NR_OF_PLAYERS",nrOfPlayers)
            intent.putExtra("PLAYERS_TURN",playersTurn)
            intent.putExtra("PLAYER_1_SCORE",player1Score)
            intent.putExtra("PLAYER_2_SCORE",player2Score)
            intent.putExtra("NR_OF_ROUNDS", rounds)
            startActivity(intent)
        }
        buttonRestart.setOnClickListener() {
            val intent = Intent(this, firstActivity::class.java)
            startActivity(intent)
        }
    }
}