package revision;
import java.util.*;
public class question5 {
    //remove duplicates
    // public static void removeDuplicates(int[] arr){
    //     Set<Integer> set = new HashSet<>();
    //     for(int n : arr){
    //         set.add(n);
    //     }
    //     int i =0;
    //     for(int n :arr){
    //         arr[i++] = n;
    //     }
    //     System.out.println(Arrays.toString(Arrays.copyOf(arr, i)));
    // }
    public static int removeDup(int[] arr){
        if(arr.length == 0) return 0;
        int i =0 ;
        for(int j=1;j<arr.length;j++){
            if(arr[j]!=arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        int uniqueCount = removeDup(arr);
        
        System.out.println("Number of unique elements: " + uniqueCount);
        
        
        System.out.print("Array after removing duplicates: ");
        for (int k = 0; k < uniqueCount; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}
