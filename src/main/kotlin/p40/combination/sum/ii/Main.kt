package p40.combination.sum.ii

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val res = HashSet<List<Int>>()
        awsl(candidates, target, 0, res, ArrayList(30))
        return res.toList()
    }

    fun awsl(candidates: IntArray, target: Int, pos: Int, res: HashSet<List<Int>>, t: ArrayList<Int>) {
        if (pos == candidates.size) return
        val n = candidates[pos]
        if (n > target) return
        awsl(candidates, target, pos + 1, res, t)
        t.add(n)
        if (n == target) {
            res.add(t.toList())
        } else {
            if (target - n >= n)
                awsl(candidates, target - n, pos + 1, res, t)
        }
        t.removeAt(t.lastIndex)
    }
}