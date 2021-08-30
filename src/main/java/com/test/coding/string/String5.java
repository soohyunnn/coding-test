package com.test.coding.string;

import java.util.Scanner;

/**
 * 5. 특정 문자 뒤집기
 *
 * 설명
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 * 테스트
 * a#b!GE*T@S
 *
 * 결과
 * S#T!EG*b@a
 */
public class String5 {
    //앞에서 했던 lt, rt 로직을 응용해서 해야 함!
    //lt가 만약 특수문자면 그냥 ++(lt가 특수문자냐를 조건으로 걸기), rt가 만약 특수문자면 그냥 --(rt가 특수문자냐를 조건으로 걸기)
    public String solution(String str) {
        String answer;
        char[] s = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt< rt) {
            if(!Character.isAlphabetic(s[lt])) lt++;
            else if(!Character.isAlphabetic(s[rt])) rt--;
            else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);
        return answer;
    }

    public static void main(String[] args) {
        String5 T = new String5();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}
