package com.test.coding.HashMapAndTreeSet;


import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 5. K번째 큰 수(영상 후반 TreeSet 추가 설명)
 * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다.
 * 3장을 뽑을 수 있는 모든 경우를 기록합니다. 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
 * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19....이고 K값이 3이라면 K번째 큰 값은 22입니다.
 *
 * 설명
 * 첫 줄에 자연수 N(c<=M<=100)과 K(1<=ㅏ<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
 *
 * 출력
 * 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
 *
 * 테스트
 * 10 3
 * 13 15 34 23 45 65 33 11 26 42
 *
 * 결과
 * 143
 *
 *
 * [TreeSet]
 * Red-Black Tree
 * 중복을 제거하면서 정렬까지 되는 것
 * add() : 추가
 *
 *
 *
 */
public class Test5 {
    public int solution(int[] arr, int n, int k) {
        int anwser = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        //n까지 반복문을 줘도 어짜피 안들어가기때문에 n-1, n-2로 안해도 상관없다.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;

//        Tset.remove(143);  //값 지우기
//        Tset.size();  //값 갯수
//        Tset.first();   //Tset이 오름차순이면 최솟값 반환, 내림차순이면 최댓값 반환(제일 첫번째 원소 return)
//        Tset.last();  //Tset이 오름차순이면 최댓값 반환, 내림차순이면 최솟값 반환(제일 뒤에있는 원소 return)


        for(int x : Tset) {


            cnt++;
            if (cnt == k) return x;
//            System.out.println(cnt + "-" + x);
        }

        return anwser;
    }

    public static void main(String[] args) {
        Test5 T = new Test5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(arr, n, k));
    }
}















//public class Test5 {
//    public int solution(int[] arr, int n, int k) {
//        int anwser;
//        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
//
//        return anwser;
//    }
//
//    public static void main(String[] args) {
//        Test5 T = new Test5();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int k = kb.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i<n; i++) {
//            arr[i] = kb.nextInt();
//        }
//        System.out.println(T.solution(arr, n, k));
//    }
//}