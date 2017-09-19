import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("sol.in"));
        //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] socks = new int[101];
        for(int i = 0; i < n; i++){
            socks[in.nextInt()]++;
        }
        int tot = 0;
        for(int i = 0; i < 101; i++){
            tot += socks[i]/2;
        }
        System.out.println(tot);

    }
}