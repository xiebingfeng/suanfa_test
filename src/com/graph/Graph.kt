package com.graph

// 图的接口
interface Graph {

    fun V(): Int

    fun E(): Int

    fun addEdge(v: Int, w: Int)

    fun hasEdge(v: Int, w: Int): Boolean

    fun show()

    fun adj(v: Int): Iterable<Int>
}