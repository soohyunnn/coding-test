package com.test.coding.stackAndQueue;


import java.util.Scanner;
import java.util.Stack;

/**
 * 3. 크레인 인형뽑기(카카오)
 * 설명
 * 게임개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
 * 죠르디는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.
 *
 * 게임 화면은 1 * 1 크기의 칸들로 이루어진 N * N 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.
 * (위 그림은 5 * 5 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.
 * 모든 인형은 1 * 1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.
 * 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는데,
 * 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
 * 다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.
 *
 *
 *
 *
 *
 *
 *
 */
public class Test3 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int pos : moves) {  //pos는 크레인 위치
            for (int i = 0; i < board.length; i++) {  //board.length : 2차원 배열의 행 크기
                if (board[i][pos - 1] != 0) {  //0이 아니면 인형 발견
                    int tmp = board[i][pos - 1];  //인형 가져오기
                    board[i][pos - 1] = 0;  //인형을 가져오고 나서 0으로 만들어주기
                    if(!stack.isEmpty() && tmp == stack.peek()) {//peek()는 값만 확인, 꺼내는 것이 아님
                        answer += 2;   //2개가 터지니 +2
                        stack.pop();   //터지면 상단에 있는거 꺼내기
                    } else stack.push(tmp);
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Test3 T = new Test3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) moves[i] = kb.nextInt();
        System.out.println(T.solution(board, moves));
    }

}
