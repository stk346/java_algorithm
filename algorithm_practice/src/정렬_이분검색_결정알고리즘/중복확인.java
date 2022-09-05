package 정렬_이분검색_결정알고리즘;

import java.util.Scanner;

public class 중복확인 {
    public String solution(int N, int[] inputArray) {
        int[] testArray = new int[N];
        for (int c : inputArray) {
            for (int i=0; i<N; i++) {
                if (c == testArray[i]) return "D";
            }
            for (int i=N-1; i>=1; i--) {
                testArray[i] = testArray[i-1];
            }
            testArray[0] = c;
        }
        return "U";
    }

    public static void main(String[] args) {
        중복확인 main = new 중복확인();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inputArray = new int[N];
        for (int i=0; i<N; i++) {
            inputArray[i] = sc.nextInt();
        }
        System.out.println(main.solution(N, inputArray));
    }
}
