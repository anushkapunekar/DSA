package revision;
import java.util.*;
public class question8 {
    //find maxsubarray
    public static int maxSubarray(int[] arr){
        int currentSum = arr[0];
        int maxSum= arr[0];
        for(int i =0 ; i<arr.length;i++){
            currentSum = Math.max(arr[i], currentSum+arr[i]);
            maxSum= Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args){
        int[] arr ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarray(arr));
    }
}
