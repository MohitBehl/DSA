import java.util.*;
class Solution {
    public int maximumRows(int[][] mat, int cols) {
        int fcols[] = new int[mat[0].length];
        int frows[] = new int[mat.length];

        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 1){
                    frows[i]++;
                    fcols[j]++;
                }
            }
        }


        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int vl : fcols){
            maxPQ.add(vl);
        }
        int total = 0;
        while(cols-- != 0){
            total += maxPQ.remove();
        }

        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for(int vl : frows){
            minPQ.add(vl);
        }

        int count = 0;
        while(minPQ.size() > 0 && total >= minPQ.peek()){
            count++;
            total -= minPQ.remove();
        }

        return count;
    }
}
public class Main {


    // FOR TESTING ON LOCAL MACHINE
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Solution obj = new Solution();        
    }

    // input function
    public static int[] input1dArray(int n){
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}