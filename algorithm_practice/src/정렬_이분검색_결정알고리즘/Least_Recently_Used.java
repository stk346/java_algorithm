package 정렬_이분검색_결정알고리즘;

import java.util.Scanner;

public class Least_Recently_Used {
    public String solution(int size, int work, int[] inputArray) {
        int[] cache = new int[size];

        for (int k : inputArray) {
            int pos=-1;
            for (int i=0; i<size; i++) {
                if (k == cache[i]) pos = i;
            }
            if (pos == -1) {
                for (int i=size-1; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
                cache[0] = k;
            }
            else {
                for (int i=pos; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
                cache[0] = k;
            }
        }
        String answer = "";
        for (int i : cache) {
            answer += i + " ";
        }
        return answer;
    }

    public static void main(String[] args) {
        Least_Recently_Used main = new Least_Recently_Used();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int work = sc.nextInt();
        int[] inputArray = new int[work];
        for (int i=0; i< work; i++) {
            inputArray[i] = sc.nextInt();
        }
        System.out.println(main.solution(size, work, inputArray));
    }
}