/*
1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
2) 입력은 피보나치 수열의 총 항의 수이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

설명
첫 번째 줄에 N(1<=N<=1000)이 주어집니다.

첫 번째 줄에 N팩토리얼 값을 출력합니다.

입력예제
5
출력예제
120
 */
package Recursive_Tree_Graph_DFS_BFS_기초;

public class 피보나치수열 {
    public int DFS(int n) {
        if (n==1) return 1;
        else return n*DFS(n-1);
    }

    public static void main(String[] args) {
        피보나치수열 T = new 피보나치수열();
        System.out.println(T.DFS(5));
    }
}

