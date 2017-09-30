import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Solution {
    static boolean[] array;
    static int[][] edges;
    static int n;
    static List<List<Integer>> graph;
    static HashMap<Integer,List<HashSet<Integer>>> map = new HashMap<Integer, List<HashSet<Integer>>>();
    static SortedSet<Integer> tree = new TreeSet<Integer>(map.keySet());
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// Scannnner
        n = in.nextInt();
        edges = new int[n][4];
        graph = new ArrayList<List<Integer>>(n+1);
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 1; i < n; i++){
            int[] edge = edges[i];
            int a = edge[0] = in.nextInt();
            int b = edge[1] = in.nextInt();
            edge[2] = in.nextInt();
            graph.get(a).add(i);
            graph.get(b).add(i);
        }
        array = new boolean[n]; // checked edges
        init(1,-1, 0);
        int q = in.nextInt();
        for(int i = 0; i < q; i++){
            int op = in.nextInt();
            if(op == 1){
                //change color
                int edge = in.nextInt();
                int newColour = in.nextInt();
                change(edge,newColour);
            } else if(op == 2){
                // compute sum for a few colours
                int low = in.nextInt();
                int high = in.nextInt();
                runningSum(low,high);
            } else{
                //Compute P of an edge
                int edge = in.nextInt();
                pEdge(edge);
            }
        }
        /////////////////////// Main End\\
        in.close();
    }

    public static void init(int node, int pColor, int pSet){
        //array[node] = true; // checked
        List<Integer> edgesL = graph.get(node);
        // Map of color added now and index in list added
        HashMap<Integer,Integer> colorAddedNow = new HashMap<Integer,Integer>();
        if(pColor != -1){
            colorAddedNow.put(pColor,pSet);
        }
        for(Integer e : edgesL){
            //if(partOfParent)else // maybe add to working set of stuff
            if(array[e] == false) {
                int color = edges[e][2];
                if (!map.containsKey(color)) {
                    map.put(color, new ArrayList<HashSet<Integer>>());
                }
                if (!colorAddedNow.containsKey(color)) {
                    HashSet<Integer> curSet = new HashSet<Integer>();
                    curSet.add(e);
                    List<HashSet<Integer>> ofColor = map.get(color);
                    ofColor.add(curSet);
                    colorAddedNow.put(e, ofColor.size() - 1);
                    edges[e][3] = ofColor.size() - 1; // group it is in // pSet
                } else {
                    List<HashSet<Integer>> ll = map.get(color);
                    HashSet<Integer> curSet = map.get(color).get(colorAddedNow.get(color));
                    curSet.add(e);
                    edges[e][3] = colorAddedNow.get(color);
                }
            }
        }
        for(Integer e : edgesL){
            if(array[e] == false) {
                array[e] = true;
                int[] edge = edges[e];
                int newNode = edge[0]; // this and next line check both spots of edge
                if (newNode == node) newNode = edge[1];
                int newColor = edge[2];
                int newPSet = edge[3];
                init(newNode, newColor, newPSet);
            }
        }
        //////Recursion Part to go down tree
    }

    public static void change(int edge, int color){
        int oldColor = edges[edge][2];
        edges[edge][2] = color;
    }

    public static void runningSum(int low, int high){
        int sum = 0;
        System.out.println(sum);
    }

    public static void pEdge(int edge){
        int p = 0;
        System.out.println(p);
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



