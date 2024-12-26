package leetcode.questions.leetcode1491_averageSalaryExcludingMinAndMax;

public class Solution {
    public double average(int[] salary) {
        int sum = 0 , min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        for(int vl : salary){
            max = Math.max(max,vl);
            min = Math.min(min,vl);
            sum += vl;
        }
        
        sum -= max;
        sum -= min;
        
        double ans = (double)sum / (salary.length-2);
        return ans;
    }
}
