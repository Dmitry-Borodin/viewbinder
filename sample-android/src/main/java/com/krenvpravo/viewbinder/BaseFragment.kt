package com.krenvpravo.viewbinder

import android.app.Fragment
import android.view.View
import com.viewbinder.ResettableLazy
import com.viewbinder.LazyResetter
import com.viewbinder.abstractBindView

/**
 * @author Dmitry Borodin on 2017-10-10.
 */
open class BaseFragment : Fragment() {

    val lazyManager = LazyResetter()
    fun<T : View> bind(id: Int): ResettableLazy<T> = abstractBindView(id, lazyManager)

    override fun onStop() {
        super.onStop()
        lazyManager.reset()
    }
}