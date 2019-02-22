package com.example.kotlin_mvp_calculator.mvp.model

import android.util.Log

class CalculatorModel {
    var firstValue: Double? = null
        private set
    var secondValue: Double? = null
        private set
    var operator: String? = null
        private set

    fun reset() {
        firstValue = null
        secondValue = null
        operator = null
    }

    fun inputZero() {
        //TODO quitar hardcode
        if (operator != null) {
            secondValue = 0.0
            Log.d("MODEL", secondValue.toString())
        } else {
            firstValue = 0.0
            Log.d("MODEL", firstValue.toString())
        }
    }

    fun getData(): String {
        val result: String
        if (firstValue == null) {
            return " "
        } else {
            if (operator != null) {
                result = firstValue.toString() + operator.toString()
                if (secondValue == null){
                    return result
                }
                else{
                    return result + secondValue.toString()
                }
            }else{
                return firstValue.toString()
            }
        }
    }
}
