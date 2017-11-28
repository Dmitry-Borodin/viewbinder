package com.krenvpravo.sampleappcompat.otherscreens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.krenvpravo.sampleappcompat.R

/**
 * @author Dmitry Borodin on 2017-10-14.
 */
class ExampleFragment : BaseFragment() {

    private val button by bindView<Button>(R.id.fragment_example_button)
    private val headerText by bindView<TextView>(R.id.fragment_example_header_text)
//    private val primaryColor by bind<>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_example, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        button.text = getString(R.string.fragment_example_button_title)
        button.setOnClickListener { activity.onBackPressed() }
        headerText.text = getString(R.string.fragment_example_header)
    }
}