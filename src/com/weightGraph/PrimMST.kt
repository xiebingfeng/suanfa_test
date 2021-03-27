package com.weightGraph

class PrimMST<Weight>(val G: WeightedGraph<Weight>) where Weight : Number, Weight : Comparable<*> {

    private val ipq = IndexMinHeap<Weight>(G.V())

    private val marked = Array(G.V()) {
        false
    }

    private val edgeTo = Array<Edge<Weight>?>(G.V()) {
        null
    }

    private val mst = ArrayList<Edge<Weight>>()

    private var mstWeight: Number? = null

    init {
        visit(0)
        while (!ipq.isEmpty) {
            val v = ipq.extractMinIndex()
            mst.add(edgeTo[v]!!)
            visit(v)
        }

        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt()
        for (i in 1 until mst.size) mstWeight = mstWeight!!.toDouble() + mst.elementAt(i).wt().toDouble()
    }

    private fun visit(v: Int) {
        marked[v] = true

        // 将和节点v相连接的未访问的另一端点, 和与之相连接的边, 放入最小堆中
        for (item in G.adj(v)) {
            val w = item.other(v)
            if (!marked[w]) {
                if (edgeTo[w] == null) {
                    edgeTo[w] = item
                    ipq.insert(w, item.wt())
                } else if (edgeTo[w]!!.wt().toDouble() > item.wt().toDouble()) {
                    edgeTo[w] = item
                    ipq.change(w, item.wt())
                }
            }
        }
    }


    // 返回最小生成树的所有边
    fun mstEdges(): ArrayList<Edge<Weight>> {
        return mst
    }

    // 返回最小生成树的权值
    fun result(): Number? {
        return mstWeight
    }
}

fun main(args: Array<String>) {
    val filename = "testPrimG1.txt"
    val V = 8

    val g = SparseWeightedGraph<Double>(V, false)
    val readGraph = ReadWeightedGraph(g, filename)

    // Test Prim MST

    // Test Prim MST
    println("Test Prim MST:")
    val primMST = PrimMST(g)
    val mst: ArrayList<Edge<Double>> = primMST.mstEdges()
    for (i in mst.indices) println(mst.elementAt(i))
    println("The MST weight is: " + primMST.result())

    println()
}