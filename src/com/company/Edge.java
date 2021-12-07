package com.company;

public class Edge implements Comparable<Edge>{
    int source,destination,weight;

    public Edge(int src, int des, int weight) {
        source = src;
        destination = des;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge that) {
        return Integer.compare(weight, that.weight);
    }
}
