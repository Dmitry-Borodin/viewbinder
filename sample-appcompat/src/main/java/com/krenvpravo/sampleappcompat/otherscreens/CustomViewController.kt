package com.krenvpravo.sampleappcompat.otherscreens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.krenvpravo.sampleappcompat.R

/**
 * @author Dmitry Borodin on 2017-10-27.
 */
class CustomViewController(args : Bundle? = null) : Controller(args) { //todo check empty the same as with null when will have internet
    private val button by bind<Button>(R.id.fragment_example_button)
    private val headerText by bind<TextView>(R.id.fragment_example_header_text)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.fragment_example, container, false)
        initViews()
        return view
    }

    private fun initViews() {
        button.text = "Close conductor custom view"
        button.setOnClickListener { handleBack() } //todo fix when will be able synch gradle
        headerText.text = "Conductor crontroller header it's based on custom view"
    }
}