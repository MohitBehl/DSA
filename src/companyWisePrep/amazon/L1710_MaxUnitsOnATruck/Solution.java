package companyWisePrep.amazon.L1710_MaxUnitsOnATruck;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-units-on-a-truck/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a, b) -> {return b[1]-a[1];});
        int idx = 0;
        int res = 0;
        
        while(truckSize > 0 && idx < boxTypes.length){
            int nboxes = boxTypes[idx][0];
            int units = boxTypes[idx][1];
            
            int qty = Math.min(truckSize,nboxes);
            truckSize -= qty;
            res += qty * units;
            idx++;
        }
        return res;
    }
}
