/*
설명

가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.

3 1 2 4
 4 3 6
  7 9
   16

N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.

입력
첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
출력
첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
답이 존재하지 않는 경우는 입력으로 주어지지 않는다.

예시입력
4 16
예시출력
3 1 2 4


힌트
해당 문제는 파스칼의 삼각형이다.
4 3 6은 3+1 1+2 2+4로 나타낼 수 있다.
7 9는 3+1+1+2 1+2+2+4,
16은 3+1+1+1+2+2+2+4 이다.
16을 3 1 2 4의 조합으로 나타내면 각각 1 3 3 1번 쓰였다.
이는 다시 3C0 + 3C1 + 3C2 + 3C3으로 나타낼 수 있다.

N이 5라면 4C0 + 4C1 + 4C2 + 4C3 + 4C4
즉 1 4 6 4 1이 되며 이 각각의 위치 숫자를
  (1 2 3 4 5) 와 같은 각각의 숫자와 곱해서 원하는 숫자 F가 나왔을 때의 배열을 출력하면 된다.

 */
package DFS_BFS_활용;

import java.util.Scanner;

public class 수열추측하기 {
    static int [] b, p, ch;
    static int n, f;
    boolean flag = false;
    int[][] dy = new int[11][11]; // 조합수, 메모이제이션 용도
    public int combi (int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public void DFS(int L, int sum) {
        if(flag) return;
        if (L == n) {
            if (sum == f) {
                for (int x : p) System.out.print(x + " ");
                flag = true;
            }
        }
        else {
            for (int i=1; i<=n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1; // i는 인덱스가 아니라 데이터임 (순열을 만들기 때문에)
                    p[L] = i;
                    DFS(L+1, sum+(p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        수열추측하기 T = new 수열추측하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];
        for (int i=0; i<n; i++) {
            b[i] = T.combi(n-1, i);
        }
        T.DFS(0, 0);
    }
}
