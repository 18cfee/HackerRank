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
        int m = in.nextInt();
        int[] stat = new int[m];
        for(int i = 0; i < m; i++){
            stat[i] = in.nextInt();
        }
        Arrays.sort(stat);
        int difMax = 0;
        for(int i = 1; i < m; i++){
            int cru = stat[i] - stat[i -1];
            difMax = Math.max(cru,difMax);
        }
        difMax /=2;
        difMax = Math.max(difMax,stat[0]);
        difMax = Math.max(difMax,n - 1 - stat[m-1]);
        System.out.println(difMax);
    }
}
