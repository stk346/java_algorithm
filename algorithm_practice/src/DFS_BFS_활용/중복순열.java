/*
1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력하세요.

입력설명
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.

출력설명
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

입력예제
3 2

출력예제
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
 */
package DFS_BFS_활용;

import java.util.Scanner;

public class 중복순열 {
    static int[] pm;
    static int n, m;
    public void DFS(int L) {
        if (L == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
        }
        else {
            for (int i=1; i<=n; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        중복순열 T = new 중복순열();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        T.DFS(0);
    }
}
