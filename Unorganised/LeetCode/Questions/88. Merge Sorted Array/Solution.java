class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1 , p2 = n-1;
        int idx = nums1.length-1;
        while(p1 >= 0 || p2 >= 0){
            int v1 = (p1 >= 0) ? nums1[p1] : Integer.MIN_VALUE;
            int v2 = (p2 >= 0) ? nums2[p2] : Integer.MIN_VALUE;
            if(v1 <= v2){
                nums1[idx] = v2;
                idx--;
                p2--;
            }else{
                nums1[idx] = v1;
                idx--;
                p1--;
            }
        }
    }
}