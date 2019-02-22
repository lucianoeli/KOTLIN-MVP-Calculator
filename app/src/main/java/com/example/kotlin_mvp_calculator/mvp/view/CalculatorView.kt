package com.example.kotlin_mvp_calculator.mvp.view

import android.app.Activity
import com.example.kotlin_mvp_calculator.rx.EventTypes.ZERO_EVENT
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorView(activity: Activity) : ActivityView(activity) {

    val viewEventObservable: Observable<Int> =
        activity.zero_button
            .clicks()
            .map { ZERO_EVENT }
            .mergeWith(
                activity.resetBtn
                    .clicks()
                    .map { RESET_COUNT_EVENT }
            )
}