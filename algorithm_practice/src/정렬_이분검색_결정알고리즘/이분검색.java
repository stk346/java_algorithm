package 정렬_이분검색_결정알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {
    public int solution(int target, int[] inputArray) {
        int lt=0, rt=inputArray.length-1;
        int answer=0;
        Arrays.sort(inputArray);
        while(lt <= rt) {
            int mid = (lt+rt)/2;
            if (inputArray[mid] == target) {
                answer = mid+1;
            }
            if (inputArray[mid] < target) lt=mid+1;
            else rt=mid-1;
        }
        return answer;
    }

    public static void main(String[] args) {
        이분검색 main = new 이분검색();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] inputArray = new int[N];
        for (int i=0; i<N; i++) {
            inputArray[i] = sc.nextInt();
        }
        System.out.println(main.solution(target, inputArray));
    }
}
