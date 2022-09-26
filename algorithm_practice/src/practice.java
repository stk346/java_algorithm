import java.util.*;

class Lecture implements Comparable<Lecture>{
    int money;
    int date;
    public Lecture (int money, int date) {
        this.money = money;
        this.date = date;
    }
    @Override
    public int compareTo(Lecture ob) {
        return ob.date - this.date;
    }

}
public class practice {
    static int max, answer = 0;
    public int solution(ArrayList<Lecture> arr) {
        Collections.sort(arr);
        PriorityQueue<Integer> pQ = new PriorityQueue(Collections.reverseOrder());
        int j = 0;
        for (int i=max; i>=1; i--) {
            for ( ; j<arr.size(); j++) {
                if (arr.get(j).date < i) {
                    break;
                }
                pQ.offer(arr.get(j).money);
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        practice T = new practice();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int money = sc.nextInt();
            int date = sc.nextInt();
            arr.add(new Lecture(money, date));
            if (date > max) max = date;
        }
        System.out.println(T.solution(arr));
    }
}