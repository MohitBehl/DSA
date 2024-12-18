/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1 , right = n;
            int badVersion = n;
            while(left <= right){
                int mid = left + (right - left)/2;
                boolean flag = isBadVersion(mid);
                
                if(flag == false){
                    left = mid+1;
                }else{
                    right = mid-1;
                    badVersion = mid;
                }
            }
            return badVersion;
        }
    }