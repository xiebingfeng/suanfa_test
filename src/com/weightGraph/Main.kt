package com.weightGraph

import kotlin.jvm.JvmStatic

object Main {
    // 测试通过文件读取图的信息
    @JvmStatic
    fun main(args: Array<String>) {

        // 使用两种图的存储方式读取testG1.txt文件
        val filename = "testWeightG1.txt"
        val g1 = SparseWeightedGraph<Double>(8, false)
        ReadWeightedGraph(g1, filename)
        println("test G1 in Sparse Weighted Graph:")
        g1.show()
        println()
        val g2 = DenseWeightedGraph<Double>(8, false)
        val readGraph2 = ReadWeightedGraph(g2, filename)
        println("test G1 in Dense Graph:")
        g2.show()
        println()

        val test = LazyPrimMST(g2)
        println(test.mstEdges().toString())
        println(test.result())
    }
}