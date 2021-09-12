package com.test.coding.TwoPointersAndSlidingWindow;


import java.util.Scanner;

/**
 * 7. 최대 길이 연속부분수열(복합적 문제) ❣️❣️(어렵다)️
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
 * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 14인 다은과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속되니 연속부분수열은 1 1 0 0 [1 1 1 1 1 1 1 1] 0 1 이며 그 길이는 8입니다.
 *
 * 설명
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<=100,000)이 주어집니다.
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 *
 * 출력
 * 첫 줄에 최대 길이를 출력하세요.
 *
 * 테스트
 * 14 2(k)
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 *
 * 결과
 * 8
 *
 * => 2 pointer 알고리즘
 *
 */
public class Test7 {
    //cnt: 0을 1로 바꾼 횟수, k를 넘어가면 안됨.
    //아래 수식 보다 cnt > k 를 먼저 비교해야 함.
    //rt - lt +1 = lt와 rt 사이의 길이
    //rt는 0을 만나면 1로 변경
    //cnt 가 k 보다 커지면 아래와 같이 바꾼다.
    //lt는 1은 넘어가고, 원래 0이였던게 1로 바꾼겼을 때 다시 0으로 바꾸고 증가 그리고 rt-lt+1 계산 후 answer보다 작으면 갱신 X
    //rt++ 증가

    public int solution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;
        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) cnt++;
            while(cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Test7 T = new Test7();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}

















//public class Test7 {
//
//    public int solution(int n, int k, int[] arr) {
//        int answer = 0;
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Test7 T = new Test7();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int k = kb.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++) {
//            arr[i] = kb.nextInt();
//        }
//        System.out.println(T.solution(n, k, arr));
//    }
//}