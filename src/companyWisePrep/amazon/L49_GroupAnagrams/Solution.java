package companyWisePrep.amazon.L49_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedString = String.valueOf(arr);
            ArrayList<String> list = map.get(sortedString);
            if(list == null){
                list = new ArrayList<>();
                list.add(s);
                map.put(sortedString,list);
            }else{
                list.add(s);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}