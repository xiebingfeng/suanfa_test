package com.weightGraph


class SparseWeightedGraph<Weight>(val n: Int, val directed: Boolean) : WeightedGraph<Weight> where Weight : Number, Weight : Comparable<*> {

    private var m = 0

    private val g = Array(n) { ArrayList<Edge<Weight>>() }

    override fun V(): Int {
        return n
    }

    override fun E(): Int {
        return m
    }

    override fun addEdge(e: Edge<Weight>) {
        g[e.v()].add(e)

        if (!directed && e.v() != e.w()) {
            g[e.w()].add(Edge(e.v(), e.w(), e.wt()))
        }

        m++
    }

    override fun hasEdge(v: Int, w: Int): Boolean {
        for (i in g[v]) {
            if (i.other(v) == w) {
                return true
            }
        }
        return false
    }

    override fun show() {
        for (i in 0 until n) {
            print("vertex $i:\t")
            for (j in 0 until g[i].size) {
                val e: Edge<*> = g[i].elementAt(j)
                print("( to:" + e.other(i) + ",wt:" + e.wt() + ")\t")
            }
            println()
        }
    }

    override fun adj(v: Int): Iterable<Edge<Weight>> {
        return g[v]
    }
}