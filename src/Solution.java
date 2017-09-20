import java.io.*;
import java.util.*;

public class Solution {

    static int getMoneySpent(int[] keyboards, int[] drives, int s){
        int a = keyboards.length;
        int b = drives.length;
        int max =-1;
        for(int i = 0; i < a; i++){
            for(int j= 0; j < b; j++){
                int cur = keyboards[i] + drives[j];
                if(cur > s) cur = -1;
                max = Math.max(max,cur);
            }
        }
        return max;
    }
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("sol.in"));
        //Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}