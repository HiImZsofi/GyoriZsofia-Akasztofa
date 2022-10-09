package com.example.hangman

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var rlayout : RelativeLayout
    private lateinit var topline : LinearLayout
    private lateinit var minusbutton : Button
    private lateinit var plusbutton : Button
    private lateinit var letter : TextView
    private lateinit var guessbutton : Button
    private lateinit var image : ImageView
    private lateinit var randomword : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        displayWord()
        var indexplus = 0
        var indexminus = alphabet.size - 1
        var nextLetter : String

        plusbutton.setOnClickListener{
            displayWord()
            if(indexplus < alphabet.size){
                nextLetter = alphabet.elementAt(indexplus).toString()
                letter.setText(nextLetter)
                indexplus++
            }
            else if(indexplus == alphabet.size){
                indexplus = 0
            }
            //TODO szín legyen fekete ha jól tippel
        }

        minusbutton.setOnClickListener{
            if(indexminus > 0){
                nextLetter = alphabet.elementAt(indexminus).toString()
                letter.setText(nextLetter)
                indexminus--
            }
            else if(indexminus == 0){
                nextLetter = alphabet.elementAt(0).toString()
                letter.setText(nextLetter)
                indexminus = alphabet.size - 1
            }
        }

    }

    val wordArray = arrayOf("dekoracio", "webhely", "ezredes", "ejjeliszekreny", "fenyoillat", "kenyerpirito",
    "madartoll", "aranyeso", "madartej", "dobvero") //hard coded string array for game

    var alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray() //alphabet for the buttons

    fun init(){
        rlayout = findViewById(R.id.rlayout)
        topline = findViewById(R.id.topline)
        minusbutton = findViewById(R.id.minusbutton)
        plusbutton = findViewById(R.id.plusbutton)
        letter = findViewById(R.id.letter)
        guessbutton = findViewById(R.id.guessbutton)
        image = findViewById(R.id.image)
        randomword = findViewById(R.id.randomword)
        randomword.setText(displayWord());
    }

    fun displayWord():String{
        val rnd = (0..wordArray.size - 1).random()
        val chosenWord = wordArray.elementAt(rnd)
        var underlines:String = "";
        for (i in 0..chosenWord.length) {
            underlines+="_";
        }
        println(chosenWord)
        return underlines;
    }
}

