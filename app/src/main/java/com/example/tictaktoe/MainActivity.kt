package com.example.tictaktoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TableRow
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.children
import com.example.tictaktoe.databinding.ActivityMainBinding
import com.example.tictaktoe.databinding.WindialoglayoutBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var isXTurn = true
    val chars = Array(3) { CharArray(3) { '*' } }
    var xCount = 0
    var oCount = 0
    var drowCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.turnTitleTv.text = if (isXTurn) {
            getString(R.string.xTurnTitle)
        } else {
            getString(R.string.oTurnTitle)
        }
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.firsthBtn.setOnClickListener {
            btnClicked(it as Button, 1)
        }
        binding.secondtBtn.setOnClickListener {
            btnClicked(it as Button, 2)

        }
        binding.thirdBtn.setOnClickListener {
            btnClicked(it as Button, 3)
        }
        binding.fourthBtn.setOnClickListener {
            btnClicked(it as Button, 4)
        }
        binding.fivethBtn.setOnClickListener {
            btnClicked(it as Button, 5)
        }
        binding.sixthBtn.setOnClickListener {
            btnClicked(it as Button, 6)
        }
        binding.seventhBtn.setOnClickListener {
            btnClicked(it as Button, 7)
        }
        binding.eightthBtn.setOnClickListener {
            btnClicked(it as Button, 8)
        }
        binding.ninethBtn.setOnClickListener {
            btnClicked(it as Button, 9)
        }

    }

    private fun btnClicked(button: Button, buttonNumber: Int) {

        if (button.text.isNotBlank()) return
        button.text = if (isXTurn) {
            button.setTextColor(Color.RED)
            chars[(buttonNumber - 1) / 3][(buttonNumber - 1) % 3] = 'X'
            "X"
        } else {
            button.setTextColor(Color.GREEN)
            chars[(buttonNumber - 1) / 3][(buttonNumber - 1) % 3] = '0'
            "0"
        }
        isXTurn = !isXTurn
        binding.turnTitleTv.text = if (isXTurn) {
            getString(R.string.xTurnTitle)
        } else {
            getString(R.string.oTurnTitle)
        }
        checkWin()
    }


    private fun checkWin() {
        for (array in chars) {
            if (array[0] != '*' && array[0] == array[1] && array[1] == array[2]) {
                showWinDialog(array[0])
                return
            }
        }
        for (i in 0 until 3) {
            if (chars[0][i] != '*' && chars[0][i] == chars[1][i] && chars[1][i] == chars[2][i]) {
                showWinDialog(chars[0][i])
                return
            }
        }
        if (chars[0][0] != '*' && chars[0][0] == chars[1][1] && chars[1][1] == chars[2][2]) {
            showWinDialog(char = chars[0][0])
            return
        }
        if (chars[2][0] != '*' && chars[2][0] == chars[1][1] && chars[1][1] == chars[0][2]) {
            showWinDialog(char = chars[2][0])
            return
        }
        var count = 0
        for (i in chars.indices) {
            for (j in 0 until 3) {
                if (chars[i][j] != '*') count++
            }
        }
        if (count == 9) {
            showWinDialog(char = '*')
        }

    }

    private fun showWinDialog(char: Char) {
        val dialogLayoutBinding = WindialoglayoutBinding.inflate(LayoutInflater.from(this))

        dialogLayoutBinding.titleTv.text = if (char == 'X'){
            xCount++
            binding.xWonCountTv.text = "$xCount"
            "X player won"
        }else if (char == '0') {
            oCount++
            binding.oWonCountTv.text = "$oCount"
            "0 player won"
        }else{
            drowCount++
            binding.drawCountTv.text = "$drowCount"
            "This game is drow"
        }
        val dialog = AlertDialog.Builder(this,R.style.RoundedDialog)
            .setCancelable(false)
            .setView(dialogLayoutBinding.root)
            .create()
        dialogLayoutBinding.button.setOnClickListener {
            resetGame()
            dialog.dismiss()
        }
        dialog.show()


    }

    private fun resetGame() {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                chars[i][j] = '*'
            }
        }
        binding.btnTableLayout.children.forEach {
            (it as TableRow).children.forEach { b->
                (b as Button).text = ""
            }
        }

    }
}
