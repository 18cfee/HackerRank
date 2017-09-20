import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("sol.in"));
        //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        n = n - n%2;
        int tot = Math.min((p)/2, (n - p + 1)/2);
        System.out.println(tot);
    }
}