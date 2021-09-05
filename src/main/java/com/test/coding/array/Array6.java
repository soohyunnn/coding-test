package com.test.coding.array;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 6. 뒤집은 소수
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다.
 * 단 910를 뒤집으면 19로 숫자화 해야 한다. 첫 자리부터의 연속된 0은 무시한다.
 *
 * 설명
 * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
 * 각 자연수의 크기는 100,000를 넘지 않는다.
 *
 * 출력
 * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 *
 * 테스트
 * 9
 * 32 55 62 20 250 370 200 30 100
 *
 * 결과
 * 23 2 73 2 3
 *
 * 해석
 * tmp = 1230 일 경우
 *
 * res = 0 => res는 처음에 0
 * res = res * 10 + t => 뒤집어지는 숫자   ---2.
 * 0   = 0   * 10 + 0
 * 3   = 0   * 10 + 3
 * 32  = 3   * 10 + 2
 * 321 = 32  * 10 + 1
 *
 * while문
 * t = tmp % 10 => 1230 % 10 = 0   ---1.
 * tmp = tmp/10 => 1230/10 = 123   ---3.
 * t = tmp % 10 => 123 % 10 = 3
 * tmp = tmp/10 => 123/10 = 12
 * t = tmp % 10 => 12 % 10 = 2
 * tmp = tmp/10 => 12/10 = 1
 * t = tmp % 10 => 1 % 10 = 0   -> tmp > 0 까지만 반복되도록 0보다 작거나 같으면 STOP
 *
 *
 *
 */
public class Array6 {
    //소수인지 확인하는 메소드
    public boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i = 2; i < num; i++){
            if(num %i == 0) return false;     //약수가 발견되면 false
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i <n; i++) {
            int tmp = arr[i];
            int res = 0;
            while(tmp >0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if(isPrime(res)) answer.add(res);
        }

        return answer;
    }

    public static void main(String[] args) {
        Array6 T = new Array6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int x : T.solution(n,arr)){
            System.out.println(x + " ");
        }
    }

}






//public class Array6 {
//
//    public boolean isPrime(int num) {
//
//    }
//
//    public ArrayList<Integer> solution(int n, int[] arr) {
//        ArrayList<Integer> answer = new ArrayList<>();
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Array6 T = new Array6();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int[] arr = new int[n];
//        for(int i =0; i<n; i++) {
//            arr[i] = kb.nextInt();
//        }
//        for(int x : T.solution(n,arr)){
//            System.out.println(x + " ");
//        }
//    }
//
//}












