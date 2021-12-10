package com.test.coding.dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point2 {
    public int x, y;
    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Test12 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static int n, m;
    static Queue<Point2> Q = new LinkedList<>();
    public void BFS() {
        while (!Q.isEmpty()) {
            Point2 tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point2(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test12 T = new Test12();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();  //열
        n = kb.nextInt();  //행
        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = kb.nextInt();
                if(board[i][j] ==1) Q.offer(new Point2(i, j));  //Q에 출발점 넣기
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 0) flag = false;
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);
    }
}
