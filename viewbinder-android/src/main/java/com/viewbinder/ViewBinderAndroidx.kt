package com.viewbinder

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.support.annotation.IdRes
import android.view.View

/**
 * @author Dmitry Borodin on 12/3/18.
 */

fun <T : View> Fragment.abstractBind(@IdRes res: Int, resetter: BindingResetter): ResettableLazy<T>
        = ResettableLazy(resetter) { view.findViewById<T>(res) }
fun Fragment.bindColor(id: Int): Lazy<Int> = lazy(LazyThreadSafetyMode.NONE) { ContextCompat.getColor(context, id) }

fun <T : View> RecyclerView.ViewHolder.bindView(id: Int): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { itemView.findViewById<T>(id) }
fun RecyclerView.ViewHolder.bindColor(id: Int): Lazy<Int>
        = lazy(LazyThreadSafetyMode.NONE) { ContextCompat.getColor(itemView.context, id) }