import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("sol.in"));
        //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> scores = new ArrayList<Integer>(n);
        int currentS = in.nextInt();
        scores.add(currentS);
        for(int scores_i=0; scores_i < n - 1; scores_i++){
            int newS = in.nextInt();
            if(newS != currentS){
                scores.add(newS);
                currentS = newS;
            }
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        int score = 0;
        int tot = scores.size();
        int curInd = tot - 1;

        for(int i = 0; i < m; i++){
            score = alice[i];
            while(curInd >= 0 && score > scores.get(curInd)){
                curInd--;
            }
            if(curInd == -1) {
                System.out.println(1);
            }
            else if(score >= scores.get(curInd)) System.out.println(curInd + 1);
            else{
                System.out.println(curInd + 2);
            }
        }
    }
}