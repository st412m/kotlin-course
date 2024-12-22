package org.st412m.kotlincourse.lesson31.homework.unit

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.jvm.java
import kotlin.test.assertFailsWith

class CerealStorageImplTest {
    private val containerCapacity = 10f
    private val storageCapacity = 50f
    private val storage = CerealStorageImpl(containerCapacity, storageCapacity)

    //val containerCapacity

    @Test
    fun `should @throws IllegalArgumentException if value containerCapacity is negative on initialization`() {
        assertThrows(IllegalArgumentException::class.java) {
            CerealStorageImpl(-1f, 50f)
        }
    }

    //val storageCapacity

    @Test
    fun `throws IllegalArgumentException if storageCapacity is less than containerCapacity at initialization`() {
        assertThrows(IllegalArgumentException::class.java) {
            CerealStorageImpl(10f, 1f)
        }
    }

    // fun addCereal

    @Test
    fun `throws IllegalArgumentException if a negative value is passed in  fun addCereal`() {
        assertThrows(IllegalArgumentException::class.java) {
            storage.addCereal(Cereal.BUCKWHEAT, -1f)
        }
    }

    @Test
    fun `throws IllegalStateException if the storage does not allow placing another container for the new cereal`() {
        storage.addCereal(Cereal.RICE, containerCapacity)
        storage.addCereal(Cereal.BUCKWHEAT, containerCapacity)
        storage.addCereal(Cereal.MILLET, containerCapacity)
        storage.addCereal(Cereal.PEAS, containerCapacity)
        storage.addCereal(Cereal.BULGUR, containerCapacity)
        assertFailsWith<IllegalStateException> {
            storage.addCereal(Cereal.RICE, 1f)
        }
    }

    @Test
    fun `should not overflow if the amount fits into the container`() {
        val remaining = storage.addCereal(Cereal.RICE, 5f)
        assertEquals(0f, remaining, 0.01f)
        assertEquals(5f, storage.getAmount(Cereal.RICE), 0.01f)
    }

    // fun getCereal

    @Test
    fun `throws IllegalArgumentException if a negative value is passed in  fun getCereal`() {
        storage.addCereal(Cereal.RICE, 10f)
        assertThrows(IllegalArgumentException::class.java) {
            storage.getCereal(Cereal.RICE, -5f)
        }
    }

    @Test
    fun `return the amount of cereal received or the remainder if it was less`() {
        storage.addCereal(Cereal.RICE, 10f)
        val remaining1 = storage.getCereal(Cereal.RICE, 5f)
        assertEquals(0f, remaining1, 0.01f)
        assertEquals(5f, storage.getAmount(Cereal.RICE), 0.01f)

        val remaining2 = storage.getCereal(Cereal.RICE, 10f)
        assertEquals(5f, remaining2, 0.01f)

        assertEquals(0f, storage.getAmount(Cereal.RICE), 0.01f)
    }
//     fun removeContainer
    @Test
    fun `return true remove container if exists`() {
        storage.addCereal(Cereal.RICE, 10f)
        val removed = storage.removeContainer(Cereal.RICE)
        assertTrue(removed)
    }

    @Test
    fun `return false if container does not exist`() {
        val removed = storage.removeContainer(Cereal.RICE)
        assertFalse(removed)
    }
//  fun getAmount
    @Test
    fun `should return the correct amount of cereal in storage`() {
        storage.addCereal(Cereal.RICE, 10f)
        val amount = storage.getAmount(Cereal.RICE)
        assertEquals(10f, amount, 0.01f)
    }

    @Test
    fun `should return 0 if cereal is not in storage`() {
        val amount = storage.getAmount(Cereal.RICE)
        assertEquals(0f, amount, 0.01f)
    }

    @Test
    fun `should return correct amount after container overflow`() {
        storage.addCereal(Cereal.RICE, 15f)
        val amount = storage.getAmount(Cereal.RICE)
        assertEquals(10f, amount, 0.01f)
    }

    //fun getSpace
    @Test
    fun `should return the amount of cereal that can still fit in the container with current capacity`() {
        storage.addCereal(Cereal.RICE, 5f)

        val remainingCapacity = storage.getSpace(Cereal.RICE)
        assertEquals(5f, remainingCapacity, 0.01f)

        storage.addCereal(Cereal.RICE, 3f)

        val updatedRemainingCapacity = storage.getSpace(Cereal.RICE)
        assertEquals(2f, updatedRemainingCapacity, 0.01f)


        storage.addCereal(Cereal.RICE, 2f)

        val finalRemainingCapacity = storage.getSpace(Cereal.RICE)
        assertEquals(0f, finalRemainingCapacity, 0.01f)
    }
    // override fun toString
    @Test
    fun `toString should return a correct representation of the storage when it contains cereals`() {
        storage.addCereal(Cereal.RICE, 5f)
        storage.addCereal(Cereal.BUCKWHEAT, 3f)

        val storageString = storage.toString()
        assertEquals("RICE: 5.0 единиц, BUCKWHEAT: 3.0 единиц", storageString)
    }

    @Test
    fun `toString should return a message when storage is empty`() {
        val storageString = storage.toString()
        assertEquals("Хранилище пусто", storageString)
    }

    @Test
    fun `toString should update correctly after removing a cereal`() {
        storage.addCereal(Cereal.RICE, 5f)
        storage.addCereal(Cereal.BUCKWHEAT, 3f)

        storage.removeContainer(Cereal.BUCKWHEAT)

        val storageString = storage.toString()
        assertEquals("RICE: 5.0 единиц", storageString)
    }
}







