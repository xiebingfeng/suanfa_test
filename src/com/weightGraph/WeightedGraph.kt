package com.weightGraph

interface WeightedGraph<Weight> where Weight : Number, Weight : Comparable<*> {

    fun V(): Int

    fun E(): Int

    fun addEdge(e: Edge<Weight>)

    fun hasEdge(v: Int, w: Int): Boolean

    fun show()

    fun adj(v: Int): Iterable<Edge<Weight>>

}