//package com.tree
//
//import com.bean.ListNode
//import com.utils.TreeOperationUtils
//import java.util.*
//
//class BST {
//    var root: ListNode? = null
//    private var count = 0
//
//    // 返回二分搜索树的节点个数
//    fun size() = count
//
//    fun isEmpty() = count == 0
//
//    // 向二分搜索树中插入一个新的(key, value)数据对
//    fun insert(key: Int, value: String) {
//        root = insert(root, key, value)
//    }
//
//    // 查看二分搜索树中是否存在键key
//    fun contain(key: Int): Boolean {
//        return contain(root, key)
//    }
//
//    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
//    fun search(key: Int): String? {
//        return search(root, key)
//    }
//
//    fun minimum(): Int {
//        return minimum(root)
//    }
//
//    fun maximum(): Int {
//        return maximum(root)
//    }
//
//    fun removeMin() {
//        root?.let {
//            root = removeMin(it)
//        }
//    }
//
//    fun removeMax() {
//        root?.let {
//            root = removeMax(it)
//        }
//    }
//
//    // 二分搜索树的前序遍历
//    fun preOrder() {
//        preOrder(root)
//    }
//
//    // 二分搜索树的中序遍历
//    fun inOrder() {
//        inOrder(root)
//    }
//
//    fun levelOrder() {
//        if (root == null) {
//            return
//        }
//        val list = LinkedList<ListNode>()
//        list.add(root!!)
//        while (list.isNotEmpty()) {
//            val node = list.remove()
//            println(node.key)
//
//            node.left?.let {
//                list.add(it)
//            }
//            node.right?.let {
//                list.add(it)
//            }
//        }
//    }
//
//    fun remove(key: Int) {
//        remove(root, key)
//    }
//
//    //********************
//    //* 二分搜索树的辅助函数
//    //********************
//
//    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
//    // 返回插入新节点后的二分搜索树的根
//    //node为当前  父节点，不是根节点
//    private fun insert(node: Node?, key: Int, value: String): Node {
//        if (null == node) {
//            return Node(key, value)
//        }
//
//        when {
//            node.key == key -> {
//                node.value = value
//            }
//            node.key < key -> {
//                node.right = insert(node.right, key, value)
//            }
//            else -> {
//                node.left = insert(node.left, key, value)
//            }
//        }
//        return node
//    }
//
//    private fun contain(node: Node?, key: Int): Boolean {
//        if (node == null) {
//            return false
//        }
//
//        return when {
//            key == node.key -> {
//                true
//            }
//            key < node.key -> {
//                contain(node.left, key)
//            }
//            else -> {
//                contain(node.right, key)
//            }
//        }
//    }
//
//    private fun search(node: Node?, key: Int): String? {
//        if (node == null) {
//            return null
//        }
//        return when {
//            key == node.key -> {
//                node.value
//            }
//            key < node.key -> {
//                search(node.left, key)
//            }
//            else -> {
//                search(node.right, key)
//            }
//        }
//    }
//
//    private fun minimum(node: Node?): Int {
//        if (node?.left == null) {
//            return node!!.key;
//        }
//        return minimum(node.left)
//    }
//
//    private fun maximum(node: Node?): Int {
//        if (node?.right == null) {
//            return node!!.key
//        }
//
//        return maximum(node.right)
//    }
//
//
//    // 删除掉以node为根的二分搜索树中的最小节点
//    // 返回删除节点后新的二分搜索树的根
//    private fun removeMin(node: Node): Node? {
//        //这里才是真正  移除  的实现操作,必须是左子树为空的那个节点
//        return if (node.left == null) {
//            val nodeRight = node.right
//            node.right = null
//            count--
//            nodeRight
//        } else {
//            //这是一个递归操作，理论上如果 一直不触发的话，整棵树会一直保持不变的
//            node.left = removeMin(node.left!!)
//            node
//        }
//    }
//
//    private fun removeMax(node: Node): Node? {
//        return if (node.right == null) {
//            val nodeLeft = node.left
//            node.left = null
//            count--
//            nodeLeft
//        } else {
//            node.right = removeMax(node.right!!)
//            node
//        }
//    }
//
//    private fun preOrder(node: Node?) {
//        if (node != null) {
//            preOrder(node.left)
//            preOrder(node.right)
//            println(node.key)
//        }
//    }
//
//    private fun inOrder(node: Node?) {
//        if (node != null) {
//            inOrder(node.left)
//            println(node.key)
//            inOrder(node.right)
//        }
//    }
//
//    // 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
//    // 返回删除节点后新的二分搜索树的根
//    private fun remove(node: Node?, key: Int): Node? {
//        if (node == null) {
//            return null
//        }
//
//        if (key < node.key) {
//            node.left = remove(node.left, key)
//            return node
//        } else if (key > node.key) {
//            node.right = remove(node.right, key)
//            return node
//        } else {
//            if (node.left == null) {
//                val rightNode = node.right
//                node.right = null
//                count--
//                return rightNode
//            }
//
//            if (node.right == null) {
//                val leftNode = node.left
//                node.left = null
//                count--
//                return leftNode
//            }
//
//            // 待删除节点左右子树均不为空的情况
//
//            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
//            // 用这个节点顶替待删除节点的位置
////            val successor = Node(minimum(node.right))
//
//        }
//        return null
//    }
//}
//
//fun main(args: Array<String>) {
////    val N = 3
//
//    // 创建一个数组，包含[0...N)的所有元素
//
//    // 创建一个数组，包含[0...N)的所有元素
////    val arr = arrayOfNulls<Int>(N)
////    for (i in 0 until N) arr[i] = i
//
//    // 打乱数组顺序
//
//    // 打乱数组顺序
////    for (i in 0 until N) {
////        val pos = (Math.random() * (i + 1)).toInt()
////        val t = arr[pos]
////        arr[pos] = arr[i]
////        arr[i] = t
////    }
//
//    // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
////    // 键值的对应关系为每个整型对应代表这个整型的字符串
//    val bst = BST()
////    for (i in 0 until N) bst.insert(arr[i]!!, (arr[i]!!).toString())
//
//    // 对[0...2*N)的所有整型测试在二分搜索树中查找
//    // 若i在[0...N)之间，则能查找到整型所对应的字符串
//    // 若i在[N...2*N)之间，则结果为null
//
//    // 对[0...2*N)的所有整型测试在二分搜索树中查找
//    // 若i在[0...N)之间，则能查找到整型所对应的字符串
//    // 若i在[N...2*N)之间，则结果为null
////    for (i in 0 until 2 * N) {
////        val res: String? = bst.search(i)
////        if (i < N) assert(res == Integer.toString(i)) else assert(res == null)
////    }
//
////    val array = arrayListOf(41, 22, 58, 15, 33, 13, 37, 58, 50, 42, 43)
//    val array = arrayListOf(41, 22, 58, 15, 33, 13, 37, 58, 50)
////    val array = arrayListOf(41, 22, 58)
//    array.forEach {
//        bst.insert(it, it.toString())
//    }
//    TreeOperationUtils.show(bst.root)
//
//    println()
//    println()
//    println()
//    bst.levelOrder()
//}