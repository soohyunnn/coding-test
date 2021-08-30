package com.test.coding.string;

import java.util.Scanner;

/**
 * 7. 회문 문자열
 *
 * 설명
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 "NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 * 입력
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *
 * 테스트
 * gooG
 *
 * 결과:
 * YES
 *
 *
 */
public class String7 {
    //대소문자를 구분하지 않으니 전부 대문자로 변경하고 시작!
    //짝수든 홀수든 /2 해서 비교
    //GOOG => 자리수 0123 , 3이라는 자릿수 계산식은 => (len-i-1)
    public String solution(String str) {
        String answer = "YES";
        //1. toUpperCase() 사용
        str = str.toUpperCase();  //모두 대문자로 변경
        int len = str.length();
        for(int i = 0; i < len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)) return "NO";  //같지 않으면 NO
        }

        //2. StringBuilder() - reverse() 사용
        //equals()은 대소문자 구분해서 비교 => equalsIgnoreCase()는 대소문자 무시하고 비교
//        String answer1 = "NO";
//        String tmp = new StringBuilder(str).reverse().toString();
//        if(str.equalsIgnoreCase(tmp)) answer1 = "YES";

        return answer;
    }

    public static void main(String[] args) {
        String7 T = new String7();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }





}
