import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Solution {
    static int[][] array;
    static int n;
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// Scannnner
        n = in.nextInt();
        int m = in.nextInt();
        array = new int[n][n];
        for(int a0 = 0; a0 < m; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            insert(x,y,w);
        }

        /////////////////////// Main End\\
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j= 0; j < n; j++){
                max = Math.max(array[i][j], max);
            }
        }
        System.out.println(max);
        System.out.println(Arrays.deepToString(array));
        in.close();
    }
    public static void insert(int x, int y, int w){
        int x0 = x;
        int upper = x0;
        int y0 = y;
        int w0 = w;
        array[x][y] -=w;
        while( y0 >= 0 && w0 > 0){
            if(x0 < 0) x0 = 0;
            if(upper > n -1) upper = n-1;
            for(int i = x0; i <= upper; i++){
                array[i][y0] += w0;
            }
            y0--;
            x0--;
            upper++;
            w0--;
        }
        y0 = y;
        x0 = x;
        upper = x0;
        w0 = w;
        while( y0 < n && w0 > 0){
            if(x0 < 0) x0 = 0;
            if(upper > n -1) upper = n-1;
            for(int i = x0; i <= upper; i++){
                array[i][y0] += w0;
            }
            y0++;
            x0--;
            upper++;
            w0--;
        }

        //right
        y0 = y;
        upper = y0;
        x0 = x + 1;
        w0 = w -1;
        while( x0 < n && w0 > 0){
            if(y0 < 0) y0 = 0;
            if(upper > n -1) upper = n-1;
            for(int i = y0; i <= upper; i++){
                array[x0][i] += w0;
            }
            y0--;
            x0++;
            upper++;
            w0--;
        }
        //left
        y0 = y;
        upper = y0;
        x0 = x - 1;
        w0 = w -1;
        while(x0 >= 0 && w0 > 0){
            if(y0 < 0) y0 = 0;
            if(upper > n -1) upper = n-1;
            for(int i = y0; i <= upper; i++){
                array[x0][i] += w0;
            }
            y0--;
            x0--;
            upper++;
            w0--;
        }
    }


    //////////////////////////////// Reverse an Int /////////////////////////////////////////////
    public static int reverseInt(int x){
        StringBuilder in = new StringBuilder();
        in.append(Integer.toString(x));
        in.reverse();
        x = Integer.parseInt(in.toString());
        return x;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////Sum the Numeric digits in a String//////////////////////////////////////
    public static long sumDigits(String x){
        int tot = 0;
        for(int i = 0; i < x.length(); i++){
            tot += Integer.parseInt(x.substring(i,i+1));
        }
        return tot;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////Default Dictionary//////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////Return List Prime Factorization////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////
}



