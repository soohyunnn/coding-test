package com.test.coding.dfsAndBfs;

import java.util.Scanner;

public class Test10 {
    static int[] dx = {-1, 0, 1, 0};  //12시 3시 6시 9시
    static int[] dy = {0, 1, 0, -1};  //12시 3시 6시 9시
    static int[][] board;
    static int answer = 0;

    public void DFS(int x, int y) {
        if(x == 7 && y == 7) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                //다음지점으로 접근(12시, 3시, 6시, 9시)
                int nx = x + dx[i];
                int ny = y + dy[i];
                //경계선 밖인지 확인
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) { //경계선 안쪽 체크(갈 수 있는 지점 체크)
                    board[nx][ny] = 1;  //체크
                    DFS(nx, ny);
                    board[nx][ny] = 0;  //체크해제
                }
            }
        }
    }

    public static void main(String[] args) {
        Test10 T = new Test10();
        Scanner kb = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        board[1][1] = 1;  //출발점 체크 걸기
        T.DFS(1, 1);
        System.out.print(answer);
    }

}
