package com.graph

import com.sun.org.apache.xml.internal.utils.IntStack
import kotlin.collections.ArrayList

/**
 * 深度优先遍历
 */
class Path(val G: Graph, val s: Int) {

    private val visited: BooleanArray = BooleanArray(G.V()) // 记录dfs的过程中节点是否被访问

    private val from: IntArray = IntArray(G.V()) // 记录路径, from[i]表示查找的路径上i的上一个节点

    init {
        for (i in 0 until G.V()) {
            visited[i] = false
            from[i] = -1
        }
        // 寻路算法
        dfs(s)
    }

    private fun dfs(v: Int) {
        visited[v] = true
        for (i in G.adj(v)) {
            if (!visited[i]) {
                from[i] = v
                dfs(i)
            }
        }
    }

    // 查询从s点到w点是否有路径
    private fun hasPath(w: Int) = visited[w]

    private fun path(w: Int): ArrayList<Int> {
        val stack = IntStack()

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        var p = w
        while (p != -1) {
            stack.push(p)
            p = from[p]
        }

        val list = ArrayList<Int>()
        while (!stack.empty())
            list.add(stack.pop())

        return list
    }

    fun showPath(w: Int) {
        if (!hasPath(w)) {
            return
        }

        val list = path(w)
        for (i in 0 until list.size) {
            print(list.elementAt(i))
            if (i == list.size - 1) println() else print(" -> ")
        }
    }
}