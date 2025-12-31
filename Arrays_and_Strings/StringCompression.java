package DSA.Arrays_and_Strings;

public class StringCompression {

    // 1. BRUTE FORCE APPROACH
    // Time: O(n) | Space: O(n) due to the StringBuilder
    public static int compressBrute(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            sb.append(currentChar);
            
            if (count > 1) {
                sb.append(count);
            }
        }

        char[] result = sb.toString().toCharArray();
        for (int j = 0; j < result.length; j++) {
            chars[j] = result[j];
        }

        return result.length;
    }

    // 2. OPTIMIZED APPROACH (IN-PLACE 2 pointers  read and write)
    // Time: O(n) | Space: O(1)
    public static int compressOptimized(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

        
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            
            chars[write++] = currentChar;

           
            if (count > 1) {
                
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        
        
        return write;
    }

    public static void main(String[] args) {
        // Test Case 1
        char[] input1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println("--- Optimized Approach ---");
        int newLength1 = compressOptimized(input1);
        System.out.println("New Length: " + newLength1);
        System.out.print("Modified Array: ");
        for (int i = 0; i < newLength1; i++) {
            System.out.print("'" + input1[i] + "' ");
        }

        // Test Case 2
        char[] input2 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println("\n\n--- Testing Large Count (12 'b's) ---");
        int newLength2 = compressOptimized(input2);
        System.out.println("New Length: " + newLength2);
        System.out.print("Modified Array: ");
        for (int i = 0; i < newLength2; i++) {
            System.out.print("'" + input2[i] + "' ");
        }
    }
}
