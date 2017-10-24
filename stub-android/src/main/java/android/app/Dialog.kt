package android.app

import android.support.annotation.IdRes
import android.view.View

/**
 * @author Dmitry Borodin on 2017-10-14.
 */
@Suppress("UNUSED_PARAMETER")
public class Dialog {

    fun findViewById(@IdRes id: Int): View {
        throw NotImplementedError("stub")
    }
}