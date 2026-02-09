package revision;
import java.util.*;
public class question4 {
    //move  all zeroes to end
    public static void moveZeroes(int[] arr){
        int j = 0; 
        for(int i =0 ; i<arr.length;i++){
            if(arr[i]!=0){
              int temp =arr[i];
              arr[i]=arr[j];
              arr[j] = temp;
              j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
        int[] arr = {1,0,2,0,0,4,5};
        moveZeroes(arr);
    }
}
