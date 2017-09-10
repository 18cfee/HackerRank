import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long  getWays(int n, int indexPast){
        long storeN = store[n];
        if(storeN != -1) return storeN;
        if(indexPast == m) {
            return 0;
        }
        int coin = c[indexPast];
        if(indexPast == m-1){
            if(n%coin == 0) return 1;
            else return 0;
        }
        int nextIndex = indexPast + 1;
        int totWays = 0;
        for(int i = n; i >=0; i-=coin){
            totWays += store[i] = getWays(i,nextIndex);
        }
        return totWays;
    }

    static Integer[] c;
    static long[] store;
    static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        m = in.nextInt();
        c = new Integer[m];
        store = new long[n + 1];
        Arrays.fill(store,-1);
        store[0] = 1;
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        Arrays.sort(c, Collections.reverseOrder());
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n,0);
        System.out.println(ways);
    }
}