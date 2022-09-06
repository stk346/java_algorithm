package 정렬_이분검색_결정알고리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> {
    int x, y;
    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        else {return this.x - o.x;}
    }
}
public class 좌표정렬 {

    public static void main(String[] args) {
        좌표정렬 main = new 좌표정렬();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Point> inputArray = new ArrayList<>();
        for (int i=0; i<N; i++) {
            inputArray.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(inputArray);
        for (Point p : inputArray) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
