package com.company;

import java.util.Comparator;

public class Node implements Comparator<Node> {

    private int i;
    private int j;
    private int cost;

    public Node() {
    }

    public Node(int i, int j, int cost) {
        this.i = i;
        this.j = j;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost > node2.cost)
            return -1;
        if (node1.cost < node2.cost)
            return 1;
        return 0;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
