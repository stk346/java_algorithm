package 정렬_이분검색_결정알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {
    public ArrayList<Integer> solution(int N, int[] inputArray) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = inputArray.clone();
        Arrays.sort(tmp);
        for (int i=0; i<N; i++) {
            if (tmp[i] != inputArray[i]) {
                answer.add(i+1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        장난꾸러기 main = new 장난꾸러기();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inputArray = new int[N];
        for (int i=0; i<N; i++) {
            inputArray[i] = sc.nextInt();
        }
        for (int i : main.solution(N, inputArray)) {
            System.out.print(i + " ");
        }
    }
}
