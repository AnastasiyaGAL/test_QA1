import java.util.ArrayList;
import java.util.List;

public class task1 {

    public static void main (String[] args) throws NumberFormatException {
        int n =Integer.parseInt (args[0]);//4
        int m =Integer.parseInt (args[1]);//3

        int arr[] = new int[n];
        int arr2[] = new int[n*m];

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i % arr.length];
           // System.out.print(arr2[i]);
        }
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr2.length; i+=m-1) {
                 list.add(arr2[i]);
        }
        System.out.print(list.get(0));
        for(int i = 1; i < list.size(); i++) {
            if (list.get(i)!=1)
                System.out.print(list.get(i));
            else
                break;
        }

    }
}


