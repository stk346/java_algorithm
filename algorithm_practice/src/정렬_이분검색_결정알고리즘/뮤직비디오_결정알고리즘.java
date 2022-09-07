package 정렬_이분검색_결정알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오_결정알고리즘 {
    public int solution(int cnt, int[] inputArray) {
        int lt = Arrays.stream(inputArray).max().getAsInt();
        int rt = Arrays.stream(inputArray).sum();
        int answer=0;
        while (lt <= rt) {
            int mid = (lt+rt)/2;
            if (count(inputArray, mid) <= cnt) {
                answer=mid;
                rt = mid-1;
            }
            else {lt = mid+1;}
        }
        return answer;
    }

    private int count(int[] inputArray, int capacity) {
        int cnt=1, sum=0;
        for (int i : inputArray) {
            sum += i;
            if (sum > capacity) {
                sum = i;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        뮤직비디오_결정알고리즘 main = new 뮤직비디오_결정알고리즘();
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
