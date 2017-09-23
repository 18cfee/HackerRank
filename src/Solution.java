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
        for(int i = 0; i < n; i++){
            int stud = in.nextInt();
            int thresh = in.nextInt();
            for(int j = 0; j < stud; j++){
                if(in.nextInt() <= 0)thresh--;
            }
            String hi = "YES";
            if(thresh <= 0) hi = "NO";
            System.out.println(hi);
        }

    }
}