import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Solution {

    static int n,m;
    static int[][][] B;
    static int[][] C;
    static int[] A;
    static long[][] rowOrder;
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// Scannnner
        n = in.nextInt();
        m = in.nextInt();
        A = new int[n];
        rowOrder = new long[n][2];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        C = new int[m][2];
        for(int C_i=0; C_i < m; C_i++){
            C[C_i][0] = in.nextInt();
        }
        B = new int[n][m][2];
        for(int B_i=0; B_i < n; B_i++){
            for(int B_j=0; B_j < m; B_j++){
                B[B_i][B_j][0] = in.nextInt();
            }
        }
        long iterationSTime = System.currentTimeMillis();
        int max = 0;
        int iter = 4;
        int maxMil = 80000;
        reset(true);
        rowOrder();
        max = Math.max(entire(0,iter), entireReverse(0,iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(entire((int)(Math.random()*n),iter), entireReverse((int)(Math.random()*n),iter));
        reset(true);
        max = Math.max(max, entire(0,iter));
        System.out.println(max);
        //currentTime = System.currentTimeMillis();
        //System.out.println("That took " + (currentTime - startTime) + " milliseconds");
    }
    static void rowOrder(){
        Math.max(entire(0,3), entireReverse(0,3));
        for(int C_i=0; C_i < m; C_i++){
            C[C_i][1]--;
        }
        int[][] order = new int[n][m];
        for(int i = 0; i < n; i++){
            order[i] = getOrdering(A[i],i);
            //System.out.println(Arrays.toString(order[i]));
            rowOrder[i][0] = 1000000*order[i][m - 1];
            if(m > 2){
                rowOrder[i][0] += 1000*order[i][m - 2] + order[i][m - 3];
            }
            rowOrder[i][1] = i;
        }
        //System.out.println(Arrays.deepToString(rowOrder));
        Arrays.sort(rowOrder, Comparator.comparingDouble(a -> a[0]));
        //System.out.println(Arrays.deepToString(rowOrder));
        reset(true);
    }

    static int entireReverse(int startRow, int iterations){
        if(startRow > n - 1){
            startRow = n - 1;
        }
        int max = 0;
        for(int x = 0; x < iterations; x++){
            //for lines
            int candy = 0;
            for(int i = startRow; i >= 0; i--){
                int balls = A[i];
                candy += maxRow(balls,i);
            }
            for(int i = n-1; i > startRow; i--){
                int balls = A[i];
                candy += maxRow(balls,i);
            }
            for(int B_j=0; B_j < m; B_j++){
                candy -= finalColumnCost(B_j);
            }
            max = Math.max(candy,max);
            //System.out.println(candy);
        }
        return max;
    }

    static int entire(int startRow, int iterations){
        if(startRow > n - 1){
            startRow = n - 1;
        }
        int max = 0;
        for(int x = 0; x < iterations; x++){
            //for lines
            int candy = 0;
            for(int i = startRow; i < n; i++){
                int i2 = (int)rowOrder[i][1];
                int balls = A[i2];
                candy += maxRow(balls,i2);
            }
            for(int i = 0; i < startRow; i++){
                int i2 = (int)rowOrder[i][1];
                int balls = A[i2];
                candy += maxRow(balls,i2);
            }
            for(int B_j=0; B_j < m; B_j++){
                candy -= finalColumnCost(B_j);
            }
            max = Math.max(candy,max);
            //System.out.println(candy);
        }
        return max;
    }

    static void reset(boolean cost){
        for(int B_i=0; B_i < n; B_i++){
            for(int B_j=0; B_j < m; B_j++){
                B[B_i][B_j][1] = 0;
            }
        }
        if(cost == true){
            for(int C_i=0; C_i < m; C_i++){
                C[C_i][1] = 0;
            }
        }
    }

    static int maxRow(int balls,int i){
        //System.out.println("New Row " + i);
        int tot = 0;
        double[][] canRow = new double[m][2];
        for(int j= 0; j < m; j++){
            //System.out.println("Balls in Column " + j + ": " + C[j][1]);
            if(B[i][j][1] == 1){ // ball in the spot
                B[i][j][1] = 0;
                C[j][1]--;
            }
            //System.out.println("Balls in Column " + j + ": " + C[j][1]);
            canRow[j][0] = B[i][j][0] - candyCost(j) + Math.random();
            //System.out.println("C"+ j +" " +candyCost(j) + "B: " + B[i][j][1]);
            canRow[j][1] = j;
            //System.out.println(Arrays.toString(canRow[j]));
        }
        Arrays.sort(canRow, Comparator.comparingDouble(a -> a[0]));
        for(int k= m - 1; k >= 0; k--){
            int gain = (int)canRow[k][0];
            //System.out.println(i +":" + gain);
            if(gain > 0){
                int coorK = (int)canRow[k][1];
                B[i][coorK][1] = 1;
                C[coorK][1]++;
                tot += B[i][coorK][0];
                balls--;
            }
            else{
                break;
            }
            if(balls == 0) break;
        }
        //System.out.println(B[0][0][1] + "  " + B[1][0][1]);
        /*for(int l = 0; l < m; l++){
            System.out.print((int)canRow[l][1]+ ":"+(int)canRow[l][0] + ", ");
        }
        System.out.println();*/
        return tot;

    }

    static int[] getOrdering(int balls, int i){
        int[] row = new int[m];
        for(int j= 0; j < m; j++){
            row[j] = B[i][j][0] - candyCost(j);
        }
        Arrays.sort(row);
        for(int k= m - 1; k >= 0; k--){
            int gain = row[k];
            //System.out.println(i +":" + gain);
            if(gain > 0){
                row[k] = 0;
                balls--;
            }
            else{
                break;
            }
            if(balls == 0) break;
        }
        Arrays.sort(row);
        return row;
    }

    static int candyCost(int j){
        int sizeBox = C[j][0];
        int ballBox = C[j][1] + 1; // + one for if this one is added
        if(sizeBox >= ballBox){
            return 0;
        }
        else{
            return (ballBox - sizeBox)*(ballBox - sizeBox) - (ballBox - 1 - sizeBox)*(ballBox - 1 - sizeBox);
        }
    }

    static int finalColumnCost(int j){
        int sizeBox = C[j][0];
        int ballBox = C[j][1]; // + one for if this one is added
        if(sizeBox >= ballBox){
            return 0;
        }
        else{
            return (ballBox - sizeBox)*(ballBox - sizeBox);
        }
    }


}
