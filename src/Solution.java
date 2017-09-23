import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if(f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// Scannnner
        int n = in.nextInt();
        int m = in.nextInt();
        int[] n1 = new int[n];
        int nMAx = 0;
        for(int i = 0; i < n; i++){
            int input = in.nextInt();
            n1[i] = input;
            nMAx = Math.max(input, nMAx);
        }
        int[] m1 = new int[m];
        int mMAx = 200;
        for(int i = 0; i < m; i++){
            int input = in.nextInt();
            m1[i] = input;
            mMAx = Math.min(input, mMAx);
        }
        int tot = 0;
        for(int i = nMAx; i <= mMAx; i++){
            boolean insert = true;
            for(int j = 0; j < n; j++){
                if(i%n1[j]!=0) insert = false;
            }
            for(int j = 0; j < m; j++){
                if(m1[j]%i!=0) insert = false;
            }
            if(insert) tot++;
        }
        System.out.println(tot);
    }
}