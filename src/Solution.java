import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        int k = in.nextInt();
        int[] cost = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            cost[i] = in.nextInt();
            sum += cost[i];
        }
        int pay = in.nextInt();
        k = cost[k];
        int should = (sum - k)/2;
        if(should == pay) System.out.println("Bon Appetit");
        else System.out.println(pay - should);

    }
}