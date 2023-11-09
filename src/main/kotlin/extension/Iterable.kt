package extension


fun <T, K> Iterable<T>.groupBySingle(keySelector: (T) -> K): Map<K, T> {
    val destination = LinkedHashMap<K, T>()
    for (element in this) {
        val key = keySelector(element)
        if (destination.contains(key)) {
            throw IllegalStateException("Element with the same key is already exist: $element")
        }
        destination[key] = element
    }
    return destination
}