package com.viewbinder

import android.app.Activity


import android.app.Dialog
import android.app.Fragment


import android.support.annotation.IdRes
import android.view.View

@Suppress("UNCHECKED_CAST")
fun<T : View> Activity.bindView(@IdRes id: Int): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(id) }

@Suppress("UNCHECKED_CAST")
fun<T : View> Fragment.abstractBind(@IdRes id: Int, lazyManager: ResettableLazyManager)
        : ResettableLazy<T> = ResettableLazy(lazyManager) { view.findViewById<T>(id) }
@Suppress("UNCHECKED_CAST")
fun <T : View> View.bindView(id: Int) : Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { rootView.findViewById<T>(id) }
@Suppress("UNCHECKED_CAST")
fun <T : View> Dialog.bindView(id: Int) : Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(id) }

//private fun viewNotFound(id:Int, desc: KProperty<*>): Nothing =
//        throw IllegalStateException("View ID $id for '${desc.name}' not found.")


