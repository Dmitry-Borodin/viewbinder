package com.krenvpravo.sampleappcompat.otherscreens

import android.os.Bundle
import android.view.View
import com.bluelinelabs.conductor.Controller
import com.viewbinder.abstractBindView

/**
 * @author Dmitry Borodin on 2017-10-31.
 */
abstract class BaseController(args: Bundle? = null) : Controller(args) {
    lateinit var rootView: View
    fun <T : View> bindView(id: Int): Lazy<T> = abstractBindView(id, rootView)
}