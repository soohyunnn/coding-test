package com.test.coding.TwoPointersAndSlidingWindow;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. 두 배열 합치기(two pointers algorithm)
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 설명
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 *
 * 테스트
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 *
 * 결과
 * 1 2 3 3 5 6 7 9
 *
 *
 *
 * 시간복잡도 o(nlogn)
 * => 효율적으로 짤 수 있는지를 확인하는 테스트이다. (2point로)
 * => 2pointers 알고리즘(이건 꼭 오름차순 정렬을 해야한다)
 *
 * p1 -> 1 3 5 인덱스를 돌기    n개 = 3
 * p2 -> 2 3 6 7 9 인덱스를 돌기   m개 = 5
 * a[p1] < b[p2]
 * 작은쪽이 p1이면 p1을 answer로 넣고 넣은 쪽 p1++, p2이면 p2를 answer로 넣고 넣은 쪽 p2++
 * p1 < n, p2 < m
 *
 */
public class Test1 {

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1<n && p2 <m) {
            if(a[p1] < b[p2]) answer.add(a[p1++]);  //p1이 가리키는 값을 add하고 그 다음에 1증가
            else answer.add(b[p2++]);
        }
        while(p1<n) answer.add(a[p1++]);
        while(p2<m) answer.add(b[p2++]);

        return answer;
    }

    public static void main(String[] args) {
        Test1 T = new Test1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++) {
            b[i] = kb.nextInt();
        }
        for (int x : T.solution(n, m, a, b)) System.out.print(x + " ");
    }

}

















//public class Test1 {
//
//    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
//        ArrayList<Integer> answer = new ArrayList<>();
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Test1 T = new Test1();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int[] a = new int[n];
//        for(int i=0; i<n; i++) {
//            a[i] = kb.nextInt();
//        }
//        int m = kb.nextInt();
//        int[] b = new int[m];
//        for(int i=0; i<m; i++) {
//            b[i] = kb.nextInt();
//        }
//        for (int x : T.solution(n, m, a, b)) System.out.print(x + " ");
//    }
//
//}