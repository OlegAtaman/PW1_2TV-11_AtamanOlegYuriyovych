package com.example.laba1_task2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare UI components
    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var editTextC: EditText
    private lateinit var editTextD: EditText
    private lateinit var editTextE: EditText
    private lateinit var editTextF: EditText
    private lateinit var editTextG: EditText
    private lateinit var editTextH: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewVmist: TextView
    private lateinit var textViewLowerTemp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content view to the updated layout
        setContentView(R.layout.activity_main)

        // Initialize UI components
        editTextA = findViewById(R.id.editTextA)
        editTextB = findViewById(R.id.editTextB)
        editTextC = findViewById(R.id.editTextC)
        editTextD = findViewById(R.id.editTextD)
        editTextE = findViewById(R.id.editTextE)
        editTextF = findViewById(R.id.editTextF)
        editTextG = findViewById(R.id.editTextG)
        editTextH = findViewById(R.id.editTextH)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewVmist = findViewById(R.id.textViewVmist)
        textViewLowerTemp = findViewById(R.id.textViewLowerTemp)

        // Set click listener for the calculate button
        buttonCalculate.setOnClickListener {
            calculateResult()
        }
    }

    private fun calculateKDry(x:Double, w: Double): Double {
        return x * (100 - w)/100
    }

    private fun calculateKBurn(x:Double, w: Double, a_burn: Double): Double {
        return x * (100 - w - a_burn)/100
    }

    private fun calculateLowerBurningTemp(a:Double, b:Double, c:Double): Double {
        return a*((100-b-c)/100) - 0.025*b
    }

    // Function to perform the calculation
    private fun calculateResult() {
        // Retrieve and validate input values
        val aText = editTextA.text.toString()
        val bText = editTextB.text.toString()
        val cText = editTextC.text.toString()
        val dText = editTextD.text.toString()
        val eText = editTextE.text.toString()
        val fText = editTextF.text.toString()
        val gText = editTextG.text.toString()
        val hText = editTextH.text.toString()

        // Convert input strings to Double
        val a = aText.toDouble()
        val b = bText.toDouble()
        val c = cText.toDouble()
        val d = dText.toDouble()
        val e = eText.toDouble()
        val f = fText.toDouble()
        val g = gText.toDouble()
        val h = hText.toDouble()

        val h_calc = calculateKBurn(a, f, g)
        val c_calc = calculateKBurn(b, f, g)
        val o_calc = calculateKBurn(c, f, g)
        val s_calc = calculateKBurn(d, f, g)
        val zola_calc = calculateKDry(g, f)
        val v_calc = calculateKDry(h, f)

        val h_calc_form = String.format("%.2f", h_calc)
        val c_calc_form = String.format("%.2f", c_calc)
        val o_calc_form = String.format("%.2f", o_calc)
        val s_calc_form = String.format("%.2f", s_calc)
        val zola_calc_form = String.format("%.2f", zola_calc)
        val v_calc_form = String.format("%.2f", v_calc)

        val answer = calculateLowerBurningTemp(e, f, g)

        // Display the result
        textViewVmist.text = "Склад робочої маси мазуту: H - $h_calc_form%, C - $c_calc_form%, S - $s_calc_form%, O -$o_calc_form%, зола -$zola_calc_form%, ванадій -$v_calc_form мг/кг"
        textViewLowerTemp.text = "Нижча теплота згоряння для робочої маси: $answer МГДж/кг"
    }
}