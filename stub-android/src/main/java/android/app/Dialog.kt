package android.app

import android.support.annotation.IdRes
import android.view.View

/**
 * @author Dmitry Borodin on 2017-10-14.
 */
@Suppress("UNUSED_PARAMETER")
class Dialog {

    fun <T : View> findViewById(@IdRes id: Int): T = throw NotImplementedError("stub")
}