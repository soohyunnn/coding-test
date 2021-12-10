package com.test.coding.GreedyAlgorithm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * 4. 최대 수입 스케줄(PriorityQueue 응용문제)
 * 현수는 유명한 강연자이다. N개의 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많은 돈을 벌 수 있도록 강연 스케줄을 짜야 한다.
 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 *
 * 설명
 * 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
 *
 * 출력
 * 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
 *
 * 테스트
 * 6
 * 50 2
 * 20 1
 * 40 2
 * 60 3
 * 30 3
 * 30 1
 *
 * 출력
 * 150
 *
 *
 *
 *
 *
 * => 앞에는 금액 뒤에는 날짜
 * => 입력 받을 때 날짜중에 제일 큰 값을 저장해두기 max = 3;
 * => 3-2-1 순으로 정렬먼저하여 3일차만 먼저 넣고 시작
 * => 3일차에서 선택 후 2일차 넣고 2일차 선택 후 1일차 넣고 1일차 선택 하는 방법 (3일차꺼를 2일차에도 할 수 있어 3일차에 선택 못한건 2일차에서 선택 가능하도록 로직을 짜야함)
 * => poll() 하면 제일 큰게 꺼내짐
 */
class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;
    Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }
    @Override
    public int compareTo(Lecture ob) {
        return ob.date - this.date;
    }
}
public class  Test4 {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());   //큰값으로 우선순위하는 PriorityQueue가 된다.
        Collections.sort(arr);
        int j = 0;
        for(int i = max; i >= 1; i--) {
            for( ; j < n; j++) {
                if(arr.get(j).date < i) break;
                pQ.offer(arr.get(j).money);
            }
            //어떤 강연을 할지 선택
            if(!pQ.isEmpty()) answer += pQ.poll();  //가장 큰 값을 poll(큰값으로 우선순위로 되어 있으니!)
        }

        return answer;
    }

    public static void main(String[] args) {
        Test4 T = new Test4();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) max = d;
        }
        System.out.println(T.solution(arr));
    }
}















//class Lecture implements Comparable<Lecture> {
//    public int money;
//    public int time;
//    Lecture(int money, int time) {
//        this.money = money;
//        this.time = time;
//    }
//    @Override
//    public int compareTo(Lecture ob) {
//        return ob.time - this.time;
//    }
//}
//public class Test4 {
//    static int n, max = Integer.MIN_VALUE;
//    public int solution(ArrayList<Lecture> arr) {
//        int answer = 0;
//        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Test4 T = new Test4();
//        Scanner kb = new Scanner(System.in);
//        n = kb.nextInt();
//        ArrayList<Lecture> arr = new ArrayList<>();
//        for(int i=0; i<n; i++) {
//            int m = kb.nextInt();
//            int d = kb.nextInt();
//            arr.add(new Lecture(m, d));
//            if(d > max) max = d;
//        }
//        System.out.println(T.solution(arr));
//    }
//}