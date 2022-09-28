class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        
        for(int vl : nums){
            sum += vl;
            // System.out.println(sum+" "+(sum-k));
            if(map.containsKey(sum-k)){
                // System.out.println("in");
                count += map.get(sum-k);
            }
            int freq = map.getOrDefault(sum,0);
            map.put(sum,freq+1);
        }
        // System.out.println(map);
        return count;
    }
}