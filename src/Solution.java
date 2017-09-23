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
        int t = in.nextInt();
        for(int j = 0;j < t; j++){
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int tot = (m+s -1)%n;
            if(tot == 0) tot = n;
            System.out.println(tot);
        }
    }
}