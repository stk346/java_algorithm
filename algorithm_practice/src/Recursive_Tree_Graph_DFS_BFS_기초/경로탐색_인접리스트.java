/*
방향그래프가 주어자면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.

1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

위의 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는 아래와 같이 총 6가지입니다.

1 2 3 4 5
1 2 5
1 3 4 2 5
1 3 4 5
1 4 2 5
1 4 5

입력 예제
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

출력 예제
6


 */
package Recursive_Tree_Graph_DFS_BFS_기초;

import java.util.ArrayList;
import java.util.Scanner;

public class 경로탐색_인접리스트 {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph; // 각 정점이 갈 수 있는 정점만 담은 배열을 생성한다. 이로써 연산량을 줄일 수 있음.
    static int[] ch;
    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        경로탐색_인접리스트 T = new 경로탐색_인접리스트();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
