package com.krenvpravo.sampleappcompat.otherscreens

import android.app.DialogFragment
import android.view.View
import com.viewbinder.ResettableLazy
import com.viewbinder.ResettableLazyManager
import com.viewbinder.abstractBind

/**
 * @author Dmitry Borodin on 2017-10-22.
 */

open class BaseDialogFragment : DialogFragment() {

    val lazyManager = ResettableLazyManager()
    fun <T : View> bind(id: Int): ResettableLazy<T> = abstractBind(id, lazyManager)

    override fun onStop() {
        super.onStop()
        lazyManager.reset()
    }
}