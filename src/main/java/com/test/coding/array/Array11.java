package com.test.coding.array;

import java.util.Scanner;

/**
 * 11. 임시반장정하기
 * 김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
 * 김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
 * 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 * 그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
 * 예를 들어 학생 수가 5명일 때의 표를 살펴보자
 *
 *         1학년 2학년 3학년 4학년 5학년
 * 1번 학생   2    3    1    7    3
 * 2번 학생   4    1    9    6    8
 * 3번 학생   5    5    2    4    4
 * 4번 학생   6    5    2    6    7
 * 5번 학생   8    4    2    2    2
 *
 * 위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
 * 2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도
 * 같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
 *
 * 입력
 * 첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3이상 1000 이하이다.
 * 둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
 * 주어지는 정수는 모두 1이상 9이하의 정수이다.
 *
 * 출력
 * 첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
 * 단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
 *
 * 테스트
 * 5
 * 2 3 1 7 3
 * 4 1 9 6 8
 * 5 5 2 4 4
 * 6 5 2 6 7
 * 8 2 2 2 2
 *
 * 결과
 * 4
 *
 * 행과 열은 1부터 시작하도록 시작
 * n = 5일경우
 * for i 1~5   n명
 *      for j 1~5   n명
 *          for k 1~5   학년(무조건 5학년까지)
 * a[i][k] == a[j][k] 를 비교, 같으면 cnt++
 * i가 4번일때 j도 4일때가 있는데 이때도 cnt++ 하는 것이다. (i != j)를 할필요가 없다. 학생수가 아니라 가장 많은 같은반을 한 학생을 찾는것이기 때문에
 * i가 4일때 j가 3일때 a[4][2] == a[3][2]일때 cnt++, a[4][3] == a[3][3]으로 또 같을때 cnt++를 하면 안된다. => 처음 참일때 break해야한다. 같은 학생을 여러번 카운팅하면 안되니까
 *
 */
public class Array11 {

    public int solution(int n, int[][] arr) {
        int answer = 0, max = Integer.MIN_VALUE;
        for(int i =1; i <= n ; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= 5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Array11 T = new Array11();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n + 1][6];
        for(int i=1; i<=n; i++){
            for(int j=1; j <= 5; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }

}













//public class Array11 {
//
//    public int solution(int n, int[][] arr) {
//        int answer = 0;
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Array11 T = new Array11();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int[][] arr = new int[n + 1][6];
//        for(int i=1; i<n; i++){
//            for(int j=0; j <= 5; j++){
//                arr[i][j] = kb.nextInt();
//            }
//        }
//        System.out.println(T.solution(n, arr));
//    }
//
//}