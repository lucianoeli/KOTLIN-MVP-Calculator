package com.example.kotlin_mvp_calculator.mvp.model

import android.util.Log
import com.example.kotlin_mvp_calculator.rx.Butns

import com.example.kotlin_mvp_calculator.rx.Butns.EMPTY_STRING
import com.example.kotlin_mvp_calculator.rx.Butns.PLUS
import com.example.kotlin_mvp_calculator.rx.Butns.MINUS
import com.example.kotlin_mvp_calculator.rx.Butns.MULTIPLY
import com.example.kotlin_mvp_calculator.rx.Butns.DIVIDE
import com.example.kotlin_mvp_calculator.rx.Butns.ZERO

class CalculatorModel {

    var firstValue: String = EMPTY_STRING
        private set
    var secondValue: String = EMPTY_STRING
        private set
    var operator: String = EMPTY_STRING
        private set

    fun inputValue(value: String) {
        if (operator != EMPTY_STRING) {
            secondValue += value
        } else {
            firstValue += value
        }
    }

    fun inputOp(op: String) {
        when (op) {
            MINUS -> {
                if (firstValue == EMPTY_STRING) firstValue = op
                else if (operator == EMPTY_STRING) operator = op
                else secondValue = MINUS
            }
            else -> if (firstValue != EMPTY_STRING) operator = op
        }
    }

    fun reset() {
        firstValue = EMPTY_STRING
        secondValue = EMPTY_STRING
        operator = EMPTY_STRING
    }

    fun getData(): String = when {
        operator != EMPTY_STRING && secondValue == EMPTY_STRING -> firstValue + operator
        operator != EMPTY_STRING && secondValue != EMPTY_STRING -> firstValue + operator + secondValue
        else -> firstValue
    }

    fun operate() {

        var result: Double = ZERO.toDouble()
        var first: Double = Double.NaN
        var second: Double = Double.NaN

        try {
            first = firstValue.toDouble()
            result = first
        } catch (e: NumberFormatException) {
            Log.e("FIRST VALUE", e.toString())
        }
        try {
            second = secondValue.toDouble()
        } catch (e: NumberFormatException) {
            Log.e("SECOND VALUE", e.toString())
            second = ZERO.toDouble()
        }

        if (operator != EMPTY_STRING && second != Double.NaN) {
            result = when (operator) {
                PLUS -> first + second
                MINUS -> first - second
                MULTIPLY -> first * second
                DIVIDE -> first / second
                else -> Double.NaN
            }
        }
        reset()
        firstValue = result.toString()
    }

    fun delete() {
        if (!firstValue.isEmpty())
            if (!operator.isEmpty())
                if (!secondValue.isEmpty()) {
                    secondValue = secondValue.substring(Butns.ZERO_INT, secondValue.length - Butns.ONE_INT)
                } else {
                    operator = operator.substring(Butns.ZERO_INT, operator.length - Butns.ONE_INT)
                }
            else {
                firstValue = firstValue.substring(Butns.ZERO_INT, firstValue.length - Butns.ONE_INT)
            }
    }

}
