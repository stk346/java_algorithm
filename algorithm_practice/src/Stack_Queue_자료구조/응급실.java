package Stack_Queue_자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int idx;
    int priority;

    public Person(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}

public class 응급실 {
    public int solution(int N, int[] inputArray) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < inputArray.length; i++) {
            Q.offer(new Person(i, inputArray[i]));
        }

        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            for (Person p : Q) {
                if (tmp.priority < p.priority) {
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.idx == N) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        응급실 main = new 응급실();
        Scanner sc = new Scanner(System.in);
        int tempN = sc.nextInt();
        int N = sc.nextInt();
        int[] inputArray = new int[tempN];
        for (int i = 0; i < tempN; i++) {
            inputArray[i] = sc.nextInt();
        }
        System.out.println(main.solution(N, inputArray));
    }
}
