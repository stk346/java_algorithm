/*

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time3 implements Comparable<Time3>{
    int t;
    char s;
    public Time3 (int t, char s) {
        this.t = t;
        this.s = s;
    }
    @Override
    public int compareTo(Time3 ob) {
        if (this.t == ob.t) return this.s - ob.s;
        else return this.t - ob.t;
    }
}
public class practice {
    public int solution(ArrayList<Time3> arr) {
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(arr);
        for (Time3 t : arr) {
            if (t.s == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        practice T = new practice();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time3> arr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            arr.add(new Time3(sc.nextInt(), 's'));
            arr.add(new Time3(sc.nextInt(), 'e'));
        }
        System.out.println(T.solution(arr));
    }
}
