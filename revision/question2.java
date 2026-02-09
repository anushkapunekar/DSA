package revision;
import java.util.*;
public class question2 {
    //reverse an array
    public static void reverseArray(int[] arr){
     
        int left = 0;
        int right =arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(arr));
        
    }
    public static void main(String[] args){
        int[] arr = {1,3,4,5,6};
        reverseArray(arr);
    }
}
