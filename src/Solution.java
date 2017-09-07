import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int low = (int)Math.sqrt(n1);
            int i;
            if(low * low == n1){
                i = low;
            } else{
                i = low+1;
            }
            int count =0;
            for(;i*i <= n2; i++) {
                count++;
            }
            System.out.println(count);
            int hg = 210; // testing git
        }
    }
}
