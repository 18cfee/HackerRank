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
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int tot = 0;
            int[] array = new int[n + 1];
            for(int j= 1; j < n+1; j++){
                int cur = in.nextInt();
                array[j] = cur;
                if(cur > j + 2 && tot != -1){
                    tot = -1;
                    System.out.println("Too chaotic");
                }

            }
            if(tot != -1) {
                for(int j= n; j > 0; j--){
                    int cur = array[j];
                    if(j + 2 == cur){
                        tot +=2;
                        array[j] = array[j+1];
                        array[j+1] = array[j+2];
                        if(array[j+1] < array[j]){
                            int temp = array[j];
                            array[j] = array[j+1];
                            tot++;
                            array[j+1] = temp;
                        }
                    } else if(j + 1 == cur){
                        tot+=1;
                        array[j] = array[j+1];
                    }
                }
                //check last little bit
                if(array[1] > array[2]) tot++;
                System.out.println(tot);
            }
        }
    }

}
