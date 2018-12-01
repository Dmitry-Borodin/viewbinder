package android.support.v4.app

import android.content.Context
import android.view.View


class Fragment {
    val view: View
        get() = throw NotImplementedError("stub")
    val context: Context
        get() = throw NotImplementedError("stub")
}
