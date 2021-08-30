package com.test.coding.string;

import java.util.Scanner;

/**
 * 10. 가장 짧은 문자거리
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * 설명
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 * 테스트
 * teachermode e
 * => e로부터의 모든 문자열의 거리를 구하는 것
 *  P(거리) = 1000 으로 놓기
 *  첫번째 t는 e가 아니므로 +1해서 1001, e를 만나면 0으로 초기화
 *  t 왼쪽에 e가 없으므로 아주 먼 거리를 의미해서 P를 1000이라고 둠.
 *
 *  문자열 s  | t e a c h e r m o d e
 *         1001 0 1 2 3 0 1 2 3 4 0  => 왼쪽에 있는 e로부터 거리
 *            1 0 3 2 1 0 4 3 2 1 0  => 오른쪽에 있는 e로부터 거리
 *            1 0 1 2 1 0 1 2 2 1 0  => 왼쪽에 있는 e로부터의 거리와 비교해서 작은 수를 적는 것력(출력 값)
 *
 * 출
 * 1 0 1 2 1 0 1 2 2 1 0
 *
 *
 */
public class String10 {
    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 1000;
        //왼쪽에 있는 e로부터 거리
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t) {
                p=0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        //오른쪽에 있는 e로부터 거리
        p = 1000;
        for(int i = s.length() -1 ; i >= 0; i--) {
            if(s.charAt(i) == t) p=0;
            else {
            p++;
            answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String10 T = new String10();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        for(int x : T.solution(str, c)) {
            System.out.print(x + " ");
        }
    }
}
