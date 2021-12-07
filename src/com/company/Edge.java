package com.company;

public class Edge implements Comparable<Edge>{
    int source,destination;
    double weight;

    public Edge(int src, int des, double weight) {
        source = src;
        destination = des;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge that) {
        return Double.compare(weight, that.weight);
    }
}
