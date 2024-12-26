package TopicWise.HashMap.design;

import java.util.*;
class CustomHashMap{
    private static class HMNode{
        String key;
        int val;

        HMNode(String k , int v){
            key = k;
            val = v;
        }
    }

    LinkedList<HMNode> buckets[];
    int size = 0;
    CustomHashMap(){
        buckets = new LinkedList[4];
        resetBuckets();
    }

    private void resetBuckets(){
        for(int i = 0 ; i < buckets.length ; i++){
            buckets[i] = new LinkedList<>();
        }
    }
    private int hashFunc(String key){ 
        // returns bucket number
        int hcode = key.hashCode();
        hcode = Math.abs(hcode);
        int bi = hcode % buckets.length;
        return bi;
    }
    private HMNode findEleInBucket(int bi , String key){
        for(HMNode node : buckets[bi]){
            if(node.key.equals(key)){
                return node;
            }
        }

        return null;
    }
    public void put(String key,int val){
        // insert or update
        int bi = hashFunc(key);

        HMNode rnode = findEleInBucket(bi,key);

        if(rnode == null){
            // insert
            HMNode nnode = new HMNode(key,val);
            buckets[bi].addLast(nnode);
            size++;
        }else{
            // update
            rnode.val = val;
        }

        double lambda = (size * 1.0) / buckets.length;

        if(lambda > 2){
            // rehash
            size = 0;
            LinkedList<HMNode> oldBuckets[] = buckets;
            buckets = new LinkedList[buckets.length*2];
            resetBuckets();
            for(LinkedList<HMNode> ll : oldBuckets){
                for(HMNode node : ll){
                    put(node.key,node.val);
                }
            }
        }
    }     

    public boolean containsKey(String key){
        // true or false
        int bi = hashFunc(key);

        HMNode rnode = findEleInBucket(bi,key);

        if(rnode == null){
            return false;
        }else{
            return true;
        }
    }

    public Integer get(String key){
        // value or null
        int bi = hashFunc(key);

        HMNode rnode = findEleInBucket(bi,key);

        if(rnode == null){
            return null;
        }else{
            return rnode.val;
        }
    }

    public void remove(String key){
        /// remove
        int bi = hashFunc(key);

        HMNode rnode = findEleInBucket(bi,key);

        if(rnode == null){
            return;
        }else{
            buckets[bi].remove(rnode);
            size--;
        }
    }

    public ArrayList<String> keySet(){
        // all keys
        ArrayList<String> keys = new ArrayList<>();
        for(LinkedList<HMNode> ll : buckets){
            for(HMNode node : ll){
                keys.add(node.key);
            }
        }
        return keys;
    }
}


class Heap{
    ArrayList<Integer> data;

    Heap(){
        data = new ArrayList<>();
    }

    private void upheapify(int idx){ // recursive
        if(idx == 0) return;
        int pidx = (idx-1) / 2;

        if(data.get(idx) < data.get(pidx)){
            // current ele has higher priority than par
            // swap
            swap(idx,pidx);
            upheapify(pidx);
        }
    }

    private void downheapify(int idx){ // recursive
        int lidx = (2 * idx) + 1;
        int ridx = (2 * idx) + 2;

        int min = idx;
        if(lidx < data.size() && data.get(lidx) < data.get(min)){ // lval exists
            min = lidx;
        }
        if(ridx < data.size() && data.get(ridx) < data.get(min)){ // rval exists
            min = ridx;
        }

        if(min != idx){
            swap(idx,min);
            downheapify(min);
        }
    }

    private void swap(int idx1,int idx2){
        int v1 = data.get(idx1);
        int v2 = data.get(idx2);

        data.set(idx1, v2);
        data.set(idx2, v1);
    }

    public void add(int vl){
        data.add(vl);
        upheapify(data.size()-1);
    }

    public int remove(){
        if(data.size() == 0){
            return -1;
        }
        int vl = data.get(0);
        swap(0,data.size()-1);
        data.remove(data.size()-1);
        downheapify(0);

        return vl;
    }

    public int min(){

        if(data.size() == 0){
            return -1;
        }

        return data.get(0);
    }

}

public class Main{
    public static void main(String[] args) {
        // CustomHashMap hm = new CustomHashMap();
    
        // hm.put("india",200);
        // hm.put("Usa",20);
        // hm.put("india123",200213);
        // hm.put("in312412dia",2004132421);
    
        // System.out.println(hm.keySet());
        // hm.remove("india");
        // System.out.println(hm.keySet());

        // System.out.println(hm.get("Usa"));
        // System.out.println(hm.get("USA1"));

        // System.out.println(hm.containsKey("Usa"));
        // System.out.println(hm.containsKey("USA1"));

        Heap pq = new Heap();

        pq.add(30);
        System.out.println(pq.data+"->"+pq.min());
        pq.add(10);
        System.out.println(pq.data+"->"+pq.min());
        pq.add(6);
        System.out.println(pq.data+"->"+pq.min());
        pq.add(100);
        System.out.println(pq.data+"->"+pq.min());
        pq.add(3);
        System.out.println(pq.data+"->"+pq.min());
        pq.remove();
        System.out.println(pq.data+"->"+pq.min());
    }
}