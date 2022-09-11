/*
BFS로 풀어야 맞는 문제이지만 DFS 연습삼아 풀어본다.
아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노르까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수, 즉 간선(예지)의 개수를 길이로 하겠습니다.
트리의 형태는 다음과 같습니다.
1 / 2, 3 / 4 5 ,

가장 짧은 길이는 3번 노드까지의 길이인 1이다.

*/
package Recursive_Tree_Graph_DFS_BFS_기초;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node3 {
    int data;
    Node3 lt, rt;
    public Node3(int val) {
        data = val;
        lt=rt=null;
    }
}
public class 트리말단노드까지의가장짧은경로_DFS {
    Node3 root;
    public int DFS(int L, Node3 root) {
        if (root.lt==null && root.rt == null) return L;
        else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
    }

    public static void main(String[] args) {
        트리말단노드까지의가장짧은경로_DFS tree = new 트리말단노드까지의가장짧은경로_DFS();
        tree.root = new Node3(1);
        tree.root.lt = new Node3(2);
        tree.root.rt = new Node3(3);
        tree.root.lt.lt = new Node3(4);
        tree.root.lt.rt = new Node3(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}

