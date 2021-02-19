package p1616.split.two.strings.to.make.palindrome

class Solution {
    fun checkPalindromeFormation(a: String, b: String): Boolean {
        return c(a, b) || c(b, a)
    }

    fun c(a: String, b: String): Boolean {
        val l = a.length
        var rp = l / 2
        var lp = rp - 1 + (l and 1)
        var ls = a
        var rs = a
        while (lp > -1) {
            if (ls[lp] != rs[rp]) {
                if (ls != rs) return false
                if (ls[lp] == b[rp]) {
                    rs = b
                } else if (rs[rp] == b[lp]) {
                    ls = b
                } else return false
            }
            lp--
            rp++
        }
        return true
    }
}

fun main() {
    val s = Solution()
    val a = "abdef"
    val b = "fecab"
    println(s.checkPalindromeFormation(a, b))
    println(s.checkPalindromeFormation("x", "y"))
}