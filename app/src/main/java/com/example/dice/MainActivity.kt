package com.example.dice

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val click:TextView=findViewById(R.id.click)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice()
        val snack=Snackbar.make(it,"Dice Rolled",Snackbar.LENGTH_SHORT).show()
        }
        //to roll a dice when start
        rollDice()

        click.setOnClickListener{
            val builder=AlertDialog.Builder(this)
            builder.setTitle(R.string.a_title)
            builder.setMessage(R.string.a_message)
            builder.setIcon(R.drawable.ic_action_alret)
            builder.setPositiveButton("yes"){dialog: DialogInterface?, which: Int ->
                Snackbar.make(it,"You Love This...!",Snackbar.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("cancel"){dialog: DialogInterface?, which: Int ->
                Snackbar.make(it,"aborted",Snackbar.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){dialog: DialogInterface?, which: Int ->
                Snackbar.make(it,"You don't like It.",Snackbar.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog=builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
            }

        }


    private fun rollDice() {
        val dice=Dice(6)
        val diceRoll=dice.roll()
        val diceImage:ImageView=findViewById(R.id.imageView)
        when(diceRoll){
            1->diceImage.setImageResource(R.drawable.dice_1)
            2->diceImage.setImageResource(R.drawable.dice_2)
            3->diceImage.setImageResource(R.drawable.dice_3)
            4->diceImage.setImageResource(R.drawable.dice_4)
            5->diceImage.setImageResource(R.drawable.dice_5)
            else->diceImage.setImageResource(R.drawable.dice_6)
        }


    }

}
class Dice(private val numSides:Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}
