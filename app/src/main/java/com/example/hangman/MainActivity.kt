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
    private lateinit var chosenWord : String
    private lateinit var underlines : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        displayWord()
        var index = 0
        var nextLetter = ""

        plusbutton.setOnClickListener{
            if(index < alphabet.size){
                nextLetter = alphabet.elementAt(index).toString()
                letter.setText(nextLetter)
                index++
            }
            else if(index == alphabet.size){
                index = 0
            }
            //TODO szín legyen fekete ha jól tippel
            //TODO bugos
        }

        minusbutton.setOnClickListener{
            if(index > 0){
                nextLetter = alphabet.elementAt(index).toString()
                letter.setText(nextLetter)
                index--
            }
            else if(index == 0){
                nextLetter = alphabet.elementAt(0).toString()
                letter.setText(nextLetter)
                index = alphabet.size - 1
            }
        }

        guessbutton.setOnClickListener{
            var currentChar : String = letter.text as String;
            var index = 0
            for (i in chosenWord){
                index++
                if(i.toString() == nextLetter){
                    //println("ok")
                    val sb = StringBuilder(chosenWord).also { it.setCharAt(index, nextLetter[index]) }
                    chosenWord = sb.toString()
                }
            }
           // string = new StringBuilder(underlines);
            if(chosenWord.contains(currentChar)){
                for (i in 0..chosenWord.length) {

                }
            }
            randomword.setText(chosenWord)
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
        chosenWord = wordArray.elementAt(rnd)
        underlines = ""
        for (i in 0..chosenWord.length) {
            underlines+="_";
        }
        println(chosenWord)
        return underlines;
    }
}

