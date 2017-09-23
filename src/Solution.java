import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// Scannnner
        int n = in.nextInt();
        int[] stat = new int[n+1];
        for(int i = 1; i <= n; i++){
            stat[i] = in.nextInt();
        }
        for(int i = 1; i <= n; i++){
            int a = 0;
            for(int j= 1; j <= n; j++){
                if(stat[j] == i) a = j;
            }
            for(int j= 1; j <= n; j++){
                if(stat[j] == a) System.out.println(j);
            }
        }
    }
}
