import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("sol.in"));
        //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String mount = in.next();
        int current = 0;
        int tot = 0;
        char a = mount.charAt(0);
        boolean up = false;
        if(a == 'U') {
            up = true;
            current++;
        }else{
            tot++;
            current--;
        }
        for(int i = 1; i < n; i++){
            a = mount.charAt(i);
            if(a == 'U') current++;
            else current--;
            if(current >= 0) up = true;
            else if(current < 0 && up == true){
                tot++;
                up = false;
            }
        }
        System.out.println(tot);
    }
}