import java.util.Scanner;

public class practice {
    static int[] ua;
    static int Find(int v) {
        if (v == ua[v]) return v;
        else return ua[v] = Find(ua[v]);
    }
    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            ua[fa] = fb;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ua = new int[n+1];
        for (int i=1; i<=n; i++) ua[i] = i;
        for (int i=1; i<=m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a, b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int f1 = Find(a);
        int f2 = Find(b);
        if (f1 == f2) System.out.println("YES");
        else System.out.println("NO");
    }
}