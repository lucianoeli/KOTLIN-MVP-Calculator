package com.example.kotlin_mvp_calculator.mvp.view

import android.app.Activity
import com.example.kotlin_mvp_calculator.rx.EventTypes.ONE_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.OP_PLUS_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.RESET_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.RESULT_EVENT
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
                activity.result_button
                    .clicks()
                    .map { RESULT_EVENT }
                    .mergeWith(
                        activity.zero_button
                            .clicks()
                            .map { ZERO_EVENT }
                            .mergeWith(
                                activity.one_button
                                    .clicks()
                                    .map { ONE_EVENT }
                                    .mergeWith(
                                        activity.plus_button
                                            .clicks()
                                            .map { OP_PLUS_EVENT }
                                    )
                            )
                    )
            )

    fun setText(input: String) {
        activity!!.result_label.text = input
    }
}
