/*
다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.

1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5



입력 예제
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

출력 예제
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2


 */
package Recursive_Tree_Graph_DFS_BFS_기초;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그래프_최단거리 {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph; // 각 정점이 갈 수 있는 정점만 담은 배열을 생성한다. 이로써 연산량을 줄일 수 있음.
    static int[] ch, dis;
    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        그래프_최단거리 T = new 그래프_최단거리();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        dis = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for (int i=2; i<=n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
