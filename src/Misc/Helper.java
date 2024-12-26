package Misc;

import java.util.ArrayList;

public class Helper {
    public static int[] convertStringOfNumbersToArray(String str){
        String[] sarr = str.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for(String s : sarr){
            list.add(Integer.parseInt(s));
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

}
