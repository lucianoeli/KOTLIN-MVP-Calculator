package com.example.kotlin_mvp_calculator.mvp.model

class CalculatorModel {
    companion object {
        const val EMPTY_STRING = ""
    }

    var firstValue: String = EMPTY_STRING
        private set
    var secondValue: String = EMPTY_STRING
        private set
    var operator: String = EMPTY_STRING
        private set


    private fun inputValue(value: String) {
        if (operator != EMPTY_STRING) {
            secondValue += value
        } else {
            firstValue += value
        }
    }

    /** si no hay firstVal pongo operador +
     *  si ya hay un operador lo pisa
     *  si ya hay NO HAY un firstVal o HAY un secondVal no hace nada **/
    private fun inputOp(op: String) {
        if (firstValue != EMPTY_STRING && secondValue == EMPTY_STRING) {
            operator = op
        }
    }

    fun reset() {
        firstValue = EMPTY_STRING
        secondValue = EMPTY_STRING
        operator = EMPTY_STRING
    }

    fun inputZero() {
        //TODO quitar hardcode
        inputValue("0")
    }

    fun inputOne() {
        //TODO quitar hardcode
        inputValue("1")
    }

    fun inputTwo() {
        //TODO quitar hardcode
        inputValue("2")
    }

    fun inputPlus() {
        inputOp("+")
    }

    fun inputMinus() {
        inputOp("-")
    }

    fun inputMultiply() {
        inputOp("*")
    }

    fun inputDivide() {
        inputOp("/")
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
        var result = 0.0
        val first = firstValue.toDouble()
        val second = secondValue.toDouble()

        if (operator != EMPTY_STRING) {
            result = when (operator.toString()) {
                "+" -> first + second
                "-" -> first - second
                "*" -> first * second
                "/" -> first / second

                else -> Double.NaN
            }
        }
        reset()
        firstValue = result.toString()
    }
}
