package com.weightGraph

import java.util.Vector

// 稠密图 - 邻接矩阵
class DenseWeightedGraph<Weight>(val n: Int, private val directed: Boolean) : WeightedGraph<Weight> where Weight : Number, Weight : Comparable<*> {

    private var m = 0// 边数

    private val g: Array<Array<Edge<Weight>?>> = Array(n) {
        arrayOfNulls<Edge<Weight>>(n)
    }// 图的具体数据

    override fun V(): Int {
        return n
    } // 返回节点个数

    override fun E(): Int {
        return m
    } // 返回边的个数

    // 向图中添加一个边
    override fun addEdge(e: Edge<Weight>) {
        if (hasEdge(e.v(), e.w()))
            return
        g[e.v()][e.w()] = Edge(e)
        if (e.v() != e.w() && !directed)
            g[e.w()][e.v()] = Edge(e.w(), e.v(), e.wt())
        m++
    }

    // 验证图中是否有从v到w的边
    override fun hasEdge(v: Int, w: Int): Boolean {
        return g[v][w] != null
    }

    // 显示图的信息
    override fun show() {
        for (i in 0 until n) {
            for (j in 0 until n) if (g[i][j] != null) print(g[i][j]!!.wt().toString() + "\t") else print("NULL\t")
            println()
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    override fun adj(v: Int): Iterable<Edge<Weight>> {
        val adjV = Vector<Edge<Weight>>()
        for (i in 0 until n)
            if (g[v][i] != null)
                adjV.add(g[v][i])
        return adjV
    }

}