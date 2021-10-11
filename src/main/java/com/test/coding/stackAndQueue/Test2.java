package com.test.coding.stackAndQueue;


import java.util.Scanner;
import java.util.Stack;

/**
 * 2. 괄호문자제거
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 * 입력설명
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력설명
 * 남은 문자만 출력한다.
 *
 * 테스트
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 *
 * 결과
 * EFLM
 *
 *
 * TIP!
 * 닫는 괄호를 입력받으면 그의 짝인 여는 괄호까지를 pop한다.
 * stack.get(i)  : i번째 index 값을 가져온다.
 * stack.size() : stack의 크기를 가져온다.
 *
 *
 */
public class Test2 {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(') ;  //(가 아니면 계속 돌기
            } else stack.push(x);
        }
        for (int i = 0; i < stack.size(); i++) answer += stack.get(i);
        return answer;
    }

    public static void main(String[] args) {
        Test2 T = new Test2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}













//public class Test2 {
//    public String solution(String str) {
//        String answer = "";
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Test2 T = new Test2();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
//        System.out.println(T.solution(str));
//    }
//}