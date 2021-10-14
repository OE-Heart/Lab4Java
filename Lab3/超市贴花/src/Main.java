import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] P = new int[n];
        for (int i = 0; i < n; i++) {
            P[i] = in.nextInt();
        }
        
        Arrays.sort(P);

        int cnt = 0;
        for(int i = 0; i < n-2; i++) {
            if (P[i+1] == P[i]+1 && P[i+2] == P[i]+2) {
                cnt++;
                i += 2;
            }
        }

        System.out.println(cnt);

        in.close();
    }
}
