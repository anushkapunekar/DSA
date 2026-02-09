package revision;
import java.util.*;
public class question14 {
    //factorial
    public static long factorial(int n){
        if(n<=1)return n;
        long result = 1;
        for(int i =2;i<=n ; i++){
            result*=i;
        }
        return result;
    }
    public static void main(String[] args){
        int num = 5;
        System.out.println(factorial(num));
    }
}
