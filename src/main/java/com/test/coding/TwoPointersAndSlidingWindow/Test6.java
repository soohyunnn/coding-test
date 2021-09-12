package com.test.coding.TwoPointersAndSlidingWindow;

import java.util.Scanner;

/**
 * 5-2. 연속된 자연수의 합(수학)
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 와 같이 총 3가지의 경우가 존재한다.
 *
 * 설명
 * 첫 번째 줄에 양의 정수 N(7<=N<=1000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 총 경우수를 출력합니다.
 *
 * 테스트
 * 15
 *
 * 결과
 *
 * 연속된 자연수는 15/2 = 7+1 = 8 값까지만 연속된 자연수가 있으면 된다. 15는 N값!
 *
 */
public class Test6 {

    public int solution(int n) {
        int answer = 0, cnt = 1;  //cnt는 연속된 자연수의 갯수
        n--;  //n을 1빼기
        while(n > 0) {
            cnt++;
            n = n - cnt;  //n에서 2빼기
            if(n%cnt == 0) {
                System.out.println(n + " " + cnt);
                answer++;  //나머지가 0이면 연속된 자연수가 가능한 것이다.
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Test6 T = new Test6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}


















//public class Test6 {
//
//    public int solution(int n) {
//        int answer = 0;
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Test6 T = new Test6();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        System.out.println(T.solution(n));
//    }
//}