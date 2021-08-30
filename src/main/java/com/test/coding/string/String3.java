package com.test.coding.string;

import java.util.Scanner;

/**
 * 문장 속 단어(indexOf(), substring())
 *
 * 설명
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
 *
 * 테스트
 * it is time to study
 * 결과 : study
 */
public class String3 {

    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;  //가장 작은 값으로 초기화 됨
        int pos;

        //1. split 사용
//        String[] s = str.split(" ");
//        for(String x : s) {
////            System.out.println(x);
//            int len = x.length();
//            if(len > m) {
//                m = len;
//                answer = x;
//            }
//        }

        //2. indexOf(), substring()
        while ((pos = str.indexOf(" ")) != -1 ) {   //" "이 발견되면 처음으로 발견되는 index 수를 return
            String tmp = str.substring(0, pos);  //0부터 pos 전까지 자름
            int len = tmp.length();
            if(len > m) {   //주의!! >= 라고 하면 안됨!! 가장 길이가 긴 단어가 여러개면 앞에꺼를 출력해야 하니깐
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);  //" " 기준으로 앞에꺼는 짜르고 다시 while문을 돌려야 하기 때문에 추가
        }
        //마지막단어가 안돌아가기 때문에 추가
        if(str.length() > m) answer = str;
        return answer;
    }

    public static void main(String[] args) {
        String3 T = new String3();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }

}