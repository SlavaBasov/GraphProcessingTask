package com.company;

import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayHandler {
    private int dist[][];
    private Queue<Node> pq;
    private int V;
    private int[][] array;
    private int longestWays[][];
    private Node longestPath;

    public ArrayHandler(int[][] array) {
        this.V = array.length;
        dist = new int[V][V];
        pq = new PriorityQueue<>(V * V, new Node());
        longestWays=new int[V][V];
        longestPath = new Node(0,0,0);
    }

    public void dijkstra(int[][] array, int iSrc, int jSrc) {
        this.array = array;

        pq.add(new Node(iSrc, jSrc, array[iSrc][jSrc]));

        dist[iSrc][jSrc] = array[iSrc][jSrc];
        while (true) {
            if (pq.isEmpty()) {
                if(longestWays[iSrc][jSrc]>longestPath.getCost())
                    longestPath.setI(iSrc);
                longestPath.setJ(jSrc);
                longestPath.setCost(longestWays[iSrc][jSrc]);
                return;
            }
            int i = pq.element().getI();
            int j = pq.element().getJ();
            pq.remove();

            if(j!=0)
                processNeighbours(i, j);

            if(j==0 && dist[i][j]>longestWays[iSrc][jSrc])
                longestWays[iSrc][jSrc]=dist[i][j];
        }

    }

    private void processNeighbours(int i, int j) {

        pq.add(new Node(i, j-1, array[i][j-1]));
        if(dist[i][j-1] < (dist[i][j]+array[i][j-1])){
            dist[i][j-1]=dist[i][j]+array[i][j-1];
        }

        if(i!=dist.length - 1){
            pq.add(new Node(i+1, j-1, array[i+1][j-1]));
            if(dist[i+1][j-1]< (dist[i][j]+array[i+1][j-1])) {
                dist[i+1][j-1]=dist[i][j]+array[i+1][j-1];
            }
        }

        if(i!=0) {
            pq.add(new Node(i - 1, j - 1, array[i - 1][j - 1]));
            if(dist[i-1][j-1]< (dist[i][j]+array[i-1][j-1])) {
                dist[i-1][j-1]=dist[i][j]+array[i-1][j-1];
            }
        }
    }

    public void start(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                dist=new int[V][V];
                dijkstra(array, i, j);
            }
        }
        printResults();
    }

    private void printResults(){
        System.out.println("All longest paths tree from initialVertex:");
        for (int i = 0; i < longestWays.length; i++){
            for (int j = 0; j < longestWays.length; j++){
                System.out.println(String.format("initialVertex -> [%d][%d] = %d",i,j,longestWays[i][j]));
            }
        }
        System.out.println(String.format("longest path tree from vertex 'initialVertex' = %d",longestPath.getCost()));
    }
}
