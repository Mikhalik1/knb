package com.example.knb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)



        val playerChoice:String = intent.getStringExtra("key")!!
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val computerChoiceTextView = findViewById<TextView>(R.id.computerChoiceTextView)
        val playerChoiceTextView = findViewById<TextView>(R.id.playerChoiceTextView)
        val resultImageView = findViewById<ImageView>(R.id.resultImageView)
        val computerChoice:String = getRandomChoice()
        computerChoiceTextView.text="Компьютер выбрал:"+ computerChoice.toString()
        playerChoiceTextView.text="Ваш выбор:"+ playerChoice.toString()
        resultTextView.text="Результат:"+determineWinner(playerChoice.toString(), computerChoice)
        val selectedImage =
            if ((computerChoice=="Бумага" && playerChoice == "Камень")|| (playerChoice == "Бумага" &&
                        computerChoice == "Камень")){
                R.drawable.pr
            } else {
                if ((computerChoice=="Ножницы" && playerChoice == "Камень")|| (playerChoice ==
                            "Ножницы" && computerChoice == "Камень")){
                    R.drawable.rs
                }
                else{
                    if ((computerChoice=="Ножницы" && playerChoice == "Бумага")|| (playerChoice ==
                                "Ножницы" && computerChoice == "Бумага")){
                        R.drawable.sp
                    }
                    else{
                        R.drawable.dead_heat
                    }
                }
            }
        resultImageView.setImageResource(selectedImage)

        var clickBackButton = findViewById<Button>(R.id.backButton)
        clickBackButton.setOnClickListener{
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




    }



    private fun getRandomChoice(): String {
        val сhoice = arrayOf("Камень", "Бумага", "Ножницы")
        val choices = сhoice.size
        val randomIndex = Random.nextInt(choices)
        return сhoice[randomIndex]
    }

    private fun determineWinner(playerChoice: String, computerChoice: String): String {
        if ( playerChoice == computerChoice ){
            return "Ничья!"
        }
        else {
            if (( playerChoice == "Камень" && computerChoice == "Ножницы") ||
                ( playerChoice == "Бумага" && computerChoice == "Камень") ||
                (playerChoice == "Ножницы" && computerChoice == "Бумага")){
                return "Вы победили!"
            }
            else {
                return "Победил компьютер!"
            }
        }
    }
}