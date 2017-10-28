package com.viewbinder

import android.view.View
import com.bluelinelabs.conductor.Controller

/**
 * @author Dmitry Borodin on 2017-10-27.
 */
public fun <T : View> Controller.bindView(id: Int)
        : Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { view.findViewById<T>(id) }