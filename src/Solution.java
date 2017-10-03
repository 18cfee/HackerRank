import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Solution {
    static int[] array;
    static int n;
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// Scannnner
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            n = in.nextInt();
            array = new int[n];
            int sum = 0;
            for(int j= 0; j < n; j++){
                sum+= array[j] = in.nextInt();
            }
            if(sum == 0) System.out.println(n-1);
            else{
                System.out.println(rec(0,n-1));
            }

        }

        /////////////////////// Main End\\
        in.close();
    }

    public static int rec(int a, int b){
        if(a == b) return 0;
        long left = array[a];
        long right = array[b];
        int a1= a;
        int b1 = b;
        boolean leftO = false;
        while(a1 < b1 - 1){
            if(left > right){
                b1--;
                right += array[b1];
            }else if(left == right){
                if(leftO) {
                    b1--;
                    right += array[b1];
                    leftO = false;
                }else{
                    a1++;
                    left += array[a1];
                    leftO = true;
                }
            }
            else{
                a1++;
                left += array[a1];
            }
        }
        if(right == left) return 1+ Math.max(rec(a,a1),rec(b1,b));
        else return 0;
    }

    ////////////////////////////////////3-Way Max////////////////////////////////////////////////
    public static int max(int aa, int bb, int cc){
        return Math.max(aa,Math.max(bb,cc));
    }
    /////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////Print array/////////////////////////////////////////////
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

    public static void printArray(int[] thatAr){
        int nnn = thatAr.length;
        for(int i = 0; i < nnn; i++){
            System.out.print(thatAr[i] + " ");
        }
        System.out.println();
    }

    public static void printList(List<Integer> thatAr){
        int nnn = thatAr.size();
        for(int i = 0; i < nnn; i++){
            System.out.print(thatAr.get(i) + " ");
        }
        System.out.println();
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
            tot += x.charAt(i) - '0';
        }
        return tot;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////Default Dictionary//////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////Return List Prime Factorization////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////
}



