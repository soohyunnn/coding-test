package com.test.coding.dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point1 {
    public int x, y;
    Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Test11 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;

    public void BFS(int x, int y) {
        Queue<Point1> Q = new LinkedList<>();
        Q.offer(new Point1(x, y));  //좌표(객체)를 Queue에 넣기
        board[x][y] = 1;
        while (!Q.isEmpty()) {  //Q가 비면 멈추기
            Point1 tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {  //통로확인
                    board[nx][ny] = 1;
                    Q.offer(new Point1(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;  //tmp가 현재 지점
                }
            }
        }
    }

    public static void main(String[] args) {
        Test11 T = new Test11();
        Scanner kb = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        T.BFS(1, 1);  //(1,1)이 출발점이라 출발점을 넘겨줌
        if(dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }

}
