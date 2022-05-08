class Solution {
    public int minimumAverageDifference(int[] nums) {
        long rsum = 0 ;
        for(int vl : nums){
            rsum += vl;
        }
        long lsum = 0;
        int ans = Integer.MAX_VALUE,idx = -1;
        int n = nums.length;
        for(int i = 0 ; i < nums.length; i++){
            lsum += nums[i];
            rsum -= nums[i];
            int tmp = (n-i-1) == 0 ? 1 : (n-i-1); 
            int ldiv = (int)(lsum/(i+1));
            int rdiv = (int)(rsum/tmp);
            int avg = (int)Math.abs((int)ldiv - (int)rdiv);
            if(avg < ans){
                ans = avg;
                idx = i;
            }
        }
        return idx;
    }
}