package arrays.hasDuplicate

fun hasDuplicate(items: IntArray): Boolean {
    val seen = mutableSetOf<Int>()
    items.forEach {
        if (seen.contains(it))
            return true
        seen.add(it)
    }
    return false
}