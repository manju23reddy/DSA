# Has Duplicate
## Leet Code
### Easy
### Two Pointers
Solve this using Set, which will hold the seen numbers. As We iterate through the array, we check if the current number is in the set. If it is, we return true. If it is not, we add it to the set. If we finish the loop, we return false.

Example :
```
fun hasDuplicate(items: IntArray): Boolean {
    val seen = mutableSetOf<Int>()
        items.forEach {
    if (seen.contains(it))
        return true
    seen.add(it)
    }
    return false
}
```