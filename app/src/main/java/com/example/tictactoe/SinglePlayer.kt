package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_single_player.*
import kotlin.random.Random

class SinglePlayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_player)
    }

    fun buClick(view : View)
    {
        val buSelected = view as Button
        var cellId = 0
        when(buSelected.id){
            R.id.btn_1 -> cellId = 1
            R.id.btn_2 -> cellId = 2
            R.id.btn_3 -> cellId = 3
            R.id.btn_4 -> cellId = 4
            R.id.btn_5 -> cellId = 5
            R.id.btn_6 -> cellId = 6
            R.id.btn_7 -> cellId = 7
            R.id.btn_8 -> cellId = 8
            R.id.btn_9 -> cellId = 9
        }
        playGame(cellId,buSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    private var counter = 0;

    private fun playGame(cellId: Int, buSelected: Button)
    {
        if(activePlayer == 1)
        {
            counter += 1
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        }
        else
        {
            counter += 1
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.GRAY)
            player2.add(cellId)
            activePlayer = 1
        }
        buSelected.isEnabled = false

        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1
        //for row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //for row 2
        else if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        //for row 3
        else if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //for column 1
        else if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //for column 2
        else if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //for column 3
        else if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //for diagonal 1
        else if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        //for diagonal 2
        else if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        } else if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1 && counter < 8) {
            if (winner == 1) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("WINNER WINNER TIC TAC TOE WINNER")   //set title for alert dialog
                builder.setMessage("You Win's The Match!! Keep It Up")  //set message for alert dialog
                builder.setIcon(R.drawable.alert_message_icon)   // set icon for alert dialog message

                //performing positive action
                builder.setPositiveButton("REPLAY") { dialogInterface, which ->
                    val intent = Intent(this, SinglePlayer::class.java)
                    startActivity(intent)
                    finish()
                }

                //performing negative action
                builder.setNegativeButton("No") { dialogInterface, which ->
                    super.onBackPressed()
                }
                builder.show()
            } else if (winner == 2) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("LOOSER LOOSER LOOSER")   //set title for alert dialog
                builder.setMessage("You Loose The Match!! Better Luck Next Time")  //set message for alert dialog
                builder.setIcon(R.drawable.alert_message_icon)   // set icon for alert dialog message

                //performing positive action
                builder.setPositiveButton("REPLAY") { dialogInterface, which ->
                    val intent = Intent(this, SinglePlayer::class.java)
                    startActivity(intent)
                    finish()
                }
                //performing negative action
                builder.setNegativeButton("No") { dialogInterface, which ->
                    super.onBackPressed()
                }
                builder.show()
            }
        } else if (counter == 8) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("IT'S A TIE")   //set title for alert dialog
            builder.setMessage("Better Luck Next Time")  //set message for alert dialog
            builder.setIcon(R.drawable.its_a_tie)   // set icon for alert dialog message

            //performing positive action
            builder.setPositiveButton("REPLAY") { dialogInterface, which ->
                val intent = Intent(this, SinglePlayer::class.java)
                startActivity(intent)
                finish()
            }
            //performing negative action
            builder.setNegativeButton("No") { dialogInterface, which ->
                super.onBackPressed()
            }
            builder.show()
        }
    }

    private fun autoPlay()
    {
        val emptyCell = ArrayList<Int>()
        for(cellId in 1..9)
        {
            if(!(player1.contains(cellId) || player2.contains(cellId)))
            {
                emptyCell.add(cellId)
            }
        }
        val r= Random
        val randIndex = r.nextInt(emptyCell.size-0)+0
        val cellId = emptyCell[randIndex]
        val buSelected:Button
        when(cellId){
            1->buSelected = btn_1
            2->buSelected = btn_2
            3->buSelected = btn_3
            4->buSelected = btn_4
            5->buSelected = btn_5
            6->buSelected = btn_6
            7->buSelected = btn_7
            8->buSelected = btn_8
            9->buSelected = btn_9
            else -> buSelected = btn_1
        }
        playGame(cellId,buSelected)

        btn_replay.setOnClickListener {

            val intent = Intent(this,SinglePlayer::class.java)
            startActivity(intent)
            finish()
        }
    }
}
