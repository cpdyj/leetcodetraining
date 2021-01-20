package p39.comnination.sum

import java.util.*

class Solution {

    val resList = LinkedList<List<Int>>()
    val t = IntArray(500)
    var tp = 0

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        awsl(candidates, 0, target)
        return resList
    }

    fun awsl(candidates: IntArray, pos: Int, target: Int) {
        if (pos == candidates.size) return
        val n = candidates[pos]
        var s = 0
        val _tp = tp
        while (s < target) {
            awsl(candidates, pos + 1, target - s)
            t[tp] = n
            tp++
            s += n
        }
        if (s == target) {
            resList.add(t.slice(0 until tp))
        }
        tp = _tp
    }

}

fun main() {
    val s = Solution()
    val i = intArrayOf(2, 3, 6, 7)
   repeat(1000000) { s.combinationSum(i, 7)/*.let { println(it) }*/ }
}