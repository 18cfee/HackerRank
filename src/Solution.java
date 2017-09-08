import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int R = in.nextInt();
        int[][] matrix = new int[M][N];
        for(int i = 0; i < M; i++){
            int[] array = new int[N];
            for(int j= 0; j < N; j++){
                array[j] = in.nextInt();
            }
            matrix[i] = array;
        }
        int step = Math.min(M,N)/2;
        int up = M -step; // M - 1 array + 1 starts on one - step for outside
        int right = N - step;
        int downOrLeft = step - 1;
        int width = 1+N - step*2;
        int height = 1+M - step*2;
        int[][] jaggedA = new int[step][];
        for(int i = 0; i < step; i++){//number of inner boxes
            int length = 2*(width) + 2*(height);
            int[] array = new int[length];
            int arrayIndex = 0;
            //upper
            for(int j = downOrLeft; j < right; j++){
                array[arrayIndex++] = matrix[up][j];
            }
            //right
            for(int j = up; j > downOrLeft; j--){
                array[arrayIndex++] = matrix[j][right];
            }
            //lower
            for(int j = right; j > downOrLeft; j--){
                array[arrayIndex++] = matrix[downOrLeft][j];
            }

            //left
            for(int j = downOrLeft; j < up; j++){
                array[arrayIndex++] = matrix[j][downOrLeft];
            }
            width+=2;
            height+=2;
            downOrLeft--;
            right++;
            up++;
            jaggedA[i] = array;
        }
        up = M -step; // M - 1 array + 1 starts on one - step for outside
        right = N - step;
        downOrLeft = step - 1;
        width = 1+N - step*2;
        height = 1+M - step*2;
        for(int i = 0; i < step; i++){//number of inner boxes
            int[] array = jaggedA[i];
            int length = array.length;
            int arrayIndex = length -R%length;
            //upper
            for(int j = downOrLeft; j < right; j++){
                matrix[up][j] = array[arrayIndex++%length];
            }
            //right
            for(int j = up; j > downOrLeft; j--){
                 matrix[j][right] = array[arrayIndex++%length];
            }
            //lower
            for(int j = right; j > downOrLeft; j--){
                matrix[downOrLeft][j] = array[arrayIndex++%length];
            }
            //left
            for(int j = downOrLeft; j < up; j++){
                matrix[j][downOrLeft] = array[arrayIndex++%length];
            }
            width+=2;
            height+=2;
            downOrLeft--;
            right++;
            up++;
        }
        for(int i = 0; i < M; i++){
            for(int j= 0; j < N; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}