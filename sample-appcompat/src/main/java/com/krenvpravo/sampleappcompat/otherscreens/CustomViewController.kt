package com.krenvpravo.sampleappcompat.otherscreens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.krenvpravo.sampleappcompat.R

/**
 * @author Dmitry Borodin on 2017-10-27.
 */
class CustomViewController(args: Bundle? = null) : BaseController(args) {
    private val button by bindView<Button>(R.id.fragment_example_button)
    private val headerText by bindView<TextView>(R.id.fragment_example_header_text)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.fragment_example, container, false)
        this.rootView = view
        initViews()
        return view
    }

    private fun initViews() {
        button.text = view?.context?.getString(R.string.conductor_view_button_title)
        button.setOnClickListener { handleBack() } //todo fix when will be able synch gradle
        headerText.text = view?.context?.getString(R.string.conductor_view_header_text)
    }
}