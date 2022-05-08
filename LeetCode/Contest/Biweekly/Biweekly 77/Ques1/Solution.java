class Solution {
    private boolean checkPrefix(String str,String s){
        if(str.length() > s.length()){
            return false;
        }
        int idx = 0 ;
        for(idx = 0 ; idx < str.length() ; idx++){
            if(str.charAt(idx) != s.charAt(idx)){
                break;
            }
        }
        return idx == str.length();
    }
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for(String str : words){
            if(checkPrefix(str, s)){
                count++;
            }
        }
        return count;
    }
}