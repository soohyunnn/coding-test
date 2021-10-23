package com.test.coding.recursiveAndTreeAndGraph;

import java.util.ArrayList;
import java.util.Scanner;

public class Test13 {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void DFS(int v) {
        if(v == n) answer++;
        else {
            for (int nv : graph.get(v)) {  //graph.get(v)는 v번 ArrayList를 의미(1번 ArrayList 와 같은 이런거...)
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test13 T = new Test13();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());   //정수를 저장할 수 있는 ArrayList 객체 생성!!(중요!!)
        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);  //"1 2 ⇒ 1번 ArrayList에 2를 추가" 를 구현한 것
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);

    }
}
