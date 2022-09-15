/*
조합의 경우는 nCr( n! / (n-r)! * r! )로 계산합니다.
하지만 이 공식을 쓰지 않고 nCr = c-1Cr-1 + n-1Cr 공식으로 재귀를 이용하여 조합수를 구해주는 프로그램을 작성하세요.

예시
[1, 2, 3, 4, 5]
위와 같은 집합에서 3명을 뽑는다고 가정하자.
이 때의 공식은 5C3 = 4C2 + 4C3 이다.
5번을 기준으로 예를 들자면
4C2는 5번이 무조건 포함된 상태에서 2명을 뽑는 상황, 즉 [x, y, 5]이다.
4C3의 경우 5번이 포함되지 않는 상황, 즉 [x, y, z]이다.


입력
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
출력
첫째 줄에 조합수를 출력합니다.

예시입력1
5 3
예시출력1
10

예시입력2
33 19
예시출력2
818809200
 */
package DFS_BFS_활용;

import java.util.Scanner;

public class 조합의경우수_메모이제이션 {
    int[][] dy = new int[35][35];
    public int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r]; // 메모이제이션
        if (n == r || r == 0) return 1;
        else return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }

    public static void main(String[] args) {
        조합의경우수_메모이제이션 T = new 조합의경우수_메모이제이션();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(T.DFS(n, r));
    }
}
