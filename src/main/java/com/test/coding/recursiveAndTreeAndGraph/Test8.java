package com.test.coding.recursiveAndTreeAndGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test8 {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();   //레벨에 있는 갯수
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
//                if(x == e) return L;  이 위치보다 아래에 놓는것이 더 좋아서 이동(e가 송아지 위치)
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];  //5 + 1 ,5 - 1, 5 + 5로 돌아가면서 +함
                    if(nx == e) return L + 1;  //자식을 찾을 때 확인하는 것이 더 좋음
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;  //방문했다고 체크(0이면 방문 안한것)
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }


    public static void main(String[] args) {
        Test8 T = new Test8();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
