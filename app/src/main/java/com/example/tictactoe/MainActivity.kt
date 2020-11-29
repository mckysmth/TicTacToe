package com.example.tictactoe

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val game = Game()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    fun buttonOnClick(view: View) {
        print("hello btn")
        val  btn_tmp = findViewById<Button>(view.id);
        val btnName = btn_tmp.resources.getResourceName(view.id)
        val index = btnName.toString().takeLast(1).toInt();

        if (game.spotIsEmpty(index))
        {

            btn_tmp.text = game.turn;
            game.addMove(index);


            if (game.getWinner() != "#")
            {
                findViewById<TextView>(R.id.turn_id).setText(game.getWinner() + " is the winner");
                findViewById<TableLayout>(R.id.mainLayout).removeViews(1, 3)
            }
            else
            {
                findViewById<TextView>(R.id.turn_id).setText(game.turn);
            }

        }



        game
    }
}


