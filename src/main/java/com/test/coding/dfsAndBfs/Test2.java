package com.test.coding.dfsAndBfs;

import java.util.Scanner;

public class Test2 {
    static int answer = Integer.MIN_VALUE, c, n;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr) {
        if(sum > c) return;
        if (L == n) {
            answer = Math.max(answer, sum);  //기존 answer랑 sum중에 큰 값을 answer로 갱신
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Test2 T = new Test2();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }

}
