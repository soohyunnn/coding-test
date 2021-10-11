package com.test.coding.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test6 {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) Q.offer(i);
        while (!Q.isEmpty()) {
            for (int i = 1; i < k; i++) Q.offer(Q.poll());  //꺼내서 리턴받은 값을 넣는다.
            Q.poll();
            if(Q.size()==1) answer = Q.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Test6 T = new Test6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(T.solution(n, k));
    }
}
