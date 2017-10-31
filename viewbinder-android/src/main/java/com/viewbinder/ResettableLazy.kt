package com.viewbinder

import java.util.*
import kotlin.reflect.KProperty

class LazyResetter {
    private val managedDelegates = LinkedList<Resettable>()

    fun register(managed: Resettable) {
        managedDelegates.add(managed)
    }

    fun reset() {
        managedDelegates.forEach { resettable -> resettable.reset() }
    }
}

interface Resettable {
    fun reset()
}

class ResettableLazy<T>(private val resetter: LazyResetter,
                        private val init: () -> T) : Resettable {

    var lazyHolder : Lazy<T>? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = lazyHolder?.value ?: initLazyHolder().value

    override fun reset() {
        lazyHolder = null
    }

    private fun initLazyHolder(): Lazy<T> {
        val lazyHolder = lazy(LazyThreadSafetyMode.NONE) {
            resetter.register(this)
            init()
        }
        this.lazyHolder = lazyHolder
        return lazyHolder
    }
}
