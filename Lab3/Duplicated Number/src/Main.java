import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t;
        int i = 0;
        int bit = 0;
        for (i = 0; i < n; i++) {
            t = in.nextInt();
            int k = 1<<t;
            if ((bit & k) == k) break;
            else bit += k;
        }
        if (i == n) {
            System.out.print("NO");
        }
        else {
            System.out.print("YES");
        }
        in.close();
    }
}