package android.app

import android.content.Context
import android.support.annotation.IdRes
import android.view.View

/**
 * @author Dmitry Borodin on 2017-10-14.
 */
class Activity {

    //	public View findViewById(@IdRes int id) {
    //		throw new NotImplementedError("stub");
    //	}

    fun <T : View> findViewById(@IdRes id: Int): T = throw NotImplementedError("stub")

    val context: Context
        get() = throw NotImplementedError("stub")
}
