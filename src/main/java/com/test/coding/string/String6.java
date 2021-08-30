package com.test.coding.string;

import java.util.Scanner;

/**
 * 6. 중복문자제거
 *
 * 설명
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 * 입력
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 *
 * 테스트
 * ksekkset
 *
 * 결과
 * kset
 *
 */
public class String6 {

    public String solution(String str) {
        String answer = "";
        for(int i = 0; i < str.length() ; i++) {
//            System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            /*
            ksekkset  => 자기 위치와 indexOf와 다른건 삭제, 같은것만 남기기 ex) k 0 0 => 0 : 자기위치, 0: indexOf
            k 0 0
            s 1 1
            e 2 2
            k 3 0
            k 4 0
            s 5 1
            e 6 2
            t 7 7
             */
            if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }


        return answer;
    }

    public static void main(String[] args) {
        String6 T = new String6();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}
