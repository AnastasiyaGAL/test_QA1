
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class task4 {
    public static int arr[];
    public static int q = 0;
    public static int i = 0;
    public static void main(String[] args) {

        try{
            Scanner sc1 = new Scanner(new File(args[0]));
            while(sc1.hasNext()){
                if ( ( sc1.nextLine() ) != null ) {
                    q++;
                }
            }
            sc1.close();
        }catch(FileNotFoundException e){e.printStackTrace();}
       // System.out.println(q);
        arr = new int[q];
        try{
            Scanner sc2 = new Scanner(new File(args[0]));
            while(sc2.hasNext()){
                arr[i]= sc2.nextInt();
                i++;
            }
            sc2.close();
        }catch(FileNotFoundException e){e.printStackTrace();}
        //System.out.println(Arrays.toString(arr));
        int k=0;
        int m=0;
        int count=0;
        for (int j = 0; j < arr.length;  j++) {
            k += arr[j];
        }
        m=k/arr.length;
        //System.out.println(m);
        for (int n = 0; n < arr.length;  n++) {
            while (arr[n]!=m) {
                if (arr[n]<m) {
                    arr[n]= arr[n]+1;
                    count++;}
                else if (arr[n]>m) {
                    arr[n]= arr[n]-1;
                    count++; }
            }
        }
        System.out.println(count);
        /*for (int v = 0; v < arr.length; v++) {
            System.out.print(arr[v]+" ");*/
    }
}

