package com.example.kotlin_mvp_calculator.mvp.model

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
        if (operator != null)
            firstValue = 0.0
    }

    fun getData(): String {
        return firstValue.toString() + operator.toString() + secondValue.toString()
    }
}
