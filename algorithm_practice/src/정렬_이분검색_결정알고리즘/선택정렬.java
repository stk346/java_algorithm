package 정렬_이분검색_결정알고리즘;

import java.util.Scanner;

public class 선택정렬 {
    private String solution(int[] inputArray) {
        for (int i=0; i< inputArray.length-1; i++) {
            for (int j=i+1; j<inputArray.length; j++) {
                if (inputArray[j] < inputArray[i]) {
                    int tmp = inputArray[i];
                    inputArray[i] = inputArray[j];
                    inputArray[j] = tmp;
                }
            }
        }
        String answer = "";
        for (int i : inputArray) {
            answer += i + " ";
        }
        return answer;
    }

    public static void main(String[] args) {
        선택정렬 main = new 선택정렬();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inputArray = new int[N];
        for (int i=0; i<N; i++) {
            inputArray[i] = sc.nextInt();
        }
        System.out.println(main.solution(inputArray));
    }
}
