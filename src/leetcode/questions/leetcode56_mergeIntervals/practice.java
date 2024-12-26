package leetcode.questions.leetcode56_mergeIntervals;

import java.util.Arrays;

public class practice {
    public static void main(String args[]){
        // ArrayList<Integer> al = new ArrayList<>();
        // al.add(10);
        // al.add(20);
        // al.add(30);
        // al.add(40);
        // al.add(50);



        // System.out.println((Arrays.toString(al.toArray(new Integer[al.size()]))));

        // int mat[][] = {{1,0},{2,2},{3,5},{1,7}};
        // ArrayList<int[]> al = new ArrayList<>();
        // for(int arr[] : mat){
        //     al.add(arr);
        // }

        // int [][]copy = al.toArray(new int[al.size()][]);
        // for(int arr[] : copy){
        //     System.out.println(Arrays.toString(arr));
        // }

            // (5,10) -> func();

        // int arr[][] = {{1,5},{0,6},{8,20},{3,4},{100,-100}};
        // Arrays.sort(arr,(a,b) -> Integer.compare(b[1],a[1]));
        // for(int a[] : arr){
        //     System.out.println(Arrays.toString(a));
        // }

        Integer arr[] = {1,5,2,6,3,7,8,19,10,6,45,24,11};
        Arrays.sort(arr,(a,b)->0);
        System.out.println(Arrays.toString(arr));
    }
}
