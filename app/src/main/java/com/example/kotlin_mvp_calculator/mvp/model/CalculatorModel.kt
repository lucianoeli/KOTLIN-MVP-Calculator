package com.example.kotlin_mvp_calculator.mvp.model

import android.util.Log

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
        if (op == MINUS) {
            if (firstValue == EMPTY_STRING) firstValue = op
            else if (operator == EMPTY_STRING) operator = op
            else secondValue = MINUS
        } else{
            if (firstValue != EMPTY_STRING) operator = op
        }

    }

    fun reset() {
        firstValue = EMPTY_STRING
        secondValue = EMPTY_STRING
        operator = EMPTY_STRING
    }


    fun getData(): String {
        var result: String
        if (firstValue == EMPTY_STRING) {
            return EMPTY_STRING
        } else {
            if (operator != EMPTY_STRING) {
                result = firstValue + operator
                if (secondValue != EMPTY_STRING) {
                    result += secondValue
                }
            } else {
                return firstValue
            }
        }
        return result
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
        if (!firstValue.isEmpty() && !operator.isEmpty() && !secondValue.isEmpty()) {
            secondValue = secondValue.substring(0, secondValue.length)
        }
    }

}
