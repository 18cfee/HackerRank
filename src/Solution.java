import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
            for(int i = 0; i < n; i++){
                array[0][i] = 5000;
                array[i][0] = 5000;
            }
            List<Integer> stacks = new ArrayList<Integer>();
            List<List<Integer>> vals = new ArrayList<List<Integer>>();
            for(int i = 1; i < n; i++){
                String current = board[i-1];
                for(int j = 1; j < n; j++){
                    char noe = current.charAt(j-1);
                    List<Integer> set = new ArrayList<Integer>();
                    if(noe == 'X'){
                        array[i][j] = 5000;
                    } else{
                        set.add(array[i-1][j-1]);
                        set.add(array[i][j-1]);
                        set.add(array[i-1][j]);
                        int insert = 0;
                        //set = set.stream().filter(x -> x < 5000).collect(Collectors.toList());
                        while(set.contains(insert)){
                            insert++;
                        }
                        array[i][j] = insert;
                    }
                    if(noe == 'K'){
                        stacks.add(array[i][j]);
                        vals.add(set);
                    }
                }
            }
            //printArray(array);
            int ans = 0;
            for(Integer i : stacks){
                ans = ans ^ i;
            }
            if(ans == 0){
                System.out.println("LOSE");
            } else{
                int tot = 0;
                int inc = 0;
                for(Integer i : stacks){
                    int beforeThis = i^ans;
                    List<Integer> set = vals.get(inc);
                    for(Integer j : set){
                        if((beforeThis ^ j) == 0){
                            tot++;
                        }
                    }
                    inc++;
                }
                System.out.println("WIN " + tot);
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



