package com.test.coding.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test6 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> anwser = new ArrayList<>();
        int[] tmp = arr.clone();  //깊은 복사(얕은 복사하면 안됨)
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]) anwser.add(i + 1);  //인덱스 번호가 0번부터 돌고있기 때문에 +1해주기
        }

        return anwser;
    }

    public static void main(String[] args) {
        Test6 T = new Test6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();   //학생수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();  //학생 키 정보 입력
        for(int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}
