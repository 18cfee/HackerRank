import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("sol.in"));
        //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[101];
        for(int i = 0; i < n; i++){
            b[a[i]]++;
            b[a[i] + 1]++;
        }
        int max = 0;
        for(int i = 0; i < 101; i++){
            max = Math.max(max,b[i]);
        }
        System.out.println(max);
    }
}