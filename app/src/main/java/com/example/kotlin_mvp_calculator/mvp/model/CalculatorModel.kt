package com.example.kotlin_mvp_calculator.mvp.model

import android.util.Log

import com.example.kotlin_mvp_calculator.rx.Butns.EMPTY_STRING
import com.example.kotlin_mvp_calculator.rx.Butns.PLUS
import com.example.kotlin_mvp_calculator.rx.Butns.MINUS
import com.example.kotlin_mvp_calculator.rx.Butns.MULTIPLY
import com.example.kotlin_mvp_calculator.rx.Butns.DIVIDE
import com.example.kotlin_mvp_calculator.rx.Butns.ONE_INT
import com.example.kotlin_mvp_calculator.rx.Butns.ZERO
import com.example.kotlin_mvp_calculator.rx.Butns.ZERO_DOUBLE
import com.example.kotlin_mvp_calculator.rx.Butns.ZERO_INT

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

        var result: Double = ZERO_DOUBLE
        var first: Double = Double.NaN
        var second: Double

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

        if (second != Double.NaN) {
            result = when (operator) {
                PLUS -> first + second
                MINUS -> first - second
                MULTIPLY -> first * second
                DIVIDE -> first / second
                EMPTY_STRING -> result
                else -> result
            }
        }
        reset()
        firstValue = result.toString()
    }

    fun delete() {
        if (!firstValue.isEmpty())
            if (!operator.isEmpty())
                if (!secondValue.isEmpty()) {
                    secondValue = secondValue.substring(ZERO_INT, secondValue.length - ONE_INT)
                } else {
                    operator = operator.substring(ZERO_INT, operator.length - ONE_INT)
                }
            else {
                firstValue = firstValue.substring(ZERO_INT, firstValue.length - ONE_INT)
            }
    }

}
