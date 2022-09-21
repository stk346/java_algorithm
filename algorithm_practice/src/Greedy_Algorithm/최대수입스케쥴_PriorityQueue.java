/*
설명
현수는 유명한 강연자이다. N개의 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.

입력
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
출력
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

예시입력
6
50 2
20 1
40 2
60 3
30 3
30 1
예시출력
150
 */
package Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;
    Lecture (int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture ob) {
        return ob.date - this.date;
    }
}
public class 최대수입스케쥴_PriorityQueue {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr); // 날짜에 의해서 내림차순 정렬
        int j = 0;
        for (int i=max; i>=1; i--) { // 일 수가 많이 남은 강좌들부터 루프를 돈다.
            for ( ; j<n; j++) {
                if (arr.get(j).date < i) break; // 가장 일 수가 많이 남은 강의를 차레대로 보며 max값 추출
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        최대수입스케쥴_PriorityQueue T = new 최대수입스케쥴_PriorityQueue();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if (d > max) max = d;
        }
        System.out.println(T.solution(arr));
    }
}

/*
j를 for문에 포함시키면 바깥쪽 루프가 돌 때마다 0으로 초기화 되지만
for문 바깥에 선언해주면 0으로 초기화되지 않고 값을 유지한다.
 */