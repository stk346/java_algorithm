package 정렬_이분검색_결정알고리즘;

import java.util.Scanner;

public class 삽입정렬 {
    private int[] solution(int[] inputArray) {
        int N = inputArray.length;
        for (int i=1; i<N; i++) {
            int tmp=inputArray[i]; int j;
            for (j=i-1; j>=0; j--) {
                if (inputArray[j] > tmp) {
                    inputArray[j+1] = inputArray[j];
                }
                else break;
            }
            inputArray[j+1] = tmp;
        }
        return inputArray;
    }

    public static void main(String[] args) {
        삽입정렬 main = new 삽입정렬();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inputArray = new int[N];
        for (int i=0; i<N; i++) {
            inputArray[i] = sc.nextInt();
        }
        String answer = "";
        for (int i : main.solution(inputArray)) {
            answer += i + " ";
        }
        System.out.println(answer);
    }
}
