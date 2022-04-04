class Solution {
    // better impletementation
    public int countBinarySubstrings(String s) {
        int prevSize = 0 , currSize = 1;
        int ans = 0;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currSize++;
            }else{
                ans += Math.min(currSize,prevSize);
                prevSize = currSize;
                currSize = 1;
            }
        }
        ans += Math.min(currSize,prevSize);
        return ans;
    }

    // // initial implementation
    // public int countBinarySubstrings(String s) {
    //     int n0 = 0 , n1 = 0;
    //     int ans = 0;
    //     for(int i = 0 ; i < s.length() ; i++){
    //         char ch = s.charAt(i);
    //         if(i == 0){
    //             if(ch == '0') n0 = 1;
    //             else n1 = 1;
    //         }else{
    //             char prev = s.charAt(i-1);
    //             if(prev != ch){
    //                 ans += Math.min(n0,n1);
    //                 if(ch == '0') n0 = 1;
    //                 else n1 = 1;
    //             }else{
    //                 if(ch == '0') n0 += 1;
    //                 else n1 += 1;
    //             }
    //         }
    //     }
    //     ans += Math.min(n0,n1);
    //     return ans;
    // }
}