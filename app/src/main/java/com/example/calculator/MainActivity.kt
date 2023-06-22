package com.example.calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnClear.setOnClickListener{
            binding.input.text=""
            binding.output.text=""
        }
        binding.btnLeft.setOnClickListener {
            binding.input.text= addToInputText("(")
        }
        binding.btnRight.setOnClickListener {
            binding.input.text= addToInputText(")")
        }
        binding.btn0.setOnClickListener {
            binding.input.text= addToInputText("0")
        }
        binding.btn1.setOnClickListener {
            binding.input.text= addToInputText("1")
        }
        binding.btn2.setOnClickListener {
            binding.input.text= addToInputText("2")
        }
        binding.btn3.setOnClickListener {
            binding.input.text= addToInputText("3")
        }
        binding.btn4.setOnClickListener {
            binding.input.text= addToInputText("4")
        }
        binding.btn5.setOnClickListener {
            binding.input.text= addToInputText("5")
        }
        binding.btn6.setOnClickListener {
            binding.input.text= addToInputText("6")
        }
        binding.btn7.setOnClickListener {
            binding.input.text= addToInputText("7")
        }
        binding.btn8.setOnClickListener {
            binding.input.text= addToInputText("8")
        }
        binding.btn9.setOnClickListener {
            binding.input.text= addToInputText("9")
        }
        binding.btnDot.setOnClickListener {
            binding.input.text= addToInputText(".")
        }
        binding.btnDiv.setOnClickListener {
            binding.input.text= addToInputText("÷")
        }
        binding.btnMul.setOnClickListener {
            binding.input.text= addToInputText("×")
        }
        binding.btnMinus.setOnClickListener {
            binding.input.text= addToInputText("-")
        }
        binding.btnPlus.setOnClickListener {
            binding.input.text= addToInputText("+")
        }
        binding.btnEqul.setOnClickListener {
            showResult()
        }
    }
    private fun addToInputText(buttonValue: String): String{
        return "${binding.input.text}$buttonValue"
    }
    private fun getInputExpression():String{
        var expression= binding.input.text.replace(Regex("÷"),"/")
        expression=expression.replace(Regex("×"),"*")
        return expression
    }

    private fun showResult(){
        try{
            val expression=getInputExpression()
            val result=Expression(expression).calculate()
            if (result.isNaN()){
                binding.output.text="Undefined"
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }
            else{
                binding.output.text=DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.green))
            }
        }catch (e: Exception){
            binding.output.text="Undefined"
            binding.output.setTextColor(ContextCompat.getColor(this,R.color.red))
        }
    }
}