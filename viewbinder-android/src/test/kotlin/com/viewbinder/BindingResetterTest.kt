package com.viewbinder

import org.junit.Assert.*
import org.junit.Test

class BindingResetterTest {
    @Test
    fun testBindingResetter() {
        class Something {
            var seed = 1
            val resetter = BindingResetter()
            val x: String by ResettableLazy(resetter) { "x ${seed}" }
            val y: String by ResettableLazy(resetter) { "y ${seed}" }
            val z: String by ResettableLazy(resetter) { "z $x $y" }
        }

        val s = Something()
        val x1 = s.x
        val y1 = s.y
        val z1 = s.z

        assertEquals(x1, s.x)
        assertEquals(y1, s.y)
        assertEquals(z1, s.z)

        s.seed++ // without reset nothing should change

        assertTrue(x1 === s.x)
        assertTrue(y1 === s.y)
        assertTrue(z1 === s.z)

        s.resetter.reset()

        s.seed++ // because of reset the values should change

        val x2 = s.x
        val y2 = s.y
        val z2 = s.z

        assertEquals(x2, s.x)
        assertEquals(y2, s.y)
        assertEquals(z2, s.z)

        assertNotEquals(x1, x2)
        assertNotEquals(y1, y2)
        assertNotEquals(z1, z2)

        s.seed++ // but without reset, nothing should change

        assertTrue(x2 === s.x)
        assertTrue(y2 === s.y)
        assertTrue(z2 === s.z)
    }
}