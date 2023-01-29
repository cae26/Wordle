package com.example.wordle
//package com.example.FourLetterWordList

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
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
        val buttonRestart=findViewById<Button>(R.id.restart)



        button.setOnClickListener {

            //testing.text=wordToGuess
            val strValue = simpleEditText.text.toString().uppercase()
            val strResult = checkGuess(strValue)
            simpleEditText.onEditorAction(EditorInfo.IME_ACTION_DONE)
            simpleEditText.setText(null);

            textView.text=strValue
            if(counter==0){

                guessOne.text=strValue
                gCheckOne.text = checkGuessFormat(strValue)
                gTextOne.visibility=View.VISIBLE
                guessOne.visibility=View.VISIBLE
                gCheckOne.visibility=View.VISIBLE
                if (strResult=="OOOO"){
                    textView.text=getString(R.string.game_won)
                    textView.visibility=View.VISIBLE
                    button.visibility=View.INVISIBLE
                    buttonRestart.visibility=View.VISIBLE
                }

            }
            if(counter==1){
                guessTwo.text=strValue
                gCheckTwo.text = checkGuessFormat(strValue)
                gTextTwo.visibility=View.VISIBLE
                gtext2.visibility=View.VISIBLE
                guessTwo.visibility=View.VISIBLE
                gCheckTwo.visibility=View.VISIBLE
                if (strResult=="OOOO"){
                    textView.text=getString(R.string.game_won)
                    textView.visibility=View.VISIBLE
                    button.visibility=View.INVISIBLE
                    buttonRestart.visibility=View.VISIBLE
                }


            }
            if(counter==2){
                guessThree.text=strValue
                gCheckThree.text = checkGuessFormat(strValue)
                gTextthree.visibility=View.VISIBLE
                gtext3.visibility=View.VISIBLE
                guessThree.visibility=View.VISIBLE
                gCheckThree.visibility=View.VISIBLE
                if (strResult=="OOOO"){
                    textView.text=getString(R.string.game_won)
                    textView.visibility=View.VISIBLE

                }
                textView.text=getString(R.string.try_again)
                textView.visibility=View.VISIBLE
                button.visibility=View.INVISIBLE
                buttonRestart.visibility=View.VISIBLE
            }
            counter++

        }
//        if(counter==3){
//            //button.text=getString(R.string.restart_game)
//            buttonRestart.setOnClickListener {
//                counter=0
//                button.text=getString(R.string.guess_buttton)
//
//            }
//
//        }
        buttonRestart.setOnClickListener{
            counter=0
            button.visibility=View.VISIBLE
            buttonRestart.visibility=View.INVISIBLE
            wordToGuess=FourLetterWordList.getRandomFourLetterWord()
            testing.text=wordToGuess
            gTextOne.visibility=View.INVISIBLE
            guessOne.visibility=View.INVISIBLE
            gCheckOne.visibility=View.INVISIBLE
            gTextTwo.visibility=View.INVISIBLE
            gtext2.visibility=View.INVISIBLE
            guessTwo.visibility=View.INVISIBLE
            gCheckTwo.visibility=View.INVISIBLE
            gTextthree.visibility=View.INVISIBLE
            gtext3.visibility=View.INVISIBLE
            guessThree.visibility=View.INVISIBLE
            gCheckThree.visibility=View.INVISIBLE
            textView.visibility=View.INVISIBLE
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
    private fun checkGuessFormat(guess: String) : SpannableStringBuilder {
        val colorResult = SpannableStringBuilder("")

        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                //result += "O"
                val temp = SpannableStringBuilder(guess[i].toString())
                temp.setSpan(ForegroundColorSpan(Color.GREEN),0,1,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                colorResult.append(temp)

            }
            else if (guess[i] in wordToGuess) {
                //result += "+"
                val temp = SpannableStringBuilder(guess[i].toString())
                temp.setSpan(ForegroundColorSpan(Color.BLACK),0,1,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                colorResult.append(temp)
            }
            else {
                val temp = SpannableStringBuilder(guess[i].toString())
                temp.setSpan(ForegroundColorSpan(Color.RED),0,1,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                colorResult.append(temp)
                //result += "X"
            }

        }


        return colorResult
    }
}