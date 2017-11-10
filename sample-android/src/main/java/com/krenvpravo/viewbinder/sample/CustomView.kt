package com.krenvpravo.viewbinder.sample

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

/**
 * @author Dmitry Borodin on 2017-10-22.
 */
class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                           defStyleAttr: Int = 0) : ViewGroup(context, attrs, defStyleAttr) {

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }
}