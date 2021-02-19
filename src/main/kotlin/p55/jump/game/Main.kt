package p55.jump.game

import java.lang.StringBuilder
import kotlin.math.max

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxJump = nums[0]
        for (i in 1..nums.lastIndex){
            maxJump = max(maxJump, nums[i])
            if (maxJump == 0 )return false
            maxJump--
        }
        return true
    }
}