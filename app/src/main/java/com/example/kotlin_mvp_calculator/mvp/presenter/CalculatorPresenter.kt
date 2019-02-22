package com.example.kotlin_mvp_calculator.mvp.presenter


import com.example.kotlin_mvp_calculator.mvp.model.CalculatorModel
import com.example.kotlin_mvp_calculator.mvp.view.CalculatorView

import com.example.kotlin_mvp_calculator.rx.EventTypes.RESET_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.ZERO_EVENT

import io.reactivex.disposables.CompositeDisposable
import android.util.Log
import com.example.kotlin_mvp_calculator.rx.EventTypes.ONE_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.OP_DIV_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.OP_MIN_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.OP_MUL_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.OP_PLUS_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.RESULT_EVENT

class CalculatorPresenter(val model: CalculatorModel, val view: CalculatorView) {

    private val compositeDisposable = CompositeDisposable()

    fun initPresenter() {
        compositeDisposable.add(
            view.viewEventObservable.subscribe { clickEvent ->
                when (clickEvent) {
                    RESET_EVENT -> {
                        model.reset()
                        Log.d("PRESENTER", "reset_event!")
                    }
                    ZERO_EVENT -> {
                        model.inputZero()
                        Log.d("PRESENTER", "zero_event!")
                    }

                    ONE_EVENT -> {
                        model.inputOne()
                    }
                    OP_PLUS_EVENT -> {
                        model.inputPlus()
                    }

                    OP_MIN_EVENT -> {
                        model.inputMinus()
                    }

                    OP_MUL_EVENT -> {
                        model.inputMultiply()
                    }

                    OP_DIV_EVENT -> {
                        model.inputDivide()
                    }

                    RESULT_EVENT -> {
                        model.operate()
                    }
                }

                view.setText(model.getData())
            }
        )
    }

    fun disposeObservers() {
        compositeDisposable.clear()
    }
}
