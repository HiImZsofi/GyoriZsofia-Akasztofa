package com.example.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*

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

    }

    val wordArray = arrayOf("dekoracio", "webhely", "ezredes", "ejjeliszekreny", "fenyoillat", "kenyerpirito",
    "madartoll", "aranyeso", "madartej", "dobvero")

    fun init(){
        rlayout = findViewById(R.id.rlayout)
        topline = findViewById(R.id.topline)
        minusbutton = findViewById(R.id.minusbutton)
        plusbutton = findViewById(R.id.plusbutton)
        letter = findViewById(R.id.letter)
        guessbutton = findViewById(R.id.guessbutton)
        image = findViewById(R.id.image)
        randomword = findViewById(R.id.randomword)
    }
}

