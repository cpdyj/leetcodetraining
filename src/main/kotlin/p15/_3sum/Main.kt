package p15._3sum

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val map = mutableMapOf<Int, Int>()
        val res = HashSet<List<Int>>()
        nums.forEach {
            val n = map[it] ?: 0
            map[it] = n + 1
        }
        nums.forEachIndexed { ia, a ->
            map[a] = map[a]!! - 1
            nums.forEachIndexed { ib, b ->
                if (ia < ib) {
                    val c = map[-a - b] ?: 0
                    if (c > 0&&b!=-a-b||c>1&&b==-a-b) {
                        res.add(arrayListOf(a, b, -a - b).sorted())
                        println("==>${arrayListOf(a, b, -a - b)}")
                    }
                }
            }
        }
        return res.toList()
    }

}

fun main(){
    val s = Solution()
    println(s.threeSum(intArrayOf(1,2,-2,-1)))
}