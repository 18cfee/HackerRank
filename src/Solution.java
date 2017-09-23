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
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int count = 0;
        for(; i <=j; i++){
            if(Math.abs(i - reversed(i))%k == 0) count++;
        }
        System.out.println(count);
    }
    public static int reversed(int x){
        while(x%10 == 0) x/=10;

        StringBuilder in = new StringBuilder();
        in.append(Integer.toString(x));
        in.reverse();
        x = Integer.parseInt(in.toString());
        return x;
    }
}