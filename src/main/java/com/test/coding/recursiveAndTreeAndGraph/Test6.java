package com.test.coding.recursiveAndTreeAndGraph;

public class Test6 {
    static int n;
    static int[] ch;   //체크를 하고 안하고를 하여 부분집합으로 사용을 할지 안할지 사용하기 위해
    public void DFS(int L) {
        if(L== n+1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if(ch[i]==1) tmp += (i + " ");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }
        else {
            ch[L] = 1;  //L원소를 사용
            DFS(L + 1);  //왼쪽으로 뻗음(o)
            ch[L] = 0;  //L원소를 사용하지 않음
            DFS(L + 1);  //오른쪽으로 뻗음(x)
        }
    }

    public static void main(String[] args) {
        Test6 T = new Test6();
        n = 3;  //집합의 원소의 갯수
        ch = new int[n + 1];   //체크 배열의 인덱스를 원소로 생각(인덱스 번호가 1~3 생겨야함)
        T.DFS(1);
    }
}
