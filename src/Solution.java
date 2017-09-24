import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

class Edge {
    private int a;
    private int b;
    private int flowCap;
    private int residualFlow;
    public Edge(int x, int y, int z){
        this.a = a;
        this.b = b;
        this.flowCap = flowCap;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getFlowCap() {
        return flowCap;
    }

    public void setFlowCap(int flowCap) {
        this.flowCap = flowCap;
    }

    public int getResidualFlow() {
        return residualFlow;
    }

    public void setResidualFlow(int residualFlow) {
        this.residualFlow = residualFlow;
    }
}

class Vertice {
    private List<Edge> edgesOut;
    private List<Edge> edgesN;
    private List<Edge> edgesIn;
    public Vertice(){
        edgesN = new ArrayList<Edge>();
    }

    public void addEdgeN(Edge e){
        edgesN.add(e);
    }

    public List<Edge> getEdges() {
        return edgesN;
    }
}



public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// Scannnner
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            List<Vertice> graph = new ArrayList<Vertice>(n);
            graph.add(null); // filler to get right numbering
            for(int j= 0; j < n; j++){
                graph.add(new Vertice());
            }
            for(int j= 0; j < m; j++){
                int x = in.nextInt();
                int y = in.nextInt();
                int z = in.nextInt();
                Edge a = new Edge(x,y,z);
                graph.get(x).addEdgeN(a);
                graph.get(y).addEdgeN(a);
            }
            int stop = 0;
        }

        /////////////////////// Main End
    }



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



