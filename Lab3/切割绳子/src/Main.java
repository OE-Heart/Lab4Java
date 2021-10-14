import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] L = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = in.nextInt();
        }

        int t = Arrays.stream(L).sum()/k;

        while (true) {
            int cnt = 0;
            for (int Li: L) {
                cnt += Li/t;
            }
            if (cnt == k) break;
            else t--;
        }

        System.out.println(t);
        in.close();
    }
}
