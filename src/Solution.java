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
    static SortedSet<Integer> tree;
    static boolean order = false;
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

    public static void makeSet(HashSet<Integer> set, int node, int color){
        List<Integer> edgeL = graph.get(node);
        for(Integer e : edgeL){
            int[] edge = edges[e];
            if(edge[2] == color && !set.contains(e)){
                set.add(e);
                int nnode = edge[0];
                if(node == nnode) nnode = edge[1];
                makeSet(set,nnode,color);
            }
        }
    }

    public static void fixOld(int[] edge, int oldC){
        // Make a set of both sides
        HashSet<Integer> first = new HashSet<Integer>();
        int node1 = edge[0];
        int node2 = edge[1];
        // The first to exsit will stay in the same spot
        makeSet(first,node1,oldC);
        // the second will do to a new spot - edge group must be updated
        HashSet<Integer> sec = new HashSet<Integer>();
        makeSet(sec,node2,oldC);
        if(sec.size() > 0 && first.size() > 0){
            List<HashSet<Integer>> list = map.get(oldC);
            list.add(sec);
            int update = list.size()-1;
            for(Integer e : sec){
                edges[e][3] = update;
            }
        }
        else if(sec.size() == 0 && first.size() == 0){
            List<HashSet<Integer>> list = map.get(oldC);
            int spot = edge[3];
            list.get(spot).clear();
        }
    }

    public static HashSet<Integer> getSet(int node, int color){
        List<Integer> nodeE = graph.get(node);
        for(Integer e: nodeE){
            if(edges[e][2] == color){
                set1Spot = edges[e][3];
                return map.get(color).get(edges[e][3]);
            }
        }
        return null;
    }

    static int set1Spot = 0;

    public static void fixNew(int[] edgeEdit,int edge, int color){
        int node1 = edgeEdit[0];
        int node2 = edgeEdit[1];
        if (!map.containsKey(color)) { // if the color is new, then we do not need to look at other edges
            map.put(color, new ArrayList<HashSet<Integer>>());
            HashSet<Integer> e = new HashSet<Integer>();
            e.add(edge);
            map.get(color).add(e);
            edgeEdit[3] = map.get(color).size() - 1;
        } else {
            HashSet<Integer> set1 = getSet(node1,color);
            int set1S = set1Spot;
            HashSet<Integer> set2 = getSet(node2,color);
            int set2S = set1Spot;
            edgeEdit[2] = color;
            if(set1 == null && set2 == null){
                HashSet<Integer> e = new HashSet<Integer>();
                e.add(edge);
                map.get(color).add(e);
                edgeEdit[3] = map.get(color).size() - 1;
            } else if(set1 == null){
                set2.add(edge);
                edgeEdit[3] = set2S;
            } else if(set2 == null){
                set1.add(edge);
                edgeEdit[3] = set1S;
            } else{ // Combine
                set1.addAll(set2);
                set1.add(edge);
                edgeEdit[3] = set1S;
                for(Integer e : set2){
                    edges[e][3] = set1S;
                }
                set2.clear();
            }
        }
    }

    public static void change(int edge, int color){
        order = false;
        int[] edgeEdit = edges[edge];
        int oldColor = edgeEdit[2];
        edgeEdit[2] = color;
        fixOld(edgeEdit,oldColor);
        edgeEdit[2] = oldColor;
        fixNew(edgeEdit,edge,color);
    }

    public static void runningSum(int low, int high){
        if(order == false){
            tree = new TreeSet<Integer>(map.keySet());
            order = true;
        }
        int sum = 0;
        Iterator<Integer> iter = tree.tailSet(low).iterator();
        while (iter.hasNext()) {
            Integer a = iter.next();
            if(a > high) break;
            List<HashSet<Integer>> current = map.get(a);
            for(HashSet<Integer> i : current){
                if(i != null){
                    int k = i.size();
                    sum += (k+1)*(k)/2;
                }
            }
        }
        System.out.println(sum);
    }

    public static void pEdge(int edge){
        int p = 0;
        int[] stat = edges[edge];
        int color = stat[2];
        int slot = stat[3];
        p = map.get(color).get(slot).size();
        p = (p+1)*p/2;
        System.out.println(p);
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
                    colorAddedNow.put(color, ofColor.size() - 1);
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
            int[] edge = edges[e];
            if(array[e] == false) {
                array[e] = true;
                int newNode = edge[0]; // this and next line check both spots of edge
                if (newNode == node) newNode = edge[1];
                int newColor = edge[2];
                int newPSet = edge[3];
                init(newNode, newColor, newPSet);
            }

        }
        //////Recursion Part to go down tree
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



