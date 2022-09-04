package 정렬_이분검색_결정알고리즘;

import java.util.Scanner;

public class 버블정렬 {

    public int[] solution(int[] inputArray) {
        int N = inputArray.length;
        for (int i=0; i<N-1; i++) {
            for (int j=0; j<N-i-1; j++) {
                if (inputArray[j] > inputArray[j+1]) {
                    int tmp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = tmp;
                }
            }
        }
        return inputArray;
    }

    public static void main(String[] args) {
        버블정렬 main = new 버블정렬();
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
