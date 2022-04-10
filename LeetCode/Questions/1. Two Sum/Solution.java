// using hashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],i);
        }
        int res[] = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            int compVal = target-nums[i];
            if(map.containsKey(compVal)){
                if(compVal == nums[i] && map.get(compVal) == i){
                    continue;
                }
                res[0] = i;
                res[1] = map.get(compVal);
            }
        }
        return res;
    }
}
