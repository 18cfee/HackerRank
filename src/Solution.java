import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BitSet[] array = new BitSet[n];
        for(int i = 0; i < n; i++){
            array[i] = fromString(in.next());
        }
        int[] store = new int[m + 1];
        for(int i = 0; i < n; i++){
            for(int j= i+1; j < n; j++){
                BitSet temp = new BitSet(m);
                temp.or(array[i]);
                temp.or(array[j]);
                int setBits = temp.cardinality();
                store[setBits]++;
            }
        }
        for(int j= m; j >= 0; j--){
            if(store[j] != 0){
                System.out.println(j);
                System.out.println(store[j]);
                break;
            }
        }
    }

    public static BitSet fromString(String s){
        int len = s.length();
        BitSet set = new BitSet(len);
        for(int i = 0; i < len; i++){
            if (s.charAt(i) == '1') set.set(i);
        }
        return set;
    }
}
