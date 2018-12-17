package fr.epita.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", name.toString())
        buttonStart.setOnClickListener {
            Log.d("HomeScreen", name.text.toString())
            intent.putExtra("NAME", name.text.toString() )
            this.startActivity(intent)
        }
    }

}

