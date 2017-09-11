import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long finalNum = 1;
        int[] array = new int[n+1];
        for(int i = 0; i < n - 1; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            array[a]++;
            array[b]++;
        }
        int pos = 0;
        for(int i = 1; i <= n; i++){
            if(array[i] > 1){
                pos++;
            }
        }
        long mod = 1000000007;

        for(int i = 0; i < pos; i++){
            finalNum = 2*finalNum%mod;
        }

        System.out.println(finalNum);
    }
}