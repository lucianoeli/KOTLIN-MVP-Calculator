package com.example.kotlin_mvp_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_mvp_calculator.mvp.model.CalculatorModel
import com.example.kotlin_mvp_calculator.mvp.presenter.CalculatorPresenter
import com.example.kotlin_mvp_calculator.mvp.view.CalculatorView

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: CalculatorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CalculatorPresenter(CalculatorModel(), CalculatorView(this))
    }

    override fun onResume() {
        super.onResume()
        presenter.initPresenter()
    }

    override fun onDestroy() {
        presenter.disposeObservers()
        super.onDestroy()
    }
}
