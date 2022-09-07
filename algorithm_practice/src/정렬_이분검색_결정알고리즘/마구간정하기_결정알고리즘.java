/*

설명
N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.

입력
첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.

출력
첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.

예시입력
5 3
1 2 8 4 9

예시출력
3
 */

package 정렬_이분검색_결정알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기_결정알고리즘 {
    public int solution(int cnt, int[] inputArray) {
        Arrays.sort(inputArray);
        int lt = 1;
        int rt = inputArray[inputArray.length-1];
        int answer = 0;
        int mid;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (count(inputArray, mid) >= cnt) {
                answer = mid;
                lt = mid + 1;
            }
            else {
                rt = mid -1;
            }
        }
        return answer;
    }

    private int count(int[] inputArray, int dist) {
        int cnt = 1;
        int startPoint = 1;
        for (int i=1; i<inputArray.length; i++) {
            if (inputArray[i] - startPoint >= dist) {
                cnt++;
                startPoint = inputArray[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        마구간정하기_결정알고리즘 main = new 마구간정하기_결정알고리즘();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = sc.nextInt();
        int[] inputArray = new int[N];
        for (int i=0; i<N; i++) {
            inputArray[i] = sc.nextInt();
        }
        System.out.println(main.solution(cnt, inputArray));
    }
}
