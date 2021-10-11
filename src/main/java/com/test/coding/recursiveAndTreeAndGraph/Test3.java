package com.test.coding.recursiveAndTreeAndGraph;

public class Test3 {
    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Test3 T = new Test3();
        System.out.println(T.DFS(5));
    }
}
