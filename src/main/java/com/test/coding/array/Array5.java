package com.test.coding.array;


import java.util.Scanner;

/**
 * 5. 소수(에라토스테네스 체)
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 6, 11, 13, 17, 19로 총 8개입니다.
 * 제한시간은 1초입니다.
 *
 * 설명
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 소수의 개수를 출력합니다.
 *
 * 테스트
 * 20
 *
 * 결과
 * 8
 *
 * 2번 인덱스부터 i를 1씩 증가시켜 해당 인덱스가 0이면 => cnt 수 1증가 , 이 후 해당 수와 그 배열 수는 모두 1로 변경
 *
 */
public class Array5 {
    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for(int i=2; i<=n; i++) {
            if(ch[i] == 0) {
                answer++;
                for (int j = 1; j <= n; j = j + 1) ch[j] = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Array5 T = new Array5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}






//public class Array5 {
//    public int solution(int n) {
//        int answer = 0;
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Array5 T = new Array5();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        System.out.println(T.solution(n));
//    }
//}









