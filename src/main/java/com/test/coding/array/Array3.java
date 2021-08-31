package com.test.coding.array;


import java.util.Scanner;

/**
 * 3. 가위 바위 보
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다.
 * 비길 경우에는 D를 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 * 예를 들면 N=5이면
 *
 * 회수          1 2 3 4 5
 * A의 정보       2 3 3 1 3
 * B의 정보       1 1 2 2 3
 * 승자          A B A B D
 *
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요
 *
 * 설명
 * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 *
 * 출력
 * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
 *
 * 테스트
 * 5
 * 2 3 3 1 3
 * 1 1 2 2 3
 *
 * 결과
 * A
 * B
 * A
 * B
 * D우
 *
 * A 또는 B하나를 기준으로 로직을 짜면 이중 for문을 돌리지 않아도 된다.
 * if A가 비겼을 경우
 * else if A가 가위로 이겼을 경우
 * else if A가 바위로 이겼을 경우
 * else if A가 보로 이겼을 경우
 * else B가 이겼을 경
 *
 */
public class Array3 {
    public String solution(int n, int[] a, int[] b) {
        String answer = "";
        for(int i =0; i<n; i++){
            if(a[i]==b[i]) answer += "D";
            else if(a[i] ==1 && b[i]==3) answer += "A";
            else if(a[i] ==2 && b[i]==1) answer += "A";
            else if(a[i] ==3 && b[i]==2) answer += "A";
            else answer += "B";
        }

        return answer;
    }

    public static void main(String[] args) {
        Array3 T = new Array3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            a[i] = kb.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i] = kb.nextInt();
        }
//        System.out.println(T.solution(n, a, b));
        for(char x : T.solution(n,a,b).toCharArray()) System.out.println(x);
    }
}




//public class Array3 {
//    public String solution(int n, int[] a, int[] b) {
//        String answer = "";
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Array3 T = new Array3();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[n];
//        for(int i=0; i<n; i++){
//            a[i] = kb.nextInt();
//        }
//        for(int i=0; i<n; i++){
//            b[i] = kb.nextInt();
//        }
//        System.out.println(T.solution(n, a, b));
//
//    }
//}




















