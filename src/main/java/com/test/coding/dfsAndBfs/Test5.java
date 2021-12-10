package com.test.coding.dfsAndBfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test5 {
    static int n,m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr) {
        if(sum > m) return;
        if(L >= answer) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Test5 T = new Test5();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());  //큰 수부터 트리를 내려가면 시간이 오히려 단축된다.
        m = kb.nextInt();  //거슬러 줄 금액
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
