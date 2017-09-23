import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("sol.in"));
        //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int next = in.nextInt();
            if(next > 37 && next%5 > 2) next += (5-next%5);
            System.out.println(next);
        }
    }
}