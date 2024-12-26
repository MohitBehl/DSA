package TopicWise.Heap;

import Misc.Helper;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int vl : nums){
            pq.add(vl);
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(pq.size() > 1){
            pq.poll();
        }
        return pq.peek();
    }


    public static int[] nearlySorted(int[] array, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for(int i = 0 ; i < array.length ; i++){
            pq.add(array[i]);
            if(pq.size() == k+1){
                array[idx++] = pq.remove();
            }
        }
        while(!pq.isEmpty()){
            array[idx++] = pq.remove();
        }
        return array;
    }



    class MedianFinder {
        PriorityQueue<Integer> left; // maxPQ
        PriorityQueue<Integer> right; // minPQ
        public MedianFinder() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(right.size() > 0 && num > right.peek()){
                right.add(num);
            }else{
                left.add(num);
            }

            if(right.size() > left.size() + 1){
                left.add(right.poll());
            }else if(left.size() > right.size() + 1){
                right.add(left.poll());
            }
        }

        public double findMedian() {
            if(left.isEmpty() && right.isEmpty()){
                return -1;
            }
            if(left.size() == right.size()){
                return (left.peek() + right.peek())/2.0;
            }else if(left.size() > right.size()){
                return left.peek();
            }else{
                return right.peek();
            }
        }
    }

    private static class MergeKSortedArraysPair{
        int lidx,aidx;
        MergeKSortedArraysPair(int lidx){
            this.lidx = lidx;
        }

    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
    {
        PriorityQueue<MergeKSortedArraysPair> pq = new PriorityQueue<>((a,b)->{
            return kArrays.get(a.lidx).get(a.aidx) - kArrays.get(b.lidx).get(b.aidx);
        });

        ArrayList<Integer> res  = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            pq.add(new MergeKSortedArraysPair(i));
        }

        while(!pq.isEmpty()){
            MergeKSortedArraysPair pair = pq.remove();
            ArrayList<Integer> list = kArrays.get(pair.lidx);
            res.add(list.get(pair.aidx++));

            if(pair.aidx < list.size()){
                pq.add(pair);
            }
        }
        return res;
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int vl:stones){
            pq.add(vl);
        }

        while(pq.size() > 1){
            int fHeaviest = pq.remove(),sHeaviest = pq.remove();
            int diff = fHeaviest - sHeaviest;
            if(diff != 0)
                pq.add(fHeaviest-sHeaviest);
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.remove();
    }

    public static long minimumCostToConnectSticks(ArrayList<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(arr);
        int cost = 0;
        while(pq.size() > 1){
           int nlen = pq.remove() + pq.remove();
           cost += nlen;
           pq.add(nlen);
        }
        return cost;
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int vl : nums){
            map.put(vl,map.getOrDefault(vl,0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        for(int uvl : map.keySet()){
            pq.add(uvl);
            if(pq.size() > k) pq.remove();
        }
        return new ArrayList<Integer>(pq).stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Main o = new Main();
        int ans[] = o.nearlySorted(Helper.convertStringOfNumbersToArray("10 9 8 7 4 70 60 50"), 8, 4);
//        int ans[] = o.nearlySorted(Helper.convertStringOfNumbersToArray("6 5 3 2 8 10 9"), 7, 3);
        System.out.println(Arrays.toString(ans));
    }
}