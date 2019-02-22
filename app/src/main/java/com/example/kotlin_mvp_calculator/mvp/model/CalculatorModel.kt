package com.example.kotlin_mvp_calculator.mvp.model

import android.util.Log

class CalculatorModel {
    var firstValue: String = ""
        private set
    var secondValue: String = ""
        private set
    var operator: String = ""
        private set

    fun reset() {
        firstValue = ""
        secondValue = ""
        operator = ""
    }

    fun inputZero() {
        //TODO quitar hardcode
        inputValue("0")
    }

    fun inputOne() {
        //TODO quitar hardcode
        inputValue("1")
    }


    fun inputPlus() {
        /** si no hay firstVal pongo operador +
         *  si ya hay un operador lo pisa
         *  si ya hay NO HAY un firstVal o HAY un secondVal no hace nada **/
        if (firstValue != "" && secondValue == "") {
            operator = "+"
        }
    }

    fun getData(): String {
        val result: String
        if (firstValue == "") {
            return " "
        } else {
            if (operator != "") {
                result = firstValue + operator
                if (secondValue == "") {
                    return result
                } else {
                    return result + secondValue
                }
            } else {
                return firstValue
            }
        }
    }

    private fun inputValue(value: String) {
        if (operator != "") {
            secondValue += value
        } else {
            firstValue += value
        }
    }

    fun operate() {
        var result = 0.0
        val first = firstValue.toDouble()
        val second = secondValue.toDouble()

        if (operator != "") {
            when (operator.toString()) {
                "+" -> result = first + second
                "-" -> result = first - second
                "*" -> result = first * second
                "/" -> result = first / second
            }
        }
        reset()
        firstValue = result.toString()
    }
}
