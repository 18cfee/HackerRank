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
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(x1 != x2 && v1 == v2) return "NO";
        if(x1 > x2){
            while(x1 >= x2){
                if(x1 == x2){
                    return "YES";
                }
                x1 += v1;
                x2 += v2;
            }
        }else{
            while(x2 >= x1){
                if(x1 == x2){
                    return "YES";
                }
                x1 += v1;
                x2 += v2;
            }
        }
        return "NO";
    }
}