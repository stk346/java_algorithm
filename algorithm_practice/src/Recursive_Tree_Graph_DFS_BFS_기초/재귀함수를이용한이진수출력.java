/*
10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하시오. 단, 재귀함수를 이용해야 합니다.

설명
첫 번째 줄에 10진수 N(1<=N<=1000)이 주어집니다.

첫 번째 줄에 이진수를 출력하세요.

입력예제
11
출력예제
1011
 */

package Recursive_Tree_Graph_DFS_BFS_기초;

// n을 2로 나눴을 때 몫과 나머지를 이용
public class 재귀함수를이용한이진수출력 {
    public void DFS(int n) {
        if (n==0) return;
        else{
            DFS(n/2);
            System.out.print(n%2 + " ");
        }
    }

    public static void main(String[] args) {
        재귀함수를이용한이진수출력 T = new 재귀함수를이용한이진수출력();
        T.DFS(11);
    }
}
