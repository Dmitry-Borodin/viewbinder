package android.app

import android.support.annotation.IdRes
import android.view.View

/**
 * @author Dmitry Borodin on 2017-10-14.
 */
open class Activity {

//    fun findViewById(@IdRes id: Int): View {
//        throw NotImplementedError("stub")
//    }

    open fun <T : View> findViewById(@IdRes id: Int): T {
        throw NotImplementedError("stub")
    }
}
