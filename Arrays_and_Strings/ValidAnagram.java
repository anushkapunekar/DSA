package DSA.Arrays_and_Strings;

import java.util.Arrays;

public class ValidAnagram {
   /* BRUTE FORCE: sorting
    public static boolean isAnagram(String s , String t){
        if(s.length()!= t.length()){
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray =t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        
        String s2 = "rat";
        String t2 = "car";
        
        System.out.println(isAnagram(s, t)); //true
        System.out.println(isAnagram(s2, t2)); //false
   }
        //TC=O(nlogn);
        //SC=o(n);
        */
    
        //OPTIMAL frequency array
        public static boolean isAnagram(String s, String t){
            if(s.length() != t.length()){
                return false;
            }
            int[] counter = new int[26];
            for(int i =0; i<s.length(); i++){
                counter[s.charAt(i)- 'a']++;
                counter[t.charAt(i)-'a']--;
            }
            for (int count: counter){
                if(count!=0){
                    return false;
                }
            }
            return true;
        }
         public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        
        String s2 = "rat";
        String t2 = "car";
        
        System.out.println(isAnagram(s, t)); //true
        System.out.println(isAnagram(s2, t2)); //false
        //TC=O(N);
        //SC=o(1); becz the arry size 26 never changes
   }
}
