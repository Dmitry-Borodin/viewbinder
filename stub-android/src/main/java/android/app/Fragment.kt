package android.app

import android.view.View

/**
 * @author Dmitry Borodin on 2017-10-14.
 */
class Fragment {
    val view: View
        get() = throw NotImplementedError("stub")

//    val context: Context //work only at recent api
//        get() = throw NotImplementedError("stub")
}
