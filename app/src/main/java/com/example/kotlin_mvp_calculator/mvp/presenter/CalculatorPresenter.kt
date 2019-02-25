package com.example.kotlin_mvp_calculator.mvp.presenter

import com.example.kotlin_mvp_calculator.mvp.model.CalculatorModel
import com.example.kotlin_mvp_calculator.mvp.view.CalculatorView

import com.example.kotlin_mvp_calculator.rx.EventTypes.RESET_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.ZERO_EVENT

import io.reactivex.disposables.CompositeDisposable

import com.example.kotlin_mvp_calculator.rx.Butns.DIVIDE
import com.example.kotlin_mvp_calculator.rx.Butns.DOT
import com.example.kotlin_mvp_calculator.rx.Butns.EIGHT
import com.example.kotlin_mvp_calculator.rx.Butns.FIVE
import com.example.kotlin_mvp_calculator.rx.Butns.FOUR
import com.example.kotlin_mvp_calculator.rx.Butns.MINUS
import com.example.kotlin_mvp_calculator.rx.Butns.MULTIPLY
import com.example.kotlin_mvp_calculator.rx.Butns.NINE
import com.example.kotlin_mvp_calculator.rx.Butns.ONE
import com.example.kotlin_mvp_calculator.rx.Butns.PLUS
import com.example.kotlin_mvp_calculator.rx.Butns.SEVEN
import com.example.kotlin_mvp_calculator.rx.Butns.SIX
import com.example.kotlin_mvp_calculator.rx.Butns.THREE
import com.example.kotlin_mvp_calculator.rx.Butns.TWO
import com.example.kotlin_mvp_calculator.rx.Butns.ZERO
import com.example.kotlin_mvp_calculator.rx.EventTypes.DELETE_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.DOT_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.EIGHT_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.FIVE_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.FOUR_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.NINE_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.ONE_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.OP_DIV_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.OP_MIN_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.OP_MUL_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.OP_PLUS_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.RESULT_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.SEVEN_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.SIX_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.THREE_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.TWO_EVENT

class CalculatorPresenter(val model: CalculatorModel, val view: CalculatorView) {

    private val compositeDisposable = CompositeDisposable()

    fun initPresenter() {
        compositeDisposable.add(
            view.viewEventObservable.subscribe { clickEvent ->
                when (clickEvent) {
                    RESET_EVENT -> model.reset()
                    DELETE_EVENT -> model.delete()
                    RESULT_EVENT -> model.operate()
                    ZERO_EVENT -> model.inputValue(ZERO)
                    ONE_EVENT -> model.inputValue(ONE)
                    TWO_EVENT -> model.inputValue(TWO)
                    THREE_EVENT -> model.inputValue(THREE)
                    FOUR_EVENT -> model.inputValue(FOUR)
                    FIVE_EVENT -> model.inputValue(FIVE)
                    SIX_EVENT -> model.inputValue(SIX)
                    SEVEN_EVENT -> model.inputValue(SEVEN)
                    EIGHT_EVENT -> model.inputValue(EIGHT)
                    NINE_EVENT -> model.inputValue(NINE)
                    DOT_EVENT -> model.inputValue(DOT)
                    OP_PLUS_EVENT -> model.inputOp(PLUS)
                    OP_MIN_EVENT -> model.inputOp(MINUS)
                    OP_MUL_EVENT -> model.inputOp(MULTIPLY)
                    OP_DIV_EVENT -> model.inputOp(DIVIDE)
                }

                view.setText(model.getData())
            }
        )
    }

    fun disposeObservers() {
        compositeDisposable.clear()
    }
}
