//package com.test.coding.recursiveAndTreeAndGraph;
//
//class Node {
//    int data;
//    Node lt, rt;
//    public Node(int val) {
//        data = val;
//        lt = rt = null;
//    }
//}
//
//public class Test9 {
//    Node root;
//    public int DFS(int L, Node root) {  //root가 가리키는 노드가 말단노드이면 이때의 L이 해당 노드가 있는 레벨인 것이다. (root가 말단노드일대 return 해줘야 한다)
//        if (root.lt == null && root.rt == null) return L;
//        else return Math.min(DFS(L + 1, root.lt), DFS(L+1, root.rt));  //이 방식은 왼쪽 노드, 오른쪽 노드로 뻗기 때문에 자식이 왼쪽과 오른쪽 둘 중 하나만 있으면 에러남.(자식이 하나만 있으면 DFS 사용 불가능)
//    }
//
//    public static void main(String[] args) {
//        Test9 tree = new Test9();
//        tree.root = new Node(1);
//        tree.root.lt = new Node(2);
//        tree.root.rt = new Node(3);
//        tree.root.lt.lt = new Node(4);
//        tree.root.lt.rt = new Node(5);
//        System.out.println(tree.DFS(0, tree.root));
//    }
//}
