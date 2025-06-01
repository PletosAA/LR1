package com.rk.lr1_postcard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rk.lr1_postcard.databinding.ActivityMainBinding
import com.rk.lr1_postcard.databinding.ActivityScrabbleBinding


class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
    private lateinit var binding: ActivityScrabbleBinding
    private val wordsList: List<String> = listOf("вектор", "кнопка", "папка", "экран", "кодекс", "числа", "язык", "точка", "робот", "экран", "модуль", "шрифт", "сервер", "класс", "цикл", "строки", "фигура", "метод", "пульт", "данные")
    private lateinit var currentWord: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        binding = ActivityScrabbleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvScrambleWord.text = mixWord()

        binding.btnCheckWord.setOnClickListener {
            if (checkAnswer()) {
                val mix = mixWord()
                binding.tvScrambleWord.text = mix
                binding.tiField.setText("")
            }
        }
    }

    private fun mixWord(): String {
        currentWord = wordsList.random()
        return currentWord.toList().shuffled().joinToString("")
    }


    private fun checkAnswer(): Boolean {
        val userInput = binding.tiField.text.toString()
        return if (userInput == currentWord) {
            Toast.makeText(this, "Верно!", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show()
            false
        }
    }

}