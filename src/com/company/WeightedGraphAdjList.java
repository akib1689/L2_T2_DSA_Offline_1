package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraphAdjList {
    static class ResultSet {
        int parent;
        int weight;
    }


    private final int vertices;
    private ArrayList<Edge>[] adj;

    public WeightedGraphAdjList(int v) {
        vertices = v;
        adj = new ArrayList[v];

        for (int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination, int weight){
        Edge edge = new Edge(source,destination,weight);
        adj[source].add(edge);

        edge = new Edge(destination,source,weight);
        adj[destination].add(edge);
    }


    public void primMST(){

        boolean[] mst = new boolean[vertices];
        ResultSet[] resultSet = new ResultSet[vertices];
        int [] key = new int[vertices]; //keys used to store the key to know whether priority queue update is required

        //Initialize all the keys to infinity and
        //initialize resultSet for all the vertices
        for (int i = 0; i <vertices ; i++) {
            key[i] = Integer.MAX_VALUE;
            resultSet[i] = new ResultSet();
        }

        //Initialize priority queue
        //override the comparator to do the sorting based keys
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                //sort using key values
                int key1 = p1.getKey();
                int key2 = p2.getKey();
                return key1–key2;
            }
        });

        //create the pair for for the first index, 0 key 0 index
        key[0] = 0;
        Pair<Integer, Integer> p0 = new Pair<>(key[0],0);
        //add it to pq
        pq.offer(p0);

        resultSet[0] = new ResultSet();
        resultSet[0].parent = –1;

        //while priority queue is not empty
        while(!pq.isEmpty()){
            //extract the min
            Pair<Integer, Integer> extractedPair = pq.poll();

            //extracted vertex
            int extractedVertex = extractedPair.getValue();
            mst[extractedVertex] = true;

            //iterate through all the adjacent vertices and update the keys
            LinkedList<Edge> list = adjacencylist[extractedVertex];
            for (int i = 0; i <list.size() ; i++) {
                Edge edge = list.get(i);
                //only if edge destination is not present in mst
                if(mst[edge.destination]==false) {
                    int destination = edge.destination;
                    int newKey = edge.weight;
                    //check if updated key < existing key, if yes, update if
                    if(key[destination]>newKey) {
                        //add it to the priority queue
                        Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                        pq.offer(p);
                        //update the resultSet for destination vertex
                        resultSet[destination].parent = extractedVertex;
                        resultSet[destination].weight = newKey;
                        //update the key[]
                        key[destination] = newKey;
                    }
                }
            }
        }
    }
}
