package com.test.coding.string;

import java.util.Scanner;

/**
 * 11. 문자열 압축
 *
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 *
 * 설명
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력설명
 * 첫 줄에 압축된 문자열을 출력한다.
 *
 * i로 인덱스를 비교 => i와 i+1이 같은지 비교
 * cnt = 1
 * i와 i+1이 같으면 cnt +1(1증가), 같지 않으면 s[i]+cnt를 answer에 더한 후 cnt는 1로 초기화(cnt는 1보다 커야 answer에 누적)
 *
 * 테스트
 * KKHSSSSSSSE => 맨끝에 "" 빈 문자열을 받기
 *
 * 출력
 * K2HS7E
 *
 */
public class String11 {
    public String solution(String s) {
        String answer = "";
        s = s + "";  //뒤에 빈 문자열 추가
        int cnt = 1;
        for(int i = 0; i < s.length()-1 ; i++) {
            if(s.charAt(i) == s.charAt(i+1)) cnt ++;
            else {
                answer += s.charAt(i);
                if(cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String11 T = new String11();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
