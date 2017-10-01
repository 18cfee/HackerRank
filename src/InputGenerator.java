import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class InputGenerator {
    public static void main(String[] args) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(new File("numbers.out"));
        int n = 4200;
        out.println(n);
        for(int i = 1; i < n; i++){
            out.println(1 + " " + (i+1) + " "+ (int)(Math.random()*5000));
        }
        out.println(3);
        out.println("2 6 7");
        out.println("2 3 4");
        out.println("1 2 500");
        out.close();
    }
}
