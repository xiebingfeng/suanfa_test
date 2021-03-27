package com.weightGraph


class LazyPrimMST<Weight>(val G: WeightedGraph<Weight>) where Weight : Number, Weight : Comparable<*> {

    private val pq: MinHeap<Edge<Weight>> = MinHeap(G.E())
    private val marked = BooleanArray(G.V())
    private val mst = ArrayList<Edge<Weight>>()
    private var mstWeight: Number? = null

    init {
        //Lazy Prim
        visit(0)
        while (!pq.isEmpty) {
            // 使用最小堆找出已经访问的边中权值最小的边
            val e = pq.extractMin()
            // 如果这条边的两端都已经访问过了, 则扔掉这条边
            if (marked[e.v()] && marked[e.w()]) {
                continue
            }
            // 否则, 这条边则应该存在在最小生成树中
            mst.add(e)

            // 访问和这条边连接的还没有被访问过的节点
            if (!marked[e.v()]) {
                visit(e.v())
            } else {
                visit(e.w())
            }

            mstWeight = mst.elementAt(0).wt()
        }

        for (i in 1 until mst.size)
            mstWeight = (mstWeight!!.toDouble()).plus(mst.elementAt(i).wt().toDouble())
    }

    // 访问节点v
    private fun visit(v: Int) {
        marked[v] = true

        // 将和节点v相连接的所有未访问的边放入最小堆中
        for (item in G.adj(v)) {
            if (!marked[item.other(v)]) {
                pq.insert(item)
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