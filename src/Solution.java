import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

class Direction{
    public int iadd;
    public int jadd;
    public Direction(int i, int j){
        this.iadd = i;
        this.jadd = j;
    }
}

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
        String dir = in.next();
        int iS = in.nextInt();
        int jS = in.nextInt();
        array = new int[n][n];
        Direction up = new Direction(1, 0);
        Direction left = new Direction(0, -1);
        Direction down = new Direction(-1, 0);
        Direction right = new Direction(0, 1);
        List<Direction> directs = new ArrayList<Direction>(4);
        if(dir.equals("w")){
            directs.add(left);
            directs.add(up);
            directs.add(down);
            directs.add(right);
        } else if(dir.equals("e")){
            directs.add(right);
            directs.add(up);
            directs.add(down);
            directs.add(left);
        } else if(dir.equals("s")){
            directs.add(up);
            directs.add(right);
            directs.add(left);
            directs.add(down);
        } else if(dir.equals("n")){
            directs.add(down);
            directs.add(right);
            directs.add(left);
            directs.add(up);
        }
        int count = 1;
        int upper = n*n;
        while(count < upper){
            array[iS][jS] = count;
            for(int i = 0; i < 4; i++){
                Direction cur = directs.get(i);
                if(tryS(iS+cur.iadd,jS+cur.jadd)){
                    iS +=cur.iadd;
                    jS +=cur.jadd;
                    count++;
                    break;
                }
            }
        }
        array[iS][jS] = count;
        printArray(array);
        /////////////////////// Main End\\
        in.close();
    }

    public static boolean tryS(int i, int j){
        if(0 <= i && 0 <= j && i <n && j <n && array[i][j] == 0){
            return true;
        }else return false;
    }

    //////////////////////////////////Print 2D array/////////////////////////////////////////////
    public static void printArray(int[][] thatAr){
        int nnn = thatAr.length;
        for(int i = 0; i < nnn; i++){
            int[] current = thatAr[i];
            for(int j= 0; j < n; j++){
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



