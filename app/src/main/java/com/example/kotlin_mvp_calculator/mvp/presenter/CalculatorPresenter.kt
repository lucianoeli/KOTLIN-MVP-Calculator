package com.example.kotlin_mvp_calculator.mvp.presenter

import android.widget.CalendarView
import com.example.kotlin_mvp_calculator.mvp.model.CalculatorModel
import com.example.kotlin_mvp_calculator.mvp.view.CalculatorView
import io.reactivex.disposables.CompositeDisposable

class CalculatorPresenter(val model: CalculatorModel, val view: CalculatorView) {

    private val compositeDisposable = CompositeDisposable()

    fun initPresenter() {
        compositeDisposable.add(
            view.viewEventObservable.subscribe { clickEvent ->
                when (clickEvent) {
                    INCREMENT_EVENT -> {
                        model.inc()
                    }
                    RESET_COUNT_EVENT -> {0
                        model.reset()
                    }
                }
                view.setCount(model.count.toString())
            }
        )
    }
}