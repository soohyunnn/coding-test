package com.test.coding.string;

import java.util.Scanner;

/**
 * 문자 찾기
 *
 * 설명
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 * 대소문자를 구분하지 않습니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 입력
 * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어집니다.
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * 첫 줄에 해당 문자의 개수를 출력합니다.
 *
 * 테스트
 * Computercooler
 * c
 * 결과 : 2
 */
public class String1 {

    public int solution(String str, char t) {
        int answer = 0;
        //대소문자를 구분하지 않으니까 전부 대문자로 바꾸기(str, t 모두)
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        //System.out.println(str+ " " + t);

        //1. 일반 for 문
//        for(int i = 0; i< str.length(); i++){
//            if(str.charAt(i)==t) answer++;
//        }

        //2. 향상된 for 문
        //toCharArray : 문자열을 문자배열로 변경
        for(char x : str.toCharArray()) {
            if(x == t) answer++;
        }


        return answer;
    }

    public static void main(String[] args) {
        String1 T = new String1();
        Scanner kb = new Scanner(System.in);
        //입력
        String str = kb.next();       //문자열
        char c =kb.next().charAt(0);  //문자 1개

        //출력
        System.out.println(T.solution(str, c));
    }

}