package revision;
import java.util.*;
public class question7 {
    //find missing num
    public static int missingNum(int[] arr){
        int n = arr.length;
        int expectedSum = (n*(n+1)/2);
        int actualsum = 0;
      
        for(int i: arr ){
            actualsum += i;
        }
        return expectedSum - actualsum;
    }
    public static void main(String[] args){
        int[] arr ={3,0,1};
        System.out.println(missingNum(arr));
    }
}
