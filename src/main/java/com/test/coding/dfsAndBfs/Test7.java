package com.test.coding.dfsAndBfs;

import java.util.Scanner;

public class Test7 {
    int[][] dy = new int[35][35];  //n이 33까지 들어오니까 넉넉하게 35로 설정(메모리제이션 배열)
    public int DFS(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];  //메모리제이션에 이미 저장되어 있으면 바로 찾아서 return
        if(n ==r || r == 0) return 1;
        else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);  //dy에 기록하고 해당 값을 return 해준다.
    }

    public static void main(String[] args) {
        Test7 T = new Test7();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.println(T.DFS(n, r));
    }
}
