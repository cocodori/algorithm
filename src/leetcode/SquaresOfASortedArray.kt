package leetcode

import java.util.*

class SquaresOfASortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        val squared = nums.map { it * it }
        return squared.sorted().toIntArray()
    }
}

fun main() {
    SquaresOfASortedArray2().sortedSquares(intArrayOf(-7,-3,2,3,11))
}

class SquaresOfASortedArray2 {
    fun sortedSquares(nums: IntArray): IntArray {
        val bst = BinarySearchTree()
        nums.forEach { bst.add(it * it) }
        return bst.toIntArray()
    }
}

class BinarySearchTree {
    private var root: Node? = null
    var size = 0

    fun add(element: Int) {
        size++
        val node = Node(element)
        if (root == null) {
            root = node
            return
        }
        var prev: Node? = null
        var temp: Node? = root
        while (temp != null) {
            if (temp.element > element) {
                prev = temp
                temp = temp.left
            } else if (temp.element < element) {
                prev = temp
                temp = temp.right
            }
        }
        if (prev!!.element > element) {
            prev.left = node
        } else {
            prev.right = node
        }
    }

    fun toIntArray(): IntArray {
        var temp = root
        val stack = Stack<Node>()
        val result = IntArray(size)
        var i = 0
        while (temp!=null || !stack.isEmpty()) {
            if (temp!=null) {
                stack.add(temp)
                temp=temp.left
            } else {
                temp=stack.pop()
                result[i++] = temp?.element!!
                temp=temp.right
            }
        }

        return result
    }

    private inner class Node(
        val element: Int,
        var left: Node? = null,
        var right: Node? = null
    )
}
