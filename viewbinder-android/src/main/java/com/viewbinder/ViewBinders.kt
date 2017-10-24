package com.viewbinder

import android.app.Activity


import android.app.Dialog
import android.app.Fragment


import android.support.annotation.IdRes
import android.view.View

//public fun<T : View> Activity.bindView(@IdRes id: Int): Lazy<T> = lazy { findViewById(id) as T } //TODO check whether is will be generified in android docks
@Suppress("UNCHECKED_CAST")
fun<T : View> Activity.bindView(@IdRes id: Int): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(id) }

@Suppress("UNCHECKED_CAST")
fun<T : View> Fragment.abstractBind(@IdRes id: Int, lazyManager: ResettableLazyManager)
        : ResettableLazy<T> = ResettableLazy(lazyManager) { view.findViewById(id) as T }
@Suppress("UNCHECKED_CAST")
fun <T : View> View.bindView(id: Int) : Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { rootView.findViewById(id) as T }
@Suppress("UNCHECKED_CAST")
fun <T : View> Dialog.bindView(id: Int) : Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { findViewById(id) as T }


//private fun viewNotFound(id:Int, desc: KProperty<*>): Nothing =
//        throw IllegalStateException("View ID $id for '${desc.name}' not found.")


