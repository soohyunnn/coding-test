package com.test.coding.dfsAndBfs;

import java.util.Scanner;

public class Test8 {
    static int[] b, p, ch;
    static int n, f;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if(dy[n][r] >0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public void DFS(int L, int sum) {
        if(flag) return;
        if (L == n) {
            if (sum == f) {
                for(int x : p) System.out.print(x + " ");
                flag = true;  //답이 나오면 그 다음껀 바로바로 종료되게금 하는것(true로 주기)
            }
        } else {
            for (int i = 1; i <= n; i++) {  //ch배열에서 index가 아닌 해당 숫자로 체크하는것이다. (i=1부터 시작하는 이유)
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test8 T = new Test8();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1]; //숫자를 1부터 사용해야 하기 때문에 n+1 크기로 설정해줘야 함.
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        T.DFS(0, 0);
    }
}
