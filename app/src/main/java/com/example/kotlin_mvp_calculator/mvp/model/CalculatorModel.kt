package com.example.kotlin_mvp_calculator.mvp.model

import com.example.kotlin_mvp_calculator.rx.Butns
import com.example.kotlin_mvp_calculator.rx.Butns.EMPTY_STRING

class CalculatorModel {
    var firstValue: String = EMPTY_STRING
        private set
    var secondValue: String = EMPTY_STRING
        private set
    var operator: String = EMPTY_STRING
        private set

    fun reset() {
        firstValue = EMPTY_STRING
        secondValue = EMPTY_STRING
        operator = EMPTY_STRING
    }

    fun inputZero() {
        if (operator != null)
            firstValue = Butns.ZERO
    }

    fun getData(): String {
        return "$firstValue$operator$secondValue"
    }
}
