package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            String[] mn = line.split(" ");
            int n = Integer.parseInt(mn[0]);
            int m = Integer.parseInt(mn[1]);
            WeightedGraph graph = new WeightedGraph(n);
            WeightedGraphAdjList graphWithAdjList = new WeightedGraphAdjList(n);
            for (int i=0; i<m;i++){
                line = reader.readLine();
                String[] inputs = line.split(" ");
                int u = Integer.parseInt(inputs[0]);
                int v = Integer.parseInt(inputs[1]);
                double w = Double.parseDouble(inputs[2]);
                graph.addEdge(u,v,w);
                graphWithAdjList.addEdge(u,v,w);
            }

            LazyPrimsAlgo primsAlgo = new LazyPrimsAlgo(graphWithAdjList);
            ArrayList<Edge> kruskal = graph.findMSTKruskal();
            Iterable<Edge> prims = primsAlgo.getMST();

            double cost = 0;
            for (Edge edge : kruskal){
                cost += edge.weight;
            }

            System.out.println("Cost of the minimum spanning tree: " + cost);
            System.out.print("List of edges by kruskal's algo: {");
            for (Edge edge: kruskal){
                System.out.print("(" + edge.source + "," + edge.destination + ")");
            }
            System.out.println("}");

            System.out.print("List of edges by Prim's algo: {");
            for (Edge edge: prims){
                System.out.print("(" + edge.source + "," + edge.destination + ")");
            }
            System.out.print("}");

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
