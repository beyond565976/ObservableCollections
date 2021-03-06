package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.concurrent.ArrayBlockingQueue

open class ObservableArrayBlockingQueue<X>(): ObservableBlockingQueue<X, ArrayBlockingQueue<X>>(), Serializable {

    constructor(capacity: Int, fair: Boolean, inCollection: MutableCollection<X>): this() {
        collection = ArrayBlockingQueue<X>(capacity, fair, inCollection)
    }

    constructor(capacity: Int, fair: Boolean): this() {
        collection = ArrayBlockingQueue<X>(capacity, fair)
    }

    constructor(capacity: Int): this() {
        collection = ArrayBlockingQueue<X>(capacity)
    }
}