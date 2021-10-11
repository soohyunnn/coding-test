package com.test.coding.recursiveAndTreeAndGraph;

public class Test1 {
    public void DFS(int n) {
        //재귀함수는 주로 if~else 구조로 시작(종료 시점의 조건을 지정해줘야함 => return 사용)
        if (n == 0) {
            return;
        } else {
            DFS(n - 1);  //재귀함수(n이 3일 경우 n이 2인 DFS를 호출, DFS(3) -> DFS(2) -> DFS(1)
            System.out.print(n + " ");  //1 -> 2 -> 3(호출 위에 놓으면 3 -> 2 -> 1, 호출 아래에 놓으면 1 -> 2 -> 3) => 이 이유는 스택프레임때문이다.
        }
    }

    public static void main(String[] args) {
        Test1 T = new Test1();
        T.DFS(3);
    }
}
