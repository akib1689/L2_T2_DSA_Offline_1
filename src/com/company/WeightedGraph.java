package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class WeightedGraph {
    private int V;

    private ArrayList<Edge> edges;


    public WeightedGraph(int v) {
        V = v;
        edges = new ArrayList<>();
    }

    public void addEdge(int src,int des,int weight){
        if (src != des) {
            Edge edge = new Edge(src, des, weight);
            edges.add(edge);
        }
    }


    //find the parent of the node
    private int find(SubSets[] subs, int i){
        if (subs[i].parent != i){
            subs[i].parent = find(subs,subs[i].parent);
        }

        return subs[i].parent;
    }

    //make union of the two sets
    private void union(SubSets[] subs, int x, int y){
        int rtx = find(subs,x);
        int rty = find(subs,y);

        //make smaller tree as a child of the larger tree
        if (subs[rtx].rank < subs[rty].rank){
            subs[rtx].parent = rty;
        }else if (subs[rtx].rank > subs[rty].rank){
            subs[rty].parent = rtx;
        }else{
            subs[rtx].parent = rty;
            subs[rty].rank++;
        }
    }

    public ArrayList<Edge> findMSTKruskal(){
        ArrayList<Edge> result = new ArrayList<>();
        int e = 0;

        //takes ElogE
        Collections.sort(edges);

        SubSets[] subs = new SubSets[V];
        for (int i=0; i<V; i++){
            subs[i] = new SubSets();
            subs[i].parent = i;
            subs[i].rank = 0;
        }

        int i=0;
        while (e<V-1){
            Edge edge = edges.get(i);
            i++;
            int x = find(subs,edge.source);
            int y = find(subs, edge.destination);
            if (x != y){
                result.add(edge);
                e++;
                union(subs,x,y);
            }
        }
        return result;
    }


}
