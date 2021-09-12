package com.test.coding.stackAndQueue;


import java.util.Scanner;
import java.util.Stack;

/**
 * 1. 올바른 괄호
 * 괄호가 입력되면 올바른 괄호이면 "YES", 올바르지 않으면 "NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 * 설명
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 *
 * 출력
 * 첫 번째 줄에 YES, NO를 출력한다.
 *
 * 테스트 1
 * (()(())))(()
 *
 * 결과 1
 * NO
 *
 *
 *
 *
 *
 * TIP!
 * 여는 괄호를 입력받으면 스택에 넣기(push)
 * 닫는 괄호를 입력받으면 닫는괄호의 짝인 여는 괄호를 제거(pop)
 * isEmpty() : 비어있는지 확인하는 메소드
 * YSE이려면 다 끝나면 stack이 비어있어야 한다!
 *
 */
public class Test1 {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if(x == '(') stack.push('(');
            else {
                //닫는 괄호가 많은 경우
                if(stack.isEmpty()) return "NO";
                stack.pop(); //제일 상단에 있는 값 하나 제거
            }
        }
        //여는 괄호가 많은 경우
        if(!stack.isEmpty()) return "No";

        return answer;
    }

    public static void main(String[] args) {
        Test1 T = new Test1();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}














//public class Test1 {
//    public String solution(String str) {
//        String answer = "YES";
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Test1 T = new Test1();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
//        System.out.println(T.solution(str));
//    }
//}