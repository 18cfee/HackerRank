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
        String n = in.next();
        int k = in.nextInt();
        int print = (int)superDigit(sumDigits(n)*k);
        System.out.println(print);
    }

    public static long superDigit(long x){
        long sum = sumDigits(Long.toString(x));
        return (sum < 10) ? sum: superDigit(sum);
    }

    public static long sumDigits(String x){
        int tot = 0;
        for(int i = 0; i < x.length(); i++){
            tot += Integer.parseInt(x.substring(i,i+1));
        }
        return tot;
    }
}
