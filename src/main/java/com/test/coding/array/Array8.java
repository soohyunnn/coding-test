package com.test.coding.array;


import java.util.Scanner;

/**
 * 8. 등수구하기
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다. 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 *
 * 설명
 * 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
 *
 * 출력
 * 입력된 순서대로 등수를 출력한다.
 *
 * 테스트
 * 5
 * 87 89 92 100 76
 *
 * 결과
 * 4 3 2 1 5
 *
 * cnt = 1로 초기화 해놓고
 * arr[j] > arr[i] => i는 0번 인덱스 j는 0~4로 반복하여 비교
 * i = 0일 때 j = 0 ~ 4돌아 arr[j]가 더 크면 cnt +1
 * 다 돌고 i가 증가하면 cnt 1로 초기화
 *
 *
 *
 */
public class Array8 {

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];  //기본적으로 0으로 초기화
        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j= 0; j < n; j++) {
                if(arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;
        }

        return answer;
    }


    public static void main(String[] args) {
        Array8 T = new Array8();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int x : T.solution(n, arr)) System.out.print(x + " ");
    }

}























//public class Array8 {
//
//    public int[] solution(int n, int[] arr) {
//        int[] answer = new int[n];
//
//        return answer;
//    }
//
//
//    public static void main(String[] args) {
//        Array8 T = new Array8();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++) {
//            arr[i] = kb.nextInt();
//        }
//        for(int x : T.solution(n, arr)) System.out.println(x + " ");
//    }
//
//}