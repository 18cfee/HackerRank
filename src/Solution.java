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
            int cycles = in.nextInt();
            int b = 0;
            int tot = 1;
            while(b < cycles){
                tot *= 2;
                b++;
                if(b < cycles){
                    tot++;
                }
                b++;
            }
            System.out.println(tot);
        }

    }
}