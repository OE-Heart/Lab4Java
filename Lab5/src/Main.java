import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> pick(ArrayList<String> a) {
        HashSet<String> hs = new HashSet<String>(a);
        ArrayList<String> result = new ArrayList<String>(hs);
        Collections.sort(result);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while ( in.hasNext() ) {
            lst.add(in.next());
        }
        lst = pick(lst);
        for ( String x:lst) {
            System.out.print(x+" ");
        }
        System.out.println();
        in.close();
    }
}