package com.rijen.assignment4calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    private lateinit var tvHistory: TextView
    private lateinit var etDisplay: TextView

    //First row
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btnPlus: Button

    //Second row
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btnMinus: Button

    //Third row
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnMul: Button

    //Forth row
    private lateinit var btnDot: Button
    private lateinit var btn0: Button
    private lateinit var btnDiv: Button
    private lateinit var btnClear: Button

    //for equal to
    private lateinit var btnEqual: Button

    var initialValue: Double = 0.0
    var finalValue: Double = 0.0

    var plus: Boolean = false
    var minus: Boolean = false
    var multiplication: Boolean = false
    var division: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        //Reference
        tvHistory = findViewById(R.id.tvHistory)
        etDisplay = findViewById(R.id.etDisplay)
        //First row
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btnPlus = findViewById(R.id.btnPlus)
        //Second row
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btnMinus = findViewById(R.id.btnMinus)
        //Third row
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnMul = findViewById(R.id.btnMul)
        //Forth row
        btnDot = findViewById(R.id.btnDot)
        btn0 = findViewById(R.id.btn0)
        btnDiv = findViewById(R.id.btnDiv)
        btnClear = findViewById(R.id.btnClear)

        //for equal to
        btnEqual = findViewById(R.id.btnEqual)

        //Displaying value of clicked button
        //First Row
        btn1.setOnClickListener {
            display("1")
        }
        btn2.setOnClickListener {
            display("2")
        }
        btn3.setOnClickListener {
            display("3")
        }
        btnPlus.setOnClickListener {
            if (etDisplay==null){
                etDisplay.text=""
            }
            else{
                displayHistory("+")
                initialValue =  etDisplay.text.toString().toDouble()
                plus = true
                etDisplay.text=""
            }
        }

        //Second Row
        btn4.setOnClickListener {
            display("4")
        }
        btn5.setOnClickListener {
            display("5")
        }
        btn6.setOnClickListener {
            display("6")
        }
        btnMinus.setOnClickListener {
            if (etDisplay==null){
                etDisplay.text=""
            }
            else{
                displayHistory("-")
                initialValue =  etDisplay.text.toString().toDouble()
                minus = true
                etDisplay.text=""
            }
        }

        //Third Row
        btn7.setOnClickListener {
            display("7")
        }
        btn8.setOnClickListener {
            display("8")
        }
        btn9.setOnClickListener {
            display("9")
        }
        btnMul.setOnClickListener {
            if (etDisplay==null){
                etDisplay.text=""
            }
            else{
                displayHistory("X")
                initialValue =  etDisplay.text.toString().toDouble()
                multiplication = true
                etDisplay.text=""
            }
        }

        //Forth Row
        btnDot.setOnClickListener {
            display(".")
        }
        btn0.setOnClickListener {
            display("0")
        }
        btnDiv.setOnClickListener {
            if (etDisplay==null){
                etDisplay.text=""
            }
            else{
                displayHistory("/")
                initialValue =  etDisplay.text.toString().toDouble()
                division = true
                etDisplay.text = ""
            }
        }
        btnClear.setOnClickListener{
            clearDisplay()
        }


        //For final result
        btnEqual.setOnClickListener {
            operations()
        }
    }

    //final result operations
    private fun operations() {
        finalValue = etDisplay.text.toString().toDouble()
        //for addition
        if (plus==true){
            etDisplay.text=(initialValue+finalValue).toString()
            plus=false

        }
        //for substraction
        if (minus==true){
            etDisplay.text=(initialValue-finalValue).toString()
            minus=false
        }
        //for multiplication
        if (multiplication==true){
            etDisplay.text=(initialValue*finalValue).toString()
            multiplication=false
        }
        //for division
        if (division==true){
            etDisplay.text=(initialValue/finalValue).toString()
            division=false
        }
        tvHistory.text = etDisplay.text.toString()
    }

    private fun display(btnVal: String) {
        val btnValue = btnVal
        etDisplay.text = (etDisplay.text.toString() + btnValue)
    }

    //for displaying history
    private fun displayHistory(btnVal: String) {
        val btnValue = btnVal
        tvHistory.text = (etDisplay.text.toString() + btnValue)
    }

    private fun clearDisplay(){
        etDisplay.text = ""
        tvHistory.text = ""
    }
}