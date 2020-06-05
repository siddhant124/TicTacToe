package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player_1.setOnClickListener {
            val intent = Intent(this,SinglePlayer::class.java)
            startActivity(intent)
        }

        player_2.setOnClickListener {
            val intent = Intent(this, PlayersName::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Message")   //set title for alert dialog
        builder.setMessage("Are you sure, you want to quit ?")  //set message for alert dialog
        builder.setIcon(R.drawable.alert_message_icon)   // set icon for alert dialog message

        //performing positive action
        builder.setPositiveButton("Yes") {dialogInterface, which ->

//            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            finish()
        }
        //performing cancel action
        builder.setNeutralButton("Cancel") {dialogInterface, which ->
//            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
        }

        //performing negative action
        builder.setNegativeButton("No") {dialogInterface, which ->
//            Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_LONG).show()
        }


        //to show alert dialog box
        builder.show()
    }
}
