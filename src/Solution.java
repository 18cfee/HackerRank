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
        int initial = 2;
        int total = 2;
        for(int i = 1; i < n; i++){
            initial = (initial*3)/2;
            total += initial;
        }
        System.out.println(total);
    }
}