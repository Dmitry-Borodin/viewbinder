package android.content

import android.content.res.Resources

/**
 * @author Dmitry Borodin on 2017-11-27.
 */
@Suppress("UNUSED_PARAMETER")
class Context {
    val resources: Resources
        get() = throw NotImplementedError("stub!")

    fun getTheme(): Resources.Theme = throw NotImplementedError("stub")
}