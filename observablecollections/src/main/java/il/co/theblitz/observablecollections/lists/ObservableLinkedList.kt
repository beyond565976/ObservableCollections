package il.co.theblitz.observablecollections.lists

import il.co.theblitz.observablecollections.abstracts.ObservableDeque
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*


class ObservableLinkedList<X>: ObservableDeque<X, LinkedList<X>>(), Serializable {

    init {
        collection = LinkedList<X>()
    }

    fun add(index: Int, element: X) {
        signalChanged(ObservableCollectionsAction.Add, actionElement = element)
        collection!!.add(index, element)
    }

    fun addAll(index: Int, elements: Collection<X>): Boolean {
        val added = collection!!.addAll(index, elements)
        if (added)
            signalChanged(ObservableCollectionsAction.AddAll, actionElements = elements, resultBoolean = added)
        return added
    }

    fun lastIndexOf(element: X): Int {
        return collection!!.lastIndexOf(element)
    }

    fun listIterator(index: Int): MutableListIterator<X> {
        return collection!!.listIterator(index)
    }

    fun clone(): Any {
        return collection!!.clone()
    }

    fun get(index: Int): X {
        return collection!!.get(index)
    }

    fun toArray(): Array<Any> {
        return collection!!.toArray()
    }

    fun <T : Any?> toArray(a: Array<out T>?): Array<T> {
        return collection!!.toArray(a)
    }

    fun indexOf(element: X): Int {
        return collection!!.indexOf(element)
    }

    fun listIterator(): MutableListIterator<X> {
        return collection!!.listIterator()
    }

    fun subList(fromIndex: Int, toIndex: Int): MutableList<X> {
        return collection!!.subList(fromIndex, toIndex)
    }

    fun removeAt(index: Int): X {
        val resultElement = collection!!.removeAt(index)
        signalChanged(ObservableCollectionsAction.RemoveAt, actionInt = index, resultElement = resultElement)
        return resultElement
    }

    fun set(index: Int, element: X): X {
        val resultElement = collection!!.set(index, element)
        signalChanged(ObservableCollectionsAction.Set, actionInt = index, actionElement = element, resultElement = resultElement)
        return resultElement
    }

//    @TargetApi (24)
//    fun spliterator(): Spliterator<X> {
//        return collection!!.spliterator()
//    }
}