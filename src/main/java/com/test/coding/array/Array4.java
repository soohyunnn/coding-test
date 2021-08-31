package com.test.coding.array;


import java.util.Scanner;

/**
 * 4. 피보나치 수열
 * 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 * 설명
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 *
 * 출력
 * 첫 줄에 피보나치 수열을 출력합니다.
 *
 * 테스트
 * 10
 *
 * 결과
 * 1 1 2 3 5 8 13 21 34 55
 *
 *
 */

/**
 * 1번 방법
 */
public class Array4 {
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<n ; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Array4 T = new Array4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int x : T.solution(n)) System.out.print(x + " ");
    }

}

/**
 * 2번 방법(손코딩일경우, 배열을 사용하면 안되는 조건 추가)
 */
//public class Array4 {
//    public void solution(int n) {
//        int a = 1, b = 1, c;
//        System.out.println(a + " " + b + " ");
//        for(int i=2; i<n; i++) {
//            c = a + b;
//            System.out.println(c + " ");
//            a = b;
//            b = c;
//        }
//    }
//
//    public static void main(String[] args) {
//        Array4 T = new Array4();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        T.solution(n)
//    }
//
//}

//public class Array4 {
//    public int[] solution(int n) {
//        int[] answer = new int[n];
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Array4 T = new Array4();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        for(int x : T.solution(n)) System.out.print(x + " ");
//    }
//
//}