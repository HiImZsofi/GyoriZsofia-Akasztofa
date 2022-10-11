package com.example.hangman

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
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

    var errors : Int = 0
    var correctGuesses = ""
    var firstguess = ""
    val correctLetters = arrayListOf<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        repeat(0){
            displayWord()
        }

        var index = 0
        var nextLetter = ""
        var isClickedPositive : Boolean = false
        var isClickedNegative : Boolean = false

        plusbutton.setOnClickListener{
            if (index == alphabet.size-1) {
                index = 0;
            } else {
                index++;
            }
            letter.setText(alphabet[index].toUpperCase().toString());
            if(correctLetters.contains(randomword.getText().toString().last())){
                letter.setTextColor(Color.BLACK);
            }else{
                letter.setTextColor(Color.RED);
            }
            //TODO bug
        }

        minusbutton.setOnClickListener{
            if (index == 0) {
                index = alphabet.size-1;
            } else {
                index--;
            }
            letter.setText(alphabet[index].toUpperCase().toString());
            if(correctLetters.contains(randomword.getText().toString().last())){
                letter.setTextColor(Color.BLACK);
            }else{
                letter.setTextColor(Color.RED);
            }

        }


        guessbutton.setOnClickListener{
            var currentChar : String = letter.text as String;
            var index = 0
            var sb: StringBuilder = StringBuilder(randomword.getText())
            var guessedLetter: CharSequence = letter.getText()

            if(chosenWord.contains(letter.text)){
                correctGuesses = randomword.text.toString()
                for (i in chosenWord.indices) {
                    if (chosenWord.get(i) === guessedLetter[0]) {
                        println("if")
                        val ch: kotlin.Char = guessedLetter[0]
                        sb.setCharAt(i, ch)
                        correctLetters.add(guessedLetter[0])
                    }
                    correctGuesses = randomword.text.toString()
                    println(sb.toString())
                    if(correctLetters.contains(guessedLetter.toString().first())){
                        letter.setTextColor(Color.BLACK)
                    }
                    else{
                        letter.setTextColor(Color.RED) //TODO bug
                    }
                } //for

            }
            else{
            println("else")
            errors = errors + 1
            println(errors)
            if(errors == 1){  //nem értem hogyan működik a when
                image.setImageResource(R.drawable.akasztofa01)
            }
            else if(errors == 2){
                image.setImageResource(R.drawable.akasztofa02)
            }
            else if(errors == 3){
                image.setImageResource(R.drawable.akasztofa03)
            }
            else if(errors == 4){
                image.setImageResource(R.drawable.akasztofa04)
            }
            else if(errors == 5){
                image.setImageResource(R.drawable.akasztofa05)
            }
            else if(errors == 6){
                image.setImageResource(R.drawable.akasztofa06)
            }
            else if(errors == 7){
                image.setImageResource(R.drawable.akasztofa07)
            }
            else if(errors == 8){
                image.setImageResource(R.drawable.akasztofa08)
            }
            else if(errors == 9){
                image.setImageResource(R.drawable.akasztofa09)
            }
            else if(errors == 10){
                image.setImageResource(R.drawable.akasztofa10)
            }
            else if(errors == 11){
                image.setImageResource(R.drawable.akasztofa11)
            }
            else if(errors == 12){
                image.setImageResource(R.drawable.akasztofa12)
            }
            else if(errors > 12){
                image.setImageResource(R.drawable.akasztofa12)
                var gameOverDialogBuilder = AlertDialog.Builder(this)
                gameOverDialogBuilder.setTitle("Nem sikerült kitalálni!");
                gameOverDialogBuilder.setMessage("Szeretnél még egyet játszani?");
                gameOverDialogBuilder.setCancelable(false);
                gameOverDialogBuilder.setNegativeButton("Nem", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
                gameOverDialogBuilder.setPositiveButton("Igen", DialogInterface.OnClickListener {
                        dialog, id -> index = 0
                    nextLetter = alphabet.first().toString()
                    letter.setText(nextLetter)
                    randomword.setText(displayWord())
                    errors = 0
                    image.setImageResource(R.drawable.akasztofa00)
                })

                gameOverDialogBuilder.show()
            }
        }
            if(chosenWord == sb.toString()){
                var winDialogBuilder = AlertDialog.Builder(this)
                winDialogBuilder.setTitle("Nyertél!");
                winDialogBuilder.setMessage("Szeretnél még egyet játszani?");
                winDialogBuilder.setCancelable(false);
                winDialogBuilder.setNegativeButton("Nem", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
                winDialogBuilder.setPositiveButton("Igen", DialogInterface.OnClickListener {
                        dialog, id -> index = 0
                    nextLetter = alphabet.first().toString()
                    letter.setText(nextLetter)
                    randomword.setText(displayWord())
                    errors = 0
                    image.setImageResource(R.drawable.akasztofa00)
                })

                winDialogBuilder.show()
            }
                randomword.setText(sb)
        }

    }

    val wordArray = arrayOf("dekoracio", "webhely", "ezredes", "ejjeliszekreny", "fenyoillat", "kenyerpirito",
    "madartoll", "aranyeso", "madartej", "dobvero") //hard coded string array for game

    var alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray() //alphabet for the buttons

    fun init() {
        rlayout = findViewById(R.id.rlayout)
        topline = findViewById(R.id.topline)
        minusbutton = findViewById(R.id.minusbutton)
        plusbutton = findViewById(R.id.plusbutton)
        letter = findViewById(R.id.letter)
        guessbutton = findViewById(R.id.guessbutton)
        image = findViewById(R.id.image)
        randomword = findViewById(R.id.randomword)
        randomword.setText(displayWord());
        letter.setText(alphabet[0].toString().toUpperCase())
    }


    fun displayWord():String{
        val rnd = (0..wordArray.size - 1).random()
        println(rnd)
        chosenWord = wordArray.elementAt(rnd)
        underlines = ""
        for (i in chosenWord.indices) {
            underlines+="_";
        }
        println(chosenWord)
        return underlines;
    }

}

