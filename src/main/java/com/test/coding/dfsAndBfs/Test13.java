package com.test.coding.dfsAndBfs;

import java.util.Scanner;

public class Test13 {
    static int answer = 0, n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void DFS(int x, int y, int[][] board) {
        //8방향만 뻗어나가서 탐색하면 된다.
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {   //가능한 경우(뻗어나갈 수 있는 조건)
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {  //섬을 만난경우
                    answer++;
                    board[i][j] = 0;  //첫번째 지점도 0으로 체크(DFS에서는 다음 지점부터 0으로 체크하기 때문에 여기서 호출해주기 전에 해주기)
                    DFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Test13 T = new Test13();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();  //격자의 크기
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}
