package com.krenvpravo.sampleappcompat.otherscreens

import android.support.v4.app.DialogFragment
import android.view.View
import com.viewbinder.BindingResetter
import com.viewbinder.ResettableLazy

/**
 * DialogFragment is a Fragment
 *
 * @author Dmitry Borodin on 2017-10-22.
 *
 */

open class BaseDialogFragment : DialogFragment() {

    private val resetter = BindingResetter()
    fun <T : View> bindView(id: Int): ResettableLazy<T> = abstractBind(id, resetter)

    /**
     *  Reset lazy at stop, so next time we'll touch views they will be bound again, because
     *  fragment will recreate it's view hierarchy after restoring from backstack
     */
    override fun onStop() {
        super.onStop()
        resetter.reset()
    }
}