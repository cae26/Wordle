package com.example.wordle
//package com.example.FourLetterWordList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    var counter=0
    var wordToGuess=FourLetterWordList.getRandomFourLetterWord()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val simpleEditText = findViewById<EditText>(R.id.et_simple)

        val textView = findViewById<TextView>(R.id.textView)

        val guessOne = findViewById<TextView>(R.id.textView5)
        val gCheckOne = findViewById<TextView>(R.id.textView7)
        val gTextOne = findViewById<TextView>(R.id.textView6)

        val guessTwo = findViewById<TextView>(R.id.textView9)
        val gCheckTwo = findViewById<TextView>(R.id.textView12)
        val gTextTwo = findViewById<TextView>(R.id.textView11)
        val gtext2= findViewById<TextView>(R.id.textView8)

        val guessThree = findViewById<TextView>(R.id.textView14)
        val gCheckThree = findViewById<TextView>(R.id.textView16)
        val gTextthree = findViewById<TextView>(R.id.textView15)
        val gtext3= findViewById<TextView>(R.id.textView13)
        //val guessFour = findViewById<TextView>(R.id.textView10)

        val testing = findViewById<TextView>(R.id.testing_word_to_guess)

        testing.text=wordToGuess

        val button=findViewById<Button>(R.id.button)

        button.setOnClickListener {

            //testing.text=wordToGuess
            val strValue = simpleEditText.text.toString().uppercase()

            simpleEditText.onEditorAction(EditorInfo.IME_ACTION_DONE)
            simpleEditText.setText(null);

            textView.text=strValue
            if(counter==0){

                guessOne.text=strValue
                gCheckOne.text = checkGuess(strValue)
                gTextOne.visibility=View.VISIBLE
                guessOne.visibility=View.VISIBLE
                gCheckOne.visibility=View.VISIBLE
                if (checkGuess(strValue)=="OOOO"){
                    textView.text="You won"
                    textView.visibility=View.VISIBLE
                }
            }
            if(counter==1){
                guessTwo.text=strValue
                gCheckTwo.text = checkGuess(strValue)
                gTextTwo.visibility=View.VISIBLE
                gtext2.visibility=View.VISIBLE
                guessTwo.visibility=View.VISIBLE
                gCheckTwo.visibility=View.VISIBLE
                if (checkGuess(strValue)=="OOOO"){
                    textView.text="You won"
                    textView.visibility=View.VISIBLE
                }

            }
            if(counter==2){
                guessThree.text=strValue
                gCheckThree.text = checkGuess(strValue)
                gTextthree.visibility=View.VISIBLE
                gtext3.visibility=View.VISIBLE
                guessThree.visibility=View.VISIBLE
                gCheckThree.visibility=View.VISIBLE
                if (checkGuess(strValue)=="OOOO"){
                    textView.text="You won"
                    textView.visibility=View.VISIBLE
                }
            }
            if(counter==3){


            }

            counter++

        }


    }
    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}