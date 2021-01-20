package p1640

class Solution {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val map = HashMap<Int, IntArray>(512)
        pieces.forEach {
            map[it.first()] = it
        }
        println(map)
        var a: IntArray
        var p = 0
        while (p < arr.size) {
            a = map[arr[p]] ?: return false
            a.forEach {
                if (it != arr[p]) {
                    return false
                }
                p++
            }
        }
        return true
    }
}

fun main(){
    val s  = Solution()
    s.canFormArray(intArrayOf(85), arrayOf(intArrayOf(85)))
}