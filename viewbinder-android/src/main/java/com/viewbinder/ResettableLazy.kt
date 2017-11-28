package com.viewbinder

import java.util.*
import kotlin.reflect.KProperty

class BindingResetter {
    private val managedResettable = LinkedList<Resettable>()

    fun register(managed: Resettable) {
        managedResettable.add(managed)
    }

    fun reset() {
        managedResettable.forEach { resettable -> resettable.reset() }
    }
}

interface Resettable {
    fun reset()
}

class ResettableLazy<T>(private val manager: BindingResetter,
                        private val init: () -> T) : Resettable {

    var lazyHolder : Lazy<T>? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = lazyHolder?.value ?: initLazyHolder().value

    override fun reset() {
        lazyHolder = null
    }

    private fun initLazyHolder(): Lazy<T> {
        val lazyHolder = lazy(LazyThreadSafetyMode.NONE) {
            manager.register(this)
            init()
        }
        this.lazyHolder = lazyHolder
        return lazyHolder
    }
}
