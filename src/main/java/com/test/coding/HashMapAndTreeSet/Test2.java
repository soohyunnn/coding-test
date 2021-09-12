package com.test.coding.HashMapAndTreeSet;


import java.util.HashMap;
import java.util.Scanner;

/**
 * 2. 아나그램(HashMap)
 * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
 * 예를 들면 AbaAeCe와 baeeACA는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), c(1), e(2)로
 * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
 *
 * 입력
 * 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
 * 단어의 길이는 100을 넘지 않습니다.
 *
 * 출력
 * 두 단어가 아나그램이면 "YES"를 출력하고, 아니면 "NO"를 출력합니다.
 *
 * 테스트1
 * AbaAeCe
 * baeeACA
 *
 * 결과1
 * YES
 *
 * 테스트2
 * abaCC
 * Caaab
 *
 * 결과2
 * NO
 *
 *
 */
public class Test2 {
    public String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(char x : s1.toCharArray()) {
            if(!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);   //ket값이 없을리가 없다.(key가 있으니 이 for문이 도는 것)
        }

        return answer;
    }

    public static void main(String[] args) {
        Test2 T = new Test2();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(T.solution(a,b));
    }

}















//public class Test2 {
//    public String solution(String s1, String s2) {
//        String answer = "YES";
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Test2 T = new Test2();
//        Scanner kb = new Scanner(System.in);
//        String a = kb.next();
//        String b = kb.next();
//        System.out.println(T.solution(a,b));
//    }
//
//}