package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here


        WeightedGraph g = new WeightedGraph(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        ArrayList<Edge> edges = g.findMSTKruskal();
        int totalCost = 0;
        System.out.println("list of edges by kruskal's: {");
        for (Edge edge:edges){
            totalCost += edge.weight;
            System.out.println(edge.source + "--" + edge.destination +" cost: " + edge.weight);
        }
        System.out.println("Total cost of the tree: " + totalCost);
    }
}
