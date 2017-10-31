package com.krenvpravo.sampleappcompat.otherscreens

import android.support.v4.app.Fragment
import android.view.View
import com.viewbinder.ResettableLazy
import com.viewbinder.LazyResetter
import com.viewbinder.abstractBind

/**
 * @author Dmitry Borodin on 2017-10-10.
 */
open class BaseFragment : Fragment() {

    val lazyManager = LazyResetter()
    fun <T : View> Fragment.bind(id: Int): ResettableLazy<T> = abstractBind(id, lazyManager)

    override fun onStop() {
        super.onStop()
        lazyManager.reset()
    }
}