package android.app

import android.content.Context
import android.view.View

/**
 * @author Dmitry Borodin on 2017-10-14.
 */
class Fragment {
    val view: View
        get() = throw NotImplementedError("stub")

    val context: Context
        get() = throw NotImplementedError("stub")
}
