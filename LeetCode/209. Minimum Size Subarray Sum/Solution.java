import java.util.Scanner;

class Solution {
    // Brute Force : O(n^3)
    public int minSubArrayLen1(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        for(int sp = 0 ; sp < nums.length ; sp++){
            for(int ep = sp ; ep < nums.length ; ep++){

                int tmp = sp , sum = 0;
                while(tmp <= ep){
                    sum += nums[tmp];
                    tmp++;
                }

                int currLen = (ep-sp+1);
                if(sum >= target &&  currLen < minLen){
                    minLen = currLen;
                }
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        for(int sp = 0 ; sp < nums.length ; sp++){
            for(int ep = sp ; ep < nums.length ; ep++){

                int tmp = sp , sum = 0;
                while(tmp <= ep){
                    sum += nums[tmp];
                    tmp++;
                }

                int currLen = (ep-sp+1);
                if(sum >= target &&  currLen < minLen){
                    minLen = currLen;
                }
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    private static void driver(int target,int nums[]){
        int len = new Solution().minSubArrayLen1(target,nums);
        System.out.println(len);
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nums[] = new int[n];
        for(int i = - 0 ; i < n ; i++){
            nums[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        
        driver(target,nums);
        scn.close();
    }
}