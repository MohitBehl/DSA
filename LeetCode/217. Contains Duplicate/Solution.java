class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int vl : nums){
            if(set.contains(vl)){
                return true;
            }
            set.add(vl);
        }
        
        return false;
    }
}