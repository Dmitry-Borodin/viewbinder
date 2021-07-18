package com.krenvpravo.viewbinder.sample

import android.app.Fragment
import android.view.View
import com.viewbinder.BindingResetter
import com.viewbinder.ResettableLazy
import com.viewbinder.native.abstractBind

/**
 * @author Dmitry Borodin on 2017-10-10.
 */
open class BaseFragment : Fragment() {

    private val resetter = BindingResetter()
    fun <T : View> bindView(id: Int): ResettableLazy<T> = abstractBind(id, resetter)

    override fun onStop() {
        super.onStop()
        resetter.reset()
    }
}