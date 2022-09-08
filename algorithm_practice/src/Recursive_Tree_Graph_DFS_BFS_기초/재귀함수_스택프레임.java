/*
자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하시오.

설명
첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.
첫째 줄에 출력한다.

입력예제
3
출력예제
1 2 3
 */

package Recursive_Tree_Graph_DFS_BFS_기초;

public class 재귀함수_스택프레임 {
    public void DFS(int n) {
        if (n==0) return; // void에서는 함수를 종료하는 의미를 갖고 있기도 함.
        else {
//            System.out.print(n+" "); 3 2 1
            DFS(n - 1);
            System.out.print(n+" "); // 1 2 3
        }
    }

    public static void main(String[] args) {
        재귀함수_스택프레임 T = new 재귀함수_스택프레임();
        T.DFS(3);
    }
}
