
package revision;
import java.util.*;

public class question1 {
    //find the largest and second largest

    public static void findNum(int[] arr){
        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;
        for(int n : arr){
            if(n > largest){
                slargest=largest;
                largest=n;
            }else if ( n > slargest && n!= largest){
                slargest = n;
            }
        }
        System.out.println("largest"+ largest);
        System.out.println("slargest"+ slargest);
    }
    public static void main(String[] args){
        int[] arr = {12,35,1,10,34,1};
        findNum(arr);
    }
}
