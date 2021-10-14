import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int M = in.nextInt();
        
        int[] Tree = new int[L+1];
        Arrays.fill(Tree, 1);

        int S, T;
        for (int i = 0; i < M; i++) {
            S = in.nextInt();
            T = in.nextInt();
            Arrays.fill(Tree, S, T+1, 0);
        }

        System.out.println(Arrays.stream(Tree).sum());

        in.close();
    }
}