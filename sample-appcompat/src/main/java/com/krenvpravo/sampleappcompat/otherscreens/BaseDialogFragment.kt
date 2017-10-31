package com.krenvpravo.sampleappcompat.otherscreens

import android.app.DialogFragment
import android.view.View
import com.viewbinder.ResettableLazy
import com.viewbinder.LazyResetter
import com.viewbinder.abstractBindView

/**
 * @author Dmitry Borodin on 2017-10-22.
 */

open class BaseDialogFragment : DialogFragment() {

    val lazyManager = LazyResetter()
    fun <T : View> bind(id: Int): ResettableLazy<T> = abstractBindView(id, lazyManager)

    override fun onStop() {
        super.onStop()
        lazyManager.reset()
    }
}