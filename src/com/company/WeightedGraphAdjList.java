package com.company;

import java.util.ArrayList;

public class WeightedGraphAdjList {
    private final int vertices;
    private ArrayList<Edge>[] adj;


    public WeightedGraphAdjList(int v){
        vertices = v;
        adj = new ArrayList[v];
        for (int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }



    public void addEdge(int source, int destination, double weight){
        Edge edge = new Edge(source,destination,weight);
        adj[source].add(edge);

        edge = new Edge(destination,source,weight);
        adj[destination].add(edge);
    }

    public int V() {
        return vertices;
    }

    public ArrayList<Edge> getAdjEdge(int vertices){
        return adj[vertices];
    }
}
