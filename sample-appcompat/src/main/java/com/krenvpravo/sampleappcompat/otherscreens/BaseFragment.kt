package com.krenvpravo.sampleappcompat.otherscreens

import android.support.v4.app.Fragment
import android.view.View
import com.viewbinder.ResettableLazy
import com.viewbinder.ResettableLazyManager
import com.viewbinder.abstractBind

/**
 * @author Dmitry Borodin on 2017-10-10.
 */
open class BaseFragment : Fragment() {

    val lazyManager = ResettableLazyManager()
    fun <T : View> Fragment.bind(id: Int): ResettableLazy<T> = abstractBind(id, lazyManager)

    /**
     *  Reset lazy at stop, so next time we'll touch views they will be bound again, because
     *  fragment will recreate it's view hierarchy after restoring from backstack
     */
    override fun onStop() {
        super.onStop()
        lazyManager.reset()
    }
}