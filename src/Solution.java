import java.io.*;
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
        int[] n1 = new int[6];
        for(int i = 0; i < n; i++){
            n1[in.nextInt()]++;
        }
        int max = 0;
        int index = 0;
        for(int i = 1; i < 6; i++){
            if(n1[i] > max){
                max = n1[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}