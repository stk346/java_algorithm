/*
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
예시 그래프
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

위 그래프에서 1번 정점에서 5번 정점으로 가는 가지수는 아래와 같이 총 6가지입니다.
1 2 3 4 5
1 2 5
1 3 4 2 5
1 3 4 5
1 4 2 5
1 4 5

입력설명
첫 번째 줄에는 정점의 수 N(1 <= N <= 20)와 간선의 수 M이 주어진다.
그 다음부터 M줄에 걸쳐 연결정보가 주어진다.

출력설명
총 가지수를 출력한다.

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

import java.util.Scanner;

public class 경로탐색_인접행렬 {
    static int n, m, answer=0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v) {
        if (v == n) answer ++;
        else{
            for (int i=1; i<=n; i++) {
                if (graph[v][i]==1 && ch[i]==0) { // 그래프상으로 갈 수 있고 한 번 방문한 경로가 아니면
                     ch[i]=1;
                     DFS(i); // v에서 i로 이동
                     ch[i]=0; // 다시 돌아오는 시점에서 check 풀어줌
                }
            }
        }
    }

    public static void main(String[] args) {
        경로탐색_인접행렬 T = new 경로탐색_인접행렬();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1; // 출발점 설정
        T.DFS(1); // 출발
        System.out.println(answer);
    }
}
