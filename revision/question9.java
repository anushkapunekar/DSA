package revision;
import java.util.*;
public class question9 {
    //merge two sorted arrays
    public static int[] mergeArrays(int[]arr1, int[]arr2){
       int i =0;
       int j =0;
       int k =0;
       int n = arr1.length;
       int m = arr2.length;
       int[] result = new int[n+m];
       while(i<n && j<m){
        if(arr1[i]<arr2[j]){
            result[k++]= arr1[i++];
        }else{
            result[k++]= arr2[j++];
        }
       }
       while(i<n){
        result[k++]=arr1[i++];
       }
       while(j<m){
        result[k++]=arr2[j++];
       }
       return result;
    }
    public static void main(String[] args){
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {2,4,6,8};
        int[] merged = mergeArrays(arr1 , arr2);
        System.out.println(Arrays.toString(merged));
    }
}
