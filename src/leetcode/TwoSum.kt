package leetcode

import java.util.*
import kotlin.collections.HashMap

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val num = nums[i]
            val requireNum = target - num

            if (map.containsKey(requireNum)) {
                val requiredNumIdx = requireNotNull(map[requireNum])
                return intArrayOf(requiredNumIdx, i)
            }

            map[num] = i
        }

        throw IllegalArgumentException("Wrong arguments")
    }
}

fun main() {
    val twoSum = TwoSum().twoSum(intArrayOf(2, 7, 11, 15), 9)
    println(Arrays.toString(twoSum))
}