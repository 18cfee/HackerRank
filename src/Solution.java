import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if(f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        int apples = 0;
        for(int i = 0; i < m; i++){
            if(t >= a + apple[i] && a + apple[i] >= s) apples++;
        }
        int oranges = 0;
        for(int i = 0; i < n; i++){
            if(t >= orange[i] + b && orange[i] + b >= s) oranges++;
        }
        System.out.println(apples);
        System.out.println(oranges);
    }
}