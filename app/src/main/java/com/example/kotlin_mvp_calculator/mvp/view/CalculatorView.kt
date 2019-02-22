package com.example.kotlin_mvp_calculator.mvp.view

import android.app.Activity
import com.example.kotlin_mvp_calculator.rx.EventTypes.ONE_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.RESET_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.ZERO_EVENT
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorView(activity: Activity) : ActivityView(activity) {

    val viewEventObservable: Observable<Int> =
        activity.reset_button
            .clicks()
            .map { RESET_EVENT }
            .mergeWith(
                activity.zero_button
                    .clicks()
                    .map { ZERO_EVENT }
            )

    fun setText(input: String){

    }
}
