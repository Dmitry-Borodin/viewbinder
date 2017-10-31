package com.viewbinder

import android.app.Fragment
import android.support.annotation.IdRes
import android.view.View
import com.bluelinelabs.conductor.Controller

/**
 * @author Dmitry Borodin on 2017-10-27.
 */

fun <T : View> Controller.abstractBindView(id: Int, rootView: View?)
        : Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { rootView!!.findViewById<T>(id) }