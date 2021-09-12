package com.test.coding.TwoPointersAndSlidingWindow;


import java.util.Scanner;

/**
 * 5-1. 연속된 자연수의 합(two pointers)
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
 * => 2pointer 알고리즘
 *
 */
public class Test5 {

    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n/2 +1; //연속된 자연수가 몇까지 있어야 하는지 담는 변수
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = i + 1;  //m에 1~n까지 숫자가 들어가있음

        for(int rt = 0; rt < m ; rt++) {
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n) {
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test5 T = new Test5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(T.solution(n));
    }
}



















//public class Test5 {
//
//    public int solution(int n) {
//        int answer = 0;
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Test5 T = new Test5();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        System.out.print(T.solution(n));
//    }
//}