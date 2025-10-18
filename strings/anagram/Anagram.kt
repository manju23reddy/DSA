package strings.anagram

class Anagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        
        val charCount = IntArray(26) { 0 }
        
        for (i in s.indices) {
            charCount[s[i] - 'a']++
            charCount[t[i] - 'a']--
        }
        
        return charCount.all { it == 0 }
    }
}

