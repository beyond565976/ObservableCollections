package il.co.theblitz.observablecollections.lists

import android.annotation.TargetApi
import il.co.theblitz.observablecollections.abstracts.ObservableList
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*
import java.util.function.UnaryOperator

class ObservableArrayList<X>: ObservableList<X, ArrayList<X>>(), RandomAccess, Cloneable,
    Serializable {
    init {
        collection = ArrayList<X>()
    }

    fun add(index: Int, element: X) {
        collection!!.add(index, element)
        signalChanged(ObservableCollectionsAction.Add, actionElement = element)
    }

    fun addAll(index: Int, elements: Collection<X>): Boolean {
        val added = collection!!.addAll(index, elements)
        if (added)
            signalChanged(ObservableCollectionsAction.AddAll, actionElements = elements, resultBoolean = added)
        return added
    }

    @TargetApi (24)
    fun replaceAll(operator: UnaryOperator<X>) {
        collection!!.replaceAll(operator)
        signalChanged(ObservableCollectionsAction.ReplaceAll)
    }

    fun trimToSize() {
        collection!!.trimToSize()
    }

    fun toArray(): Array<Any>? {
        return collection!!.toArray()
    }

    fun <T : Any?> toArray(a: Array<T>?): Array<T> {
        return collection!!.toArray(a)
    }

    fun removeAt(index: Int): X {
        val resultElement = collection!!.removeAt(index)
        signalChanged(ObservableCollectionsAction.RemoveAt, actionInt = index, resultElement = resultElement)
        return resultElement
    }

//    fun sort(c: Comparator<in X>?) {
//        collection!!.sort(c)
//    }

    fun set(index: Int, element: X): X {
        val resultElement = collection!!.set(index, element)
        signalChanged(ObservableCollectionsAction.Set, actionInt = index, actionElement = element, resultElement = resultElement)
        return resultElement
    }

    fun ensureCapacity(minCapacity: Int) {
        collection!!.ensureCapacity(minCapacity)
    }
}