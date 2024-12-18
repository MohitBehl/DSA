class Solution {
    public int firstUniqChar(String s) {
        int charFreq[] = new int[26];
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            charFreq[ch-'a']++;
        }
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(charFreq[ch-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}