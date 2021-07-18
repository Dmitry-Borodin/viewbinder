package com.krenvpravo.viewbinder.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.viewbinder.native.bindColor

/**
 * @author Dmitry Borodin on 2017-10-14.
 */
class ExampleDialogFragment : BaseDialogFragment() {

    private val button by bindView<Button>(R.id.fragment_example_button)
    private val headerText by bindView<TextView>(R.id.fragment_example_header_text)
    private val primaryColor by bindColor(R.color.colorPrimary)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_example, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        button.text = getString(R.string.dialog_fragment_button_text)
        button.setOnClickListener { dismiss() }
        headerText.text = getString(R.string.dialog_fragment_header)
        button.setBackgroundColor(primaryColor)
    }
}