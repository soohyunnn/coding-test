package com.test.coding.sortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
    public  int x, y;

    //생성자
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //아래는 외워두기
    @Override
    public int compareTo(Point o) {
        //내림차순으로 하려면 this가 크고 o가 작아야 한다.
//        if(this.x == o.x) return o.y - this.y;
//        else return o.x - this.x;

        if(this.x == o.x) return this.y - o.y;  //x축이 같으면 y축으로 비교(this - o 하려면 -(음수)가 return되어야 한다. => 오름차순) ex) 10 - 20 = -10(오름차순이면 return이 음수)
        else return this.x - o.x;
    }
}


public class Test7 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Point(x, y));  //객체생성 -> 생성자 호출
        }

        //정렬
        Collections.sort(arr);
        for (Point o : arr) System.out.println(o.x + " " + o.y);
    }
}
