package com.test.coding.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test7 {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char x : need.toCharArray()) Q.offer(x);  //Q에 필수과목 셋팅
        for (char x : plan.toCharArray()) {
            if (Q.contains(x)) {
                if (x != Q.poll()) return "NO";
            }
        }
        //필수과목 이수 안할경우
        if(!Q.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        Test7 T = new Test7();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(T.solution(a, b));
    }
}
