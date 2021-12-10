package com.test.coding.dfsAndBfs;

import java.util.Scanner;

public class Test6 {
    static int[] pm, ch, arr;
    static int n, m;

    public void DFS(int L) {
        if (L == m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {  //체크배열에서 인덱스가 쓰이지 않았을 경우 tree가 가닥을 뻗어야 한다.
                    ch[i] = 1;  //i번째 인덱스를 사용한 후 1로 넣기(체크하기)
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;  //다시 거꾸로 올라갈 때 체크를 해지하기
                }
            }
        }
    }

    public static void main(String[] args) {
        Test6 T = new Test6();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        ch = new int[n];
        pm = new int[m];
        T.DFS(0);
    }

}
