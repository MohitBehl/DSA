package leetcode.questions.leetcode189_rotateArray;

class Solution {
    public void reverse(int nums[],int left,int right){        
        while(left <= right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k < 0){
            k = k + nums.length;
        }
        
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
}