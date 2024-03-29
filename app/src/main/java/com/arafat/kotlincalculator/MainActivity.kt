package com.arafat.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Numbers
        tvOne.setOnClickListener { appendOnExpression("1",true) }
        tvTwo.setOnClickListener { appendOnExpression("2",true) }
        tvThree.setOnClickListener { appendOnExpression("3",true) }
        tvFour.setOnClickListener { appendOnExpression("4",true) }
        tvFive.setOnClickListener { appendOnExpression("5",true) }
        tvSix.setOnClickListener { appendOnExpression("6",true) }
        tvSeven.setOnClickListener { appendOnExpression("7",true) }
        tvEight.setOnClickListener { appendOnExpression("8",true) }
        tvNine.setOnClickListener { appendOnExpression("9",true) }
        tvZero.setOnClickListener { appendOnExpression("0",true) }
        tvDot.setOnClickListener { appendOnExpression(".",true) }

        //Operators
        tvPlus.setOnClickListener { appendOnExpression("+",false) }
        tvMinus.setOnClickListener { appendOnExpression("-",false) }
        tvMultiply.setOnClickListener { appendOnExpression("*",false) }
        tvDivide.setOnClickListener { appendOnExpression("/",false) }
        tvtvOpenP.setOnClickListener { appendOnExpression("(",false) }
        tvCloseP.setOnClickListener { appendOnExpression(")",false) }

        tvCE.setOnClickListener {

            tvExpresions.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener {
            val string = tvExpresions.text.toString()
            if(string.isNotEmpty()){

                tvExpresions.text = string.substring(0, string.length-1)
            }

            tvResult.text = " "
        }


        tvEquals.setOnClickListener {

            try {

                val  expression = ExpressionBuilder(tvExpresions.text.toString()).build()
                val result = expression.evaluate()
                val  longResult = result.toLong()

                if(result ==longResult.toDouble()){
                    tvResult.text = longResult.toString()
                }else{
                    tvResult.text = result.toString()
                }



            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    fun appendOnExpression(string: String, canClear: Boolean){

        if(tvResult.text.isNotEmpty()){
            tvExpresions .text = ""
        }

        if(canClear){

            tvResult.text = ""
            tvExpresions.append(string)
        }else{

            tvExpresions.append(tvResult.text)
            tvExpresions.append(string)
            tvResult.text = ""
        }
    }
}
