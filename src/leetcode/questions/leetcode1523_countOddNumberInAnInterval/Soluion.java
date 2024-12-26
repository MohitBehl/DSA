package leetcode.questions.leetcode1523_countOddNumberInAnInterval;

class Solution {
    public int countOdds(int low, int high) {
        int count = (high-low)+1;
        
        if(low % 2 != 0){
            return (count+1)/2;
        }else{
            return count/2;
        }
    }
}