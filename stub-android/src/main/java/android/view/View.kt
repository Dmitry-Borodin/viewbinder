package android.view

import android.support.annotation.IdRes

/**
 * @author Dmitry Borodin on 9/14/17.
 */

@Suppress("UNUSED_PARAMETER")
open class View {

    fun findViewById(@IdRes id: Int): View {
        throw NotImplementedError("stub")
    }
    val rootView: View
        get() = throw NotImplementedError("stub")
}
