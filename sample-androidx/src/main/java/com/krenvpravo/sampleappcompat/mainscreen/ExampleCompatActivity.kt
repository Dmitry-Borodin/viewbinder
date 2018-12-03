package com.krenvpravo.sampleappcompat.mainscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krenvpravo.sampleappcompat.R
import com.krenvpravo.sampleappcompat.ScreenItemModel
import com.krenvpravo.sampleappcompat.otherscreens.ExampleDialogFragment
import com.krenvpravo.sampleappcompat.otherscreens.ExampleFragment
import com.viewbinder.bindView

class ExampleCompatActivity : AppCompatActivity() {

    private val headerTextView by bindView<TextView>(R.id.activity_example_header_text)
    private val recycler by bindView<RecyclerView>(R.id.activity_compat_recycler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compat)
        initViews()
    }

    private fun initViews() {
        headerTextView.text = getString(R.string.activity_example_header)
        val adapter = ExampleAdapter()
        adapter.screenItems = createScreensList()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    @SuppressLint("CommitTransaction") //commit is in lambda
    private fun showExampleFragment() {
        val fragment = ExampleFragment()
        supportFragmentManager.beginTransaction().let {
            it.replace(R.id.activity_compat_container, fragment)
            it.addToBackStack(fragment.javaClass.simpleName)
            it.commit()
        }
    }

    private fun showExampleFragmentDialog() {
        val dialogFragment = ExampleDialogFragment()
        dialogFragment.show(supportFragmentManager, dialogFragment.javaClass.simpleName)
    }

    private fun showCustomView() {
        Toast.makeText(this, "custom view will be later", Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    private fun createScreensList(): List<ScreenItemModel> {
        return mutableListOf<ScreenItemModel>(
                ScreenItemModel("Fragment", this::showExampleFragment),
                ScreenItemModel("FragmentDialog", this::showExampleFragmentDialog),
                ScreenItemModel("CustomView", this::showCustomView))
    }
}
