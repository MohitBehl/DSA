import java.util.*;
class Solution{

}
public class Main {


    // FOR TESTING ON LOCAL MACHINE
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Solution obj = new Solution();        
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