package com.test.coding.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge1 implements Comparable<Edge1>{
    public int vex;  //정점
    public int cost;  //비용

    Edge1(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge1 ob) {
        return this.cost - ob.cost;
    }
}

public class Test5 {
    static int n, m;
    static ArrayList<ArrayList<Edge1>> graph;
    static int[] dis;

    public void solution(int v) {
        PriorityQueue<Edge1> pQ = new PriorityQueue<>();
        pQ.offer(new Edge1(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge1 tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now] ) continue;
            for (Edge1 ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge1(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Test5 T = new Test5();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Edge1>>();  //Edge라는 객체를 저장할 수 있는 ArrayList이다.
        for (int i = 0; i <= n; i++) {   //0번부터 n개의 객체를 만들어낸다.
            graph.add(new ArrayList<Edge1>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge1(b, c));
        }
        T.solution(1);
        for (int i = 2; i <= n; i++) {
            if(dis[i]!= Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
