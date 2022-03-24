package leetcode

class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        var k = k
        while ((k--) > 0) {
            val lastEle = nums[nums.lastIndex]
            var prevEle = nums[0]
            nums[0] = lastEle

            for(i in 1 until nums.size) {
                val temp = nums[i]
                nums[i] = prevEle
                prevEle = temp
            }
        }
    }
}

fun main() {
    val input1 = intArrayOf(1,2,3,4,5,6,7)
    val input2 = intArrayOf(-1, 100, 3, 99)
    val result1 = RotateArray().rotate(input1, 3)
    val result2 = RotateArray().rotate(input2, 2)

//    println(result1.contentToString())
//    println(result2.contentToString())
}