package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_players_name.*

class PlayersName : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players_name)

        val player_name_1 = findViewById<EditText>(R.id.player_name1)
        val player_name_2 = findViewById<EditText>(R.id.player_name2)
        var send = findViewById<Button>(R.id.btn_play_the_game)

        btn_play_the_game.setOnClickListener {
            if(player_name_1.length() == 0)
            {
                player_name_1.setError("Enter player 1 name first")
            }
            else if(player_name_2.length() == 0)
            {
                player_name_2.setError("Enter player 2 name first")
            }
            else
            {
                val intent = Intent(this,DualPlayer::class.java)
                intent.putExtra("key",player_name_1.text.toString())
                intent.putExtra("key1",player_name_2.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
