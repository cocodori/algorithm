package leetcode

fun main() {
    val binarySearch = BinarySearch()
    val search = binarySearch.search(intArrayOf(-1, 0, 3, 5, 9, 12), 9)
    val search1 = binarySearch.search(intArrayOf(-1, 0, 3, 5, 9, 12), 2)
    val search2 = binarySearch.search(intArrayOf(-1,0,3,5,9,12), 2)
    println(search)
    println(search1)
    println(search2)
}

class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var pivot = nums.size / 2
        var fromIndex = 0
        var toIndex = nums.size - 1

        return searchTarget(nums, target, pivot, fromIndex, toIndex)
    }

    private fun searchTarget(
        nums: IntArray,
        target: Int, pivot: Int,
        fromIndex: Int,
        toIndex: Int
    ): Int {
        if (validateTargetExist(fromIndex, toIndex)) return -1

        return when {
            nums[pivot] == target -> {
                pivot
            }
            nums[pivot] > target -> { //target이 중간 값보다 작을 때
                val toIndex = pivot - 1
                val pivot = pivot / 2
                searchTarget(nums, target, pivot, fromIndex, toIndex)
            }
            nums[pivot] < target -> { //target이 중간 값보다 클 때
                val fromIndex = pivot + 1
                val pivot = (pivot + toIndex + 1) / 2 //[-1, 0, 3]이고 target이 2일 때 2/2가 나와서 1로 무한루프 돌아서 +1처리
                searchTarget(nums, target, pivot, fromIndex, toIndex)
            }
            else -> throw RuntimeException()
        }
    }

    private fun validateTargetExist(fromIndex: Int, toIndex: Int): Boolean {
        val isNotExistTarget = fromIndex > toIndex
        if (isNotExistTarget) return true
        return false
    }
}