package com.krenvpravo.sampleappcompat.mainscreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.krenvpravo.sampleappcompat.R
import com.krenvpravo.sampleappcompat.ScreenItemModel
import com.krenvpravo.sampleappcompat.otherscreens.CustomViewController
import com.krenvpravo.sampleappcompat.otherscreens.ExampleDialogFragment
import com.krenvpravo.sampleappcompat.otherscreens.ExampleFragment
import com.viewbinder.bindView

class ExampleCompatActivity : AppCompatActivity() {

    private val headerTextView by bindView<TextView>(R.id.activity_example_header_text)
    private val recycler by bindView<RecyclerView>(R.id.activity_compat_recycler)
    private lateinit val router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compat)
        initViews(savedInstanceState)
    }

    private fun initViews(savedInstanceState: Bundle?) {
        headerTextView.text = getString(R.string.activity_example_header)
        val adapter = ExampleAdapter()
        adapter.screenItems = createScreensList()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        router = Conductor.attachRouter(this, R.id.activity_compat_container, savedInstanceState)
    }

    private fun showExampleFragment() {
        val fragment = ExampleFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.activity_compat_container, fragment)
        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.commit()
    }

    private fun showExampleFragmentDialog() {
        val dialogFragment = ExampleDialogFragment()
        dialogFragment.show(fragmentManager, dialogFragment.javaClass.simpleName)
    }

    private fun showConductorView() {
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(CustomViewController()))
        }
    }

    override fun onBackPressed() {
        if (router.handleBack()) { //todo check javadock whether true or false when will have inernet
            return
        }
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    private fun createScreensList(): List<ScreenItemModel> {
        val list = mutableListOf<ScreenItemModel>()
        list.add(ScreenItemModel("Fragment", this::showExampleFragment))
        list.add(ScreenItemModel("FragmentDialog", this::showExampleFragmentDialog))
        list.add(ScreenItemModel("Conductor view", this::showConductorView))
        return list
    }
}
