import java.util.*;
class Solution {
    public static String baseConversion(String number, int sBase, int dBase)
    {
        return Integer.toString(
            Integer.parseInt(number, sBase), dBase);
    }
    public boolean isStrictlyPalindromic(int n) {
        for(int base = 2 ; base <= n-2 ; base++){
            String s = baseConversion(n+"", 10, base);
            StringBuilder str = new StringBuilder(s);
            StringBuilder strRev = new StringBuilder(s);
            System.out.println(str+" "+strRev.reverse());
            if(!str.equals(strRev.reverse())){
                return false;
            }
        }
        return true;
    }
}
public class Main {


    // FOR TESTING ON LOCAL MACHINE
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Solution obj = new Solution();    
        // System.out.println(obj.isStrictlyPalindromic(9));
        System.out.println(obj.isStrictlyPalindromic(4));    
    }

    // input function
    public static int[] input1dArray(int n){
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}