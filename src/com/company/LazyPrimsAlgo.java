package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimsAlgo {

    private final boolean [] marked;
    private final Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimsAlgo(WeightedGraphAdjList graph) {
        pq = new PriorityQueue<>();
        mst = new LinkedList<>();
        marked = new boolean[graph.V()];
        visit(graph, 0);

        while (!pq.isEmpty() && mst.size() < graph.V()-1){
            Edge edge = pq.poll();
            int v = edge.source;
            int w = edge.destination;

            if (marked[v] && marked[w]){
                continue;
            }

            mst.add(edge);

            if (!marked[v]){
                visit(graph, v);
            }

            if ((!marked[w])){
                visit(graph, w);
            }
        }
    }


    private void visit(WeightedGraphAdjList graph, int vertices){
        marked[vertices] = true;
        for (Edge edge : graph.getAdjEdge(vertices)){
            if (!marked[edge.destination]){
                pq.add(edge);
            }
        }
    }


    public Iterable<Edge> getMST(){
        return mst;
    }


}
