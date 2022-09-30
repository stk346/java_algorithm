/*
설명 (사진참고)
원더 랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.

입력
첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
출력
모든 도시를 연결하면서 드는 최소비용을 출려한다.

예시입력
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
예시출력
196

정답예시
1 2 12
2 3 10
2 9 8
3 4 18
5 6 60
5 7 38
7 8 35
8 9 15
 */
package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge3 implements Comparable<Edge3> {
    public int vex;
    public int cost;
    Edge3(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge3 ob) {
        return this.cost - ob.cost; //  오름차순 정렬
    }
}
public class 원더랜드_프림_PriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Edge3>> graph = new ArrayList<ArrayList<Edge3>>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Edge3>());
        }
        int[] ch = new int[n+1];
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // 회로가 아니기 때문에 양방향 모두로 가는 경로를 넣어주어야함
            graph.get(a).add(new Edge3(b, c));
            graph.get(b).add(new Edge3(a, c));
        }
        int answer = 0;
        PriorityQueue<Edge3> pQ = new PriorityQueue<>();
        pQ.offer(new Edge3(1, 0));
        while (!pQ.isEmpty()) {
            Edge3 tmp = pQ.poll();
            int ev = tmp.vex; // 도착 정점
            if (ch[ev] == 0) { // 체크가 안돼있으면
                ch[ev] = 1; // 체크하고
                answer += tmp.cost;
                for (Edge3 ob : graph.get(ev)) { // 정점에 해당하는 리스트를 모두 offer함
                    // 가지 않았던 정점이면 최소 cost를 구하기 위해서 pQ에 집어넣음
                    if (ch[ob.vex] == 0 ) pQ.offer(new Edge3(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }
}
