package com.test.coding.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
    public String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);  //오름차순으로 정렬(내림차순은 좀 복잡)
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) return "D";
        }

        return answer;
    }

    public static void main(String[] args) {
        Test5 T = new Test5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(T.solution(n, arr));
    }
}
