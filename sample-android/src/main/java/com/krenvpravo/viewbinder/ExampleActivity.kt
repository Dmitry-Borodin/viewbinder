package com.krenvpravo.viewbinder

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.viewbinder.bindView

class ExampleActivity : Activity() {

    private val helloTextView by bindView<TextView>(R.id.example_activity_hello_text)
    private val buttonFragment by bindView<Button>(R.id.example_activity_fragment_button)
    private val buttonCustomView by bindView<Button>(R.id.example_activity_view_button)
    private val buttonDialogFragment by bindView<Button>(R.id.example_activity_dialog_fragment_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        initViews()
    }

    private fun initViews() {
        buttonFragment.setOnClickListener { showExampleFragment() }
        buttonCustomView.setOnClickListener { showCustomView() }
        buttonDialogFragment.setOnClickListener {showExampleFragmentDialog() }
        helloTextView.text = getString(R.string.hello_from_activity)
    }

    private fun showExampleFragment() {
        val fragment = ExampleFragment()
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.example_activity_container, fragment)
        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.commit()
    }

    private fun showExampleFragmentDialog() {
        val dialogFragment = ExampleDialogFragment()
        dialogFragment.show(fragmentManager, dialogFragment.javaClass.simpleName)
    }

    private fun showCustomView() {
        Toast.makeText(this, "not implemented yet", Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
