package android.support.v7.app

import android.support.annotation.IdRes
import android.view.View


@Suppress("UNUSED_PARAMETER")
class AppCompatActivity {

    fun <T : View> findViewById(@IdRes id: Int): T {
        throw NotImplementedError("stub")
    }
}
