package com.viewbinder

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View

@Suppress("UNCHECKED_CAST")
public fun<T : View> Fragment.abstractBindView(@IdRes res: Int, lazyResetter: LazyResetter)
        : ResettableLazy<T> = com.viewbinder.ResettableLazy(lazyResetter) { view.findViewById<T>(res) }

@Suppress("UNCHECKED_CAST")
public fun <T : View> RecyclerView.ViewHolder.bindView(id: Int)
        : Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { itemView.findViewById<T>(id) }