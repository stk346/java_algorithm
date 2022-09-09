/*
왼쪽 상단부터 1 2 3 4 5 6 7의 트리가 있다.

0레벨 탐색 0 -> 1레벨 탐색 -> 2레벨 팁섹 ...

root에서 1번 만에 갈 수 있는 노드 탐색, 2번 만에 갈 수 있는 노드 탐색 ...

레벨 탐색 순회 출력: 1 2 3 4 5 6 7
*/
package Recursive_Tree_Graph_DFS_BFS_기초;

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node lt, rt;
    public Node2(int val) {
        data=val;
        lt=rt=null;
    }
}


public class 이진트리레벨탐색_Breadth_First_Search {
    Node root;
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L=0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i=0; i<len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        이진트리레벨탐색_Breadth_First_Search tree = new 이진트리레벨탐색_Breadth_First_Search();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}

