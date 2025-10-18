# Anagram
## Leet Code
### Easy
### using Array
Solve this using Array, which will hold the count of each character. As We iterate through the array, we check if the current number is in the set. If it is, we return true. If it is not, we add it to the set. If we finish the loop, we return false.

Example :
```
    fun isAnagram(s: String, t: String): Boolean {
        val alphabet = IntArray(26) { 0 }
        s.forEach {
        alphabet[it - 'a']++
        }
        t.forEach {
        alphabet[it - 'a']--
        }
        return alphabet.all { it == 0 }
    }
```
