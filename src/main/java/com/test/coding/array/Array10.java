package com.test.coding.array;


import java.util.Scanner;

/**
 * 10. 봉우리
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 * 만약 N=5이고, 격자판의 숫자가 다음과 같다면 봉우리 개수는 10개입니다.
 *
 * 0  0  0  0  0  0  0
 * 0 [5] 3 [7] 2 [3] 0
 * 0  3 [7] 1 [6] 1  0
 * 0 [7] 2  5  3 [4] 0
 * 0  4  3 [6] 4  1  0
 * 0 [8] 7  3 [5] 2  0
 * 0  0  0  0  0  0  0
 * => []표시한 곳이 봉우리
 *
 *
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진자.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 봉우리의 개수를 출력하세요
 *
 * 테스트
 * 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2
 *
 * 결과
 * 10
 *
 *
 *
 * 해석
 * int[] dx = {-1, 0, 1, 0};
 * int[] dy = {0, 1, 0, -1};
 * 행을 i, 열을 j
 * 예를 들어 [1,2]일 경우
 * i for문 > j for문 > k for문
 * nx = i + dx[k] //행
 * ny = j + dy[k] //열
 * => k는 for문을 0~3까지
 *
 * k가 0일때
 * arr[nx][ny] 는 12시 방향을 가리킨다.
 * 상우하좌로 돌면서 비교하게 된다.
 *
 * => 대각선까지 8방향 보는 경우도 있어 dx, dy로 초기화하여 비교하는게 더 효율적이다.
 */


public class Array10 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int n, int[][] arr) {
        int anwser = 0;  //봉우리갯수
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                boolean flag = true;
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5 에러 주의
                    //앞쪽에 nx >= 0 && nx < n && ny >= 0 && ny < n 를 추가하여 참조하기 전에 먼저 막아야 한다.
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {  //상우하좌에서 나보다 큰 값이 있으면 난 봉우리 X
                        flag = false;
                        break;   //이미 나보다 큰 곳이 있으면 다른곳은 비교할 필요가 없기에 break
                    }
                }
                if(flag) anwser++;
            }
        }

        return anwser;
    }

    public static void main(String[] args) {
        Array10 T = new Array10();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i =0; i < n; i++){
            for(int j=0; j < n ; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }


}



















//public class Array10 {
//
//    int[] dx = {-1, 0, 1, 0};
//    int[] dy = {0, 1, 0, -1};
//    public int solution(int n, int[][] arr) {
//        int anwser = 0;
//
//        return anwser;
//    }
//
//    public static void main(String[] args) {
//        Array10 T = new Array10();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int[][] arr = new int[n][n];
//        for(int i =0; i < n; i++){
//            for(int j=0; j<n ; j++) {
//                arr[i][j] = kb.nextInt();
//            }
//        }
//        System.out.println(T.solution(n, arr));
//    }
//
//
//}
