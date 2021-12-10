package com.test.coding.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    public int time;
    public char state;

    Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time ob) {
        if(this.time == ob.time) return this.state - ob.state;  //시간이 같으면 알파벳으로 정렬하라!
        else return this.time - ob.time;
    }
}

public class Test3  {
    public int solution(ArrayList<Time> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);  //위에 compareTo기준으로 정렬
        int cnt = 0;
        for (Time ob : arr) {
            if(ob.state == 's') cnt++;
            else cnt--; //'e'일 경우
            answer = Math.max(answer, cnt);  //answer보다 cnt가 크면 cnt로 answer를 저장
        }
        return answer;
    }

    public static void main(String[] args) {
        Test3 T = new Test3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = kb.nextInt();
            int eT = kb.nextInt();
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }
        System.out.println(T.solution(arr));
    }

}
