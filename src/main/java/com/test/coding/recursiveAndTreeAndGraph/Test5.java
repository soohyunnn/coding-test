package com.test.coding.recursiveAndTreeAndGraph;

class Node1 {
    int data;
    Node1 lt, rt;
    public Node1(int val) {
        data = val;
        lt = rt = null;
    }
}
public class Test5 {
    Node1 root;
    public void DFS(Node1 root) {
        if (root == null) {
            return;
        } else {
//            System.out.print(root.data + " ");  //전위순회
            DFS(root.lt);  //왼쪽
//            System.out.print(root.data + " ");  //중위순회
            DFS(root.rt);  //오른쪽
            System.out.print(root.data + " ");  //후위순회
        }
    }

    public static void main(String[] args) {
        Test5 tree = new Test5();
        tree.root = new Node1(1);
        tree.root.lt = new Node1(2);
        tree.root.rt = new Node1(3);
        tree.root.lt.lt = new Node1(4);
        tree.root.lt.rt = new Node1(5);
        tree.root.rt.lt = new Node1(6);
        tree.root.rt.rt = new Node1(7);
        tree.DFS(tree.root);
    }
}

//D(100) -> D(200) -> D(300) -> D(400) -> D(500) -> ...