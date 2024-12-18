import java.util.*;
class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1 ; i < nums.length ; i++){
            int sum = nums[i] + nums[i-1];
            if(set.contains(sum)) return true;
            else set.add(sum);
        }
        return false;
    }
}
public class Main {


    // FOR TESTING ON LOCAL MACHINE
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.findSubarrays(input1dArray(5)));
        System.out.println(obj.findSubarrays(input1dArray(6)));        
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