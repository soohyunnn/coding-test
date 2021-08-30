package com.test.coding.string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 4. 단어 뒤집기
 *
 * 설명
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요
 *
 * 입력
 * 첫 줄에 자연수 N(3 <= N <= 20)이 주어집니다.
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 *
 * 테스트
 * 3
 * good
 * Time
 * Big
 *
 * 결과
 * doog
 * emiT
 * giBs
 */
public class String4 {

    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        //1. StringBuilder 사용 - reverse() 뒤집어 버리는 것 => 특정 조건에 맞는것만 뒤집어야 할 경우에는 쓰면 X, 다 뒤집어야 할 때 쓰기
//        for(String x : str){
//            String tmp = new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }

        //2. toCharArray 사용 => String이 문자배열화됨
        //reverse를 직접 구현하는 방법
        //ex) study -> s를 lt, y를 rt로 지정해 서로 바꾸기, u는 lt와 rt가 같기 때문에 그대로 유지되는 로직!
        for(String x: str) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1;
            while(lt < rt) {  //이게 거짓이면 문자는 다 뒤집어져 있는 것
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);  //s라는 문자배열을 String와 시켜줌 , valueOf static로 선언된 클래스 메소드임.
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        String4 T = new String4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++) {
            str[i] = kb.next();
        }
        for(String x : T.solution(n,str)) {
            System.out.println(x);
        }
    }


}
