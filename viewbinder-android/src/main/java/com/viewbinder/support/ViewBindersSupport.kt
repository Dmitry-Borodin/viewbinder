package com.viewbinder.support

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.viewbinder.BindingResetter
import com.viewbinder.ResettableLazy

fun <T : View> Fragment.abstractBind(@IdRes res: Int, resetter: BindingResetter): ResettableLazy<T>
        = ResettableLazy(resetter) { view.findViewById<T>(res) }
fun Fragment.bindColor(id: Int): Lazy<Int> = lazy(LazyThreadSafetyMode.NONE) { ContextCompat.getColor(context, id) }

fun <T : View> RecyclerView.ViewHolder.bindView(id: Int): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { itemView.findViewById<T>(id) }
fun RecyclerView.ViewHolder.bindColor(id: Int): Lazy<Int>
        = lazy(LazyThreadSafetyMode.NONE) { ContextCompat.getColor(itemView.context, id) }