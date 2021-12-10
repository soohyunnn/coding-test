package com.test.coding.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time1 implements Comparable<Time1> {
    public int s, e;

    Time1(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time1 o) {
        if(this.e == o.e) return this.s - o.s;  //끝나는 시간이 같으면 시작 시간을 오름차순이 됨(음수가 된다)
        else return this.e - o.e;  //끝나는 시간이 다르면 그냥 끝나는 시간으로 정렬
    }
}

public class Test2 {
    public int solution(ArrayList<Time1> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);  //위에 compareTo 기준에 의해서 정렬된다.
        int et = 0;
        for (Time1 ob : arr) {
            if (ob.s >= et) {
                cnt++;
                et = ob.e;  //끝나는 시간을 이제 시작하는 회의의 끝나는 시간으로 다시 설정
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Test2 T = new Test2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time1> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Time1(x, y));
        }
        System.out.println(T.solution(arr, n));
    }

}
