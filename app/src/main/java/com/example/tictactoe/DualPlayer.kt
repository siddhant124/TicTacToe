package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dual_player.*

class DualPlayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dual_player)

        //for showing names
        val name = intent.getStringExtra("key")
        val name2 = intent.getStringExtra("key1")

        p1n.text = name
        p2n.text = name2

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
        //Toast.makeText(this,"selected cell is: $cellId",Toast.LENGTH_SHORT).show()
        playGame(cellId,buSelected)
    }


    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var activePlayer = 1
    private var counter = 0


    private fun playGame(cellId: Int, buSelected: Button) {
        if (activePlayer == 1) {
            counter += 1
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer = 2
        } else {
            counter+=1
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
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner = 1
        }
        else if (player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner = 2
        }

        //for row 2
        else if (player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner = 1
        }
        else if (player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner = 2
        }

        //for row 3
        else if (player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner = 1
        }
        else if (player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner = 2
        }

        //for column 1
        else if (player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner = 1
        }
        else if (player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner = 2
        }

        //for column 2
        else if (player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner = 1
        }
        else if (player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner = 2
        }

        //for column 3
        else if (player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner = 1
        }
        else if (player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner = 2
        }

        //for diagonal 1
        else if (player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner = 1
        }
        else if (player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner = 2
        }

        //for diagonal 2
        else if (player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner = 1
        }
        else if (player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner = 2
        }
        if (winner != -1 && counter<=9)
        {
            if (winner == 1)
            {
                val name = intent.getStringExtra("key")
                val builder = AlertDialog.Builder(this)
                builder.setTitle("WINNER WINNER TIC TAC TOE WINNER")   //set title for alert dialog
                builder.setMessage("\"$name\" Win's The Match!! Keep It Up")  //set message for alert dialog
                builder.setIcon(R.drawable.alert_message_icon)   // set icon for alert dialog message

                //performing positive action
                builder.setPositiveButton("REPLAY") {dialogInterface, which ->
                    val intent = Intent(this,PlayersName::class.java)
                    startActivity(intent)
                    finish()
                }
                //performing negative action
                builder.setNegativeButton("No") {dialogInterface, which ->
                    super.onBackPressed()
                }
                builder.show()

            }
            else if(winner == 2)
            {
                val name2 = intent.getStringExtra("key1")
                val builder = AlertDialog.Builder(this)
                builder.setTitle("WINNER WINNER TIC TAC TOE WINNER")   //set title for alert dialog
                builder.setMessage("\"$name2\" Win's The Match!! Keep It Up")  //set message for alert dialog
                builder.setIcon(R.drawable.alert_message_icon)   // set icon for alert dialog message

                //performing positive action
                builder.setPositiveButton("REPLAY") { dialogInterface, which ->
                    val intent = Intent(this, PlayersName::class.java)
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
        else if(counter==9)
        {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("IT'S A TIE")   //set title for alert dialog
            builder.setMessage("Better Luck Next Time")  //set message for alert dialog
            builder.setIcon(R.drawable.its_a_tie)   // set icon for alert dialog message

            //performing positive action
            builder.setPositiveButton("REPLAY") {dialogInterface, which ->
                val intent = Intent(this,PlayersName::class.java)
                startActivity(intent)
                finish()
            }
            //performing negative action
            builder.setNegativeButton("No") {dialogInterface, which ->
                super.onBackPressed()
            }
            builder.show()
        }

        btn_replay1.setOnClickListener{
            val intent = Intent(this, PlayersName::class.java)
            startActivity(intent)
            finish()
        }
    }
}
