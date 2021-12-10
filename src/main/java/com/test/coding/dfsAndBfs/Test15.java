package com.test.coding.dfsAndBfs;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
    public int x, y;  //행 x, 열 y
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Test15 {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;  //피자집 조합을 저장
    static ArrayList<Point> pz, hs;

    public void DFS(int L, int s) {
        if (L == m) {
            //조합 출력해보기
//            for (int x : combi) {
//                System.out.print(x + " ");
//                System.out.println();
//            }
            int sum = 0;
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;  //최소값 구해야하니까 MAX값으로 초기화
                for (int i : combi) {  //조합의 인덱스 번호 for문
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));  //i가 0번이면 0번에 있는 피자집, i가 2번이면 2번에 있는 피자집
                }
                sum += dis;  //피자배달거리 누적(sum이 도시의 피자배달거리)
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Test15 T = new Test15();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if(tmp == 1) hs.add(new Point(i, j));
                else if(tmp == 2) pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }

}
