package fr.epita.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.second_activity.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)


    }


    fun buttonClick(view: View) {
        val buttonClicked = view as Button
        var cellId = 0
        val originIntent = intent
        val message = originIntent.getStringExtra("NAME")

        playerName.text = "O(" + message + ")"

        when (buttonClicked.id) {
            R.id.b00 -> cellId = 1
            R.id.b01 -> cellId = 2
            R.id.b02 -> cellId = 3
            R.id.b10 -> cellId = 4
            R.id.b11 -> cellId = 5
            R.id.b12 -> cellId = 6
            R.id.b20 -> cellId = 7
            R.id.b21 -> cellId = 8
            R.id.b22 -> cellId = 9        }
        playGame(cellId, buttonClicked)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    private fun playGame(cellId: Int, buttonSelected: Button) {

        if (activePlayer == 1) {
            buttonSelected.text = "X"
            buttonSelected.setTextColor(Color.BLACK)
            player1.add(cellId)
            activePlayer = 2

        } else {
            buttonSelected.text = "O"
            buttonSelected.setTextColor(Color.BLACK)
            player2.add(cellId)
            activePlayer = 1
        }
        buttonSelected.isEnabled = false

        checkTheWinner(buttonSelected)


    }

    private fun checkTheWinner(buttonSelected: Button) {
        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
        if (winner != -1) {
            if (winner == 1)
                Toast.makeText(this, "Guest won ", Toast.LENGTH_LONG).show()
            setContentView(R.layout.third_activity)

            if (winner == 2) {
                val originIntent = intent
                val message = originIntent.getStringExtra("NAME")
                setContentView(R.layout.third_activity)

                Toast.makeText(this, message +"won "  , Toast.LENGTH_LONG).show()
                setContentView(R.layout.third_activity)
            }
            if (winner !=1 && winner!= 2)
                Toast.makeText(this, "Egality ", Toast.LENGTH_LONG).show()

            player1 = ArrayList<Int>()
            player2 = ArrayList<Int>()


        }
    }
}