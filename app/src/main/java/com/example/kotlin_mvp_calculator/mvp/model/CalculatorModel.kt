package com.example.kotlin_mvp_calculator.mvp.model

import com.example.kotlin_mvp_calculator.rx.Butns

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
        if (operator != null)
            firstValue = Butns.ZERO_DOUBLE
    }

    fun getData(): String {
        return "${firstValue.toString()}${operator.toString()}${secondValue.toString()}"
    }
}
