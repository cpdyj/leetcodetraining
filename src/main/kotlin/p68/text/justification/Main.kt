package p68.text.justification

class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val wordSize = IntArray(words.size) { words[it].length }
        var pos = 0
        val list = mutableListOf<String>()
        val b = StringBuilder(maxWidth + 5)
        while (true) {
            val rr = findNearlyLineSize(pos, wordSize, maxWidth)
            val end = rr shr 16
            val space = rr and 0xff
        }
    }

    tailrec fun findNearlyLineSize(pos: Int, ws: IntArray, space: Int, count: Int = 0): Int {
        if (pos == ws.size) return (pos shl 16) + space
        if (space - ws[pos] - count < 0) return (pos shl 16) + space
        return findNearlyLineSize(pos + 1, ws, space - ws[pos], count + 1)
    }

    fun fillSpace(start: Int, end: Int, space: Int, target: IntArray) {
        val c = end - start - 1
        val base = if (c > 0) space / c else 0
        val padding = space - base
        var p = start
        while (p < end) {
            if (p == start) {
                target[p] = padding + base
            } else {
                target[p] = base
            }
        }
    }
}

fun main() {
    val s = Solution()
    val t = s.findNearlyLineSize(0, intArrayOf(4, 2, 2, 7, 2, 4, 14), 16)
    check(t shr 16 == 3 && t and 0xff == 6) { "${t shr 16} / ${t and 0xff}" }
}
