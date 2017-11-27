package com.viewbinder

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View

fun<T : View> Fragment.abstractBind(@IdRes res: Int, lazyManager: ResettableLazyManager)
        : ResettableLazy<T> = com.viewbinder.ResettableLazy(lazyManager) { view.findViewById<T>(res) }
fun <T : View> Fragment.bindColor(id: Int)
        : Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { context.getColor(id)) }

fun <T : View> RecyclerView.ViewHolder.bindView(id: Int)
        : Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { itemView.findViewById<T>(id) }