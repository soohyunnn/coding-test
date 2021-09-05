package com.test.coding.array;


import java.util.Scanner;

/**
 * 9. 격자판 최대합
 * 5 * 5 격자판에 아래와 같이 숫자가 적혀있습니다.
 * 10 13 10 12 15
 * 12 30 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 * N * N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력합니다.
 *
 * 설명
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 최대합을 출력합니다.
 *
 * 테스트
 * 5
 * 10 13 10 12 15
 * 12 30 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 *
 * 결과
 * 155
 *
 *
 *
 *
 *
 */
public class Array9 {

    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;   //가장 큰값을 저장할 것이니 가장 작은 정수값으로 초기화(최대값을 찾을 때 초기셋팅)
        int sum1 ,sum2;  //sum1은 행의 합, sum2는 열의 합
        //각행과 열의 합 구하기
        for(int i = 0; i<n; i++) {
            sum1 = sum2 = 0;
            for(int j = 0; j <n ; j++) {
                sum1 += arr[i][j]; //[0][0], [0][1], [0][2], [0][3], [0][4]  =>행
                sum2 += arr[j][i]; //[0][0], [1][0], [2][0], [3][0], [4][0]  =>열
            }
            //sum1이나 sum2 둘 중 큰 값이 answer로 들어감
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        //두 대각선의 합 구하기
        sum1 = sum2 = 0;
        for(int i=0; i< n; i++) {
            sum1 += arr[i][i]; //[0][0], [1][1], [2][2], [3][3], [4][4]
            sum2 += arr[i][n-i-1];  //[0][4], [1][3], [2][2], [3][1], [4][0]
        }

        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) {
        Array9 T = new Array9();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }

}













//
//public class Array9 {
//
//    public int solution(int n, int[][] arr) {
//        int answer = Integer.MIN_VALUE;
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Array9 T = new Array9();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int[][] arr = new int[n][n];
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++) {
//                arr[i][j] = kb.nextInt();
//            }
//        }
//        System.out.println(T.solution(n, arr));
//    }
//
//}