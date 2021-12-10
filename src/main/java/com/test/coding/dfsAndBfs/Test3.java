package com.test.coding.dfsAndBfs;

import java.util.Scanner;

public class Test3 {
    static int answer = Integer.MIN_VALUE, n, m;
    boolean flag = false;

    public void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if(time > m) return;
        if (L == n) {
            answer = Math.max(answer, sum);  //기존 answer보다 sum이 크면 answer을 sumd으로 갱신
        } else {
            DFS(L + 1, sum + ps[L], time + pt[L], ps, pt);
            DFS(L + 1, sum, time, ps, pt);
        }
    }

    public static void main(String[] args) {
        Test3 T = new Test3();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        int[] a = new int[n];  //점수
        int[] b = new int[n];  //제한시간
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
            b[i] = kb.nextInt();
        }
        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }
}
