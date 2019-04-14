package il.co.theblitz.observablecollections.full

import il.co.theblitz.observablecollections.abstracts.ObservableAbstractSet
import java.io.Serializable

open class ObservableHashSet<X>: ObservableAbstractSet<X, HashSet<X>>(), Serializable {

    init {
        collection = HashSet<X>()
    }
}