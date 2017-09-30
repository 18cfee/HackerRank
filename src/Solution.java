import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

class tuple{
    public int black;
    public int white;
    public int mark;
    public tuple(int w, int b, int m){
        this.black = b;
        this.white = w;
        this.mark = m;
    }
}

public class Solution {
    static boolean[] array;
    static boolean[] array2;
    static int n;
    static boolean black = false;
    static List<HashSet<Integer>> tree;
    static List<List<tuple>> children;
    static List<Integer> nodes = new ArrayList<Integer>();
    static int max = 0;
    static int parent = 57;
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// Scannnner
        n = in.nextInt();
        tree = new ArrayList<HashSet<Integer>>(n+1);
        children = new ArrayList<List<tuple>>(n+1);
        for(int i = 0; i < n+1; i++){
            HashSet<Integer> c = new HashSet<Integer>();
            List<tuple> d = new ArrayList<tuple>();
            children.add(d);
            tree.add(c);
        }
        array = new boolean[n+1];
        array2 = new boolean[n+1];
        for(int i = 1; i < n+1; i++){
            array[i] = (in.nextInt() == 1);
        }
        for(int i = 0; i < n - 1; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        branch(1);
        System.out.println(max);
        printChildren(parent);
        nodes.add(parent);
        System.out.println(nodes.size());
        printList(nodes);
        /////////////////////// Main End\\
        in.close();
    }

    public static void printChildren(int parent){
        List<tuple> cur = children.get(parent);
        for (tuple val : cur) {
            if(black && val.black > 0){
                nodes.add(val.mark);
                printChildren(val.mark);
            } else if(!black && val.white > 0){
                nodes.add(val.mark);
                printChildren(val.mark);
            }
        }
    }

    public static tuple branch(int node){
        array2[node] = true;
        int white = 0;
        int black = 0;
        HashSet<Integer> a = tree.get(node);
        for (Integer val : a) {
            if (!array2[val]){
                tuple income = branch(val);
                white+=income.white;
                black+=income.black;
                children.get(node).add(income);
            }
        }
        if(array[node]){
            black++;
            white--;
        }else{
            white++;
            black--;
        }
        if(white < 0) white = 0;
        if(black < 0) black = 0;
        max = max(white,black,max,max,node);
        tuple ret = new tuple(white, black, node);
        return ret;
    }

    ////////////////////////////////////3-Way Max////////////////////////////////////////////////
    public static int max(int aa, int bb, int cc, int old, int node){
        int nM = Math.max(aa,Math.max(bb,cc));
        if(nM > old) {
            if(aa > bb) black = false;
            else black = true;
            parent = node;
        }
        return nM;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////

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



