package p58.length.of.last.word

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var p = s.lastIndex
        while (p >= 0 && s[p] == ' ')
            p--
        var q = p
        while (q >= 0 && s[q] != ' ')
            q--
        return if (p < 0) 0
        else p - q
    }
}