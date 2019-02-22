package com.example.kotlin_mvp_calculator.mvp.view

import android.app.Activity
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
import com.example.kotlin_mvp_calculator.rx.EventTypes.RESET_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.RESULT_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.SEVEN_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.SIX_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.THREE_EVENT
import com.example.kotlin_mvp_calculator.rx.EventTypes.TWO_EVENT
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
                        activity.delete_button
                            .clicks()
                            .map { DELETE_EVENT }
                    )
            )
            .mergeWith(
                activity.zero_button
                    .clicks()
                    .map { ZERO_EVENT }
                    .mergeWith(
                        activity.one_button
                            .clicks()
                            .map { ONE_EVENT }
                            .mergeWith(
                                activity.two_button
                                    .clicks()
                                    .map { TWO_EVENT }
                                    .mergeWith(
                                        activity.three_button
                                            .clicks()
                                            .map { THREE_EVENT }
                                            .mergeWith(
                                                activity.four_button
                                                .clicks()
                                                .map { FOUR_EVENT }
                                                .mergeWith(
                                                    activity.five_button
                                                        .clicks()
                                                        .map { FIVE_EVENT }
                                                        .mergeWith(
                                                            activity.six_button
                                                                .clicks()
                                                                .map { SIX_EVENT }
                                                                .mergeWith(
                                                                    activity.seven_button
                                                                        .clicks()
                                                                        .map { SEVEN_EVENT }
                                                                        .mergeWith(
                                                                            activity.eight_button
                                                                                .clicks()
                                                                                .map { EIGHT_EVENT }
                                                                                .mergeWith(
                                                                                    activity.nine_button
                                                                                        .clicks()
                                                                                        .map { NINE_EVENT }
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                            )
                                    )
                            )
                    )
            ).mergeWith(
                activity.plus_button
                    .clicks()
                    .map { OP_PLUS_EVENT }
                    .mergeWith(
                        activity.minus_button
                            .clicks()
                            .map { OP_MIN_EVENT }
                            .mergeWith(
                                activity.multiply_button
                                    .clicks()
                                    .map { OP_MUL_EVENT }
                                    .mergeWith(
                                        activity.divide_button
                                            .clicks()
                                            .map { OP_DIV_EVENT }
                                    )
                            )
                    )
            ).mergeWith(
                activity.dot_button
                    .clicks()
                    .map { DOT_EVENT }
            )

    fun setText(input: String) {
        activity!!.result_label.text = input
    }
}
