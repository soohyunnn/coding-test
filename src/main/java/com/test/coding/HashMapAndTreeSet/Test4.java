package com.test.coding.HashMapAndTreeSet;


import java.util.HashMap;
import java.util.Scanner;

/**
 * 4. 모든 아나그램 찾기(해쉬, 투포인터, 슬라이딩 윈도우)
 * S문자열에서 T문자열과 아나그래밍 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * 설명
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번재 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 * 출력
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 *
 * 테스트 1
 * bacaAacba
 * abc
 *
 * 결과
 * 3
 *
 * 출력설명 : {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 *
 * 테스트 2
 * bacaAacbaa
 * abca
 *
 * 결과
 *
 *
 *
 */
public class Test4 {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        //bm셋팅
        for(char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);

        //b길이 -1만큼 a길이 셋팅
        int l = b.length() - 1;
        for (int i = 0; i < l; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0)+1);  //a.charAt(i)는 문자 키값

        //2Point 알고리즘
        int lt = 0;
        for(int rt = l; rt < a.length(); rt ++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);  //rt가 가르키는 값을 카운팅 함
            //카운팅하면 비교 am과 bm
            if(am.equals(bm)) answer++;  //같으면 아나그램이기 때문에 ++해주기

            //lt가 가리키는 곳에서 하나 빼주야함
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if(am.get(a.charAt(lt))==0) am.remove(a.charAt(lt));
            lt++;
        }

        return answer;
    }


    public static void main(String[] args) {
        Test4 T = new Test4();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(T.solution(a, b));
    }

}
















//public class Test4 {
//    public int solution(String a, String b) {
//        int answer = 0;
//        HashMap<Character, Integer> am = new HashMap<>();
//        HashMap<Character, Integer> bm = new HashMap<>();
//
//        return answer;
//    }
//
//
//    public static void main(String[] args) {
//        Test4 T = new Test4();
//        Scanner kb = new Scanner(System.in);
//        String a = kb.next();
//        String b = kb.next();
//        System.out.println(T.solution(a, b));
//    }
//
//}