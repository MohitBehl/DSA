package leetcode.questions.leetcode977_squaresOfASortedArray;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int res[] = new int[nums.length];
        int p1 = 0 , p2 = nums.length-1;
        int idx = res.length-1;
        while(p1 <= p2){
            int sv = nums[p1] * nums[p1];
            int ev = nums[p2] * nums[p2];
            
            if(sv >= ev){
                res[idx] = sv;
                idx--;
                p1++;
            }else{
                res[idx] = ev;
                idx--;
                p2--;
            }
        }
        return res;
    }
}