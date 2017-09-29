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
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();

            String[] board = new String[n];
            for(int board_i = 0; board_i < n; board_i++){
                board[board_i] = in.next();
            }
            n = n+1;
            array = new int[n][n];
            int kCount = 0;
            int same = 0;
            int oneLess = 0;
            for(int i = 0; i < n; i++){
                array[0][i] = 5000;
                array[i][0] = 5000;
            }
            for(int i = 1; i < n; i++){
                String current = board[i-1];
                for(int j = 1; j < n; j++){
                    char noe = current.charAt(j-1);
                    if(noe == 'X'){
                        array[i][j] = 5000;
                    } else{
                        int min = Math.min(array[i-1][j],array[i-1][j-1]);
                        min = Math.min(min,array[i][j-1]);
                        if(min == 5000) min = -1;
                        array[i][j] = min + 1;
                    }
                    if(noe == 'K'){
                        kCount += array[i][j];
                        if(array[i][j] == array[i - 1][j]){
                            same++;
                        }
                        if(array[i][j] == array[i][j - 1]){
                            same++;
                        }
                        if(array[i][j] == (array[i - 1][j] + 1)){
                            oneLess++;
                        }
                        if(array[i][j] == (array[i][j - 1] + 1)){
                            oneLess++;
                        }
                        if(array[i][j] == (array[i - 1][j - 1] + 1)){
                            oneLess++;
                        }
                    }
                }
            }
            printArray(array);
            if(kCount%2 == 0){
                if(same == 0)System.out.println("LOSE");
                else System.out.println("WIN " + same);
            } else{
                if(oneLess == 0)System.out.println("LOSE");
                else System.out.println("WIN " + oneLess);
            }

        }
        /////////////////////// Main End\\
        in.close();
    }

    //////////////////////////////////Print 2D array/////////////////////////////////////////////
    public static void printArray(int[][] thatAr){
        int nnn = thatAr.length;
        for(int i = 0; i < nnn; i++){
            int[] current = thatAr[i];
            for(int j= 0; j < current.length; j++){
                System.out.print(current[j] + " ");
            }
            System.out.println();
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////

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



