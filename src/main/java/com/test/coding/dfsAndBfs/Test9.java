package com.test.coding.dfsAndBfs;

import java.util.Scanner;

public class Test9 {
    static int[] combi;
    static int n, m;

    public void DFS(int L, int s) {
        if (L == m) {
            for (int x : combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {   //조합은 그냥 외우는 것이 좋다 for문 암기!!
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Test9 T = new Test9();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];
        T.DFS(0, 1);  //1이 스타트 번호
    }
}
