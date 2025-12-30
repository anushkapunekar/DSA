
import java.util.Stack;

public class NextGreaterElement {
public static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            
            //  Pop elements smaller than current
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            //Assign NGE
            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            // Push current element to stack
            st.push(arr[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = findNGE(arr);
        for (int x : result) System.out.print(x + " "); 
        // Output: 5 10 10 -1 -1
    }
}