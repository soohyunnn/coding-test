package com.test.coding.recursiveAndTreeAndGraph;

public class Test2 {
    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n / 2);
            System.out.print(n % 2 + " ");
        }

    }

    public static void main(String[] args) {
        Test2 T = new Test2();
        T.DFS(11);
    }
}
