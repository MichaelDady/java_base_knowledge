package com.makun.data_struct.graph.bread_first;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Created by makun
 * @Date 2019/8/19
 */
public class Graph {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int y = 0; y < maxVertices; y++) {
            for (int x = 0; x < maxVertices; x++) {
                adjMatrix[y][x] = 0;
            }
        }
        theQueue = new LinkedList();
    }

    public void addVertex(char lab) {
        vertexList[vertexCount++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void bfs() {

    }

}
