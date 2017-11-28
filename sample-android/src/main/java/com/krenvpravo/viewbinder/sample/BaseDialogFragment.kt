package com.krenvpravo.viewbinder.sample

import android.app.DialogFragment
import android.view.View
import com.viewbinder.ResettableLazy
import com.viewbinder.BindingResetter
import com.viewbinder.abstractBind

/**
 * @author Dmitry Borodin on 2017-10-22.
 */

open class BaseDialogFragment : DialogFragment() {

    val resetter = BindingResetter()
    fun<T : View> bind(id: Int): ResettableLazy<T> = abstractBind(id, resetter)

    override fun onStop() {
        super.onStop()
        resetter.reset()
    }
}
