import java.io.*;
import java.util.*;

public class Solution {

    static String[] remain;
    static String[] table;
    static int end;
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("sol.in"));
        table = new String[10];
        //System.exit(0);
        for(int i = 0; i < 10; i++){
            table[i] = in.next();
        }
        String words = in.next();
        remain = words.split(";");
        end = remain.length;
        func(0,table);
    }
    public static void func(int wordI,String[] table1){
        String word = remain[wordI];
        int len = word.length();
        int check = 11 - len;
        char first = word.charAt(0);
        String[] table2 = table1.clone();
        //Sideways
        for(int i = 0; i < 10; i++){
            for(int j= 0; j < check; j++){
                char current = table2[i].charAt(j);
                if(current == first || current == '-'){
                    //sideways
                    boolean fit = true;
                    for(int k= 0; k < len; k++){
                        char wcur = word.charAt(k);
                        char box = table2[i].charAt(j+k);
                        if(!(wcur == box || box == '-')){
                            fit = false;
                            break;
                        }
                    }
                    if(fit){
                           table2[i] = table2[i].substring(0,j) + word +
                                   table2[i].substring(j+len);
                    } else {
                        //down
                        //sdsdf
                        //
                    }
                    if(fit){
                        if(wordI == end -1){
                            for(int t = 0; t < 10; t++){
                                System.out.println(table2[t]);
                            }
                            System.exit(0);
                        } else {
                            func(wordI + 1, table2);
                            table2 = table1.clone();
                        }
                    }
                }
            }
        }
        //Down
        table2 = table1.clone();
        for(int i = 0; i < check; i++){
            for(int j= 0; j < 10; j++){
                char current = table2[i].charAt(j);
                if(current == first || current == '-'){
                    //sideways
                    boolean fit = true;
                    for(int k= 0; k < len; k++){
                        char wcur = word.charAt(k);
                        char box = table2[i + k].charAt(j);
                        if(!(wcur == box || box == '-')){
                            fit = false;
                            break;
                        }
                    }
                    if(fit){
                        for(int k= 0; k < len; k++){
                            char wcur = word.charAt(k);
                            char[] array = table2[i + k].toCharArray();
                            array[j] = wcur;
                            table2[i + k] = new String(array);
                        }
                    }
                    if(fit){
                        if(wordI == end -1){
                            for(int t = 0; t < 10; t++){
                                System.out.println(table2[t]);
                            }
                            System.exit(0);
                        } else {
                            func(wordI + 1, table2);
                            table2 = table1.clone();
                        }
                    }
                }
            }
        }
        return;
    }
}