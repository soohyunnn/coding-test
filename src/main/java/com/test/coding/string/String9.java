package com.test.coding.string;


import java.util.Scanner;

/**
 * 9. 숫자만 추출
 *
 * 설명
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 * 만약 "tgeOa1h205er"에서 숫자만 추출하면 0,1,2,0,5이고 이것을 자연수를 만들면 1205이 됩니다.
 * 추출하면 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 * 입력
 * 첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 출력
 * 첫 줄에 자연수를 출력합니다.
 *
 * 테스트
 * g0en2T0s8eSoft
 *
 * 결과
 * 208
 *
 */
public class String9 {
    /**
     * x >= 48 && x <= 57
     *
     * ex)g0en2T0s8eSoft
     * answer = answer * 10 + (x - 48)  => 공식
     * 0  = 0 * 10 + 0
     * 1  = 0 * 10 + 1
     * 12 = 1 * 10 + 2
     * 120 + 12 * 10 + 0
     *
     */
    public int solution(String s) {
        //방법1.
        int answer = 0;
        for(char x : s.toCharArray()) {
            if(x >= 48 && x <= 57) answer = answer * 10 + (x - 48);
        }
        return answer;

        //방법2 => Int형으로 형변환을 해줘야 한다 그렇지 않으면 0208이 출력됨
//        String answer = "";
//        for (char x : s.toCharArray()) {
//            if(Character.isDigit(x)) answer += x;
//        }
//        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        String9 T = new String9();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
