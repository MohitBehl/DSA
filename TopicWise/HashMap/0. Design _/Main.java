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


public class Main{
    public static void main(String[] args) {
        CustomHashMap hm = new CustomHashMap();
    
        hm.put("india",200);
        hm.put("Usa",20);
        hm.put("india123",200213);
        hm.put("in312412dia",2004132421);
    
        System.out.println(hm.keySet());
        hm.remove("india");
        System.out.println(hm.keySet());

        System.out.println(hm.get("Usa"));
        System.out.println(hm.get("USA1"));

        System.out.println(hm.containsKey("Usa"));
        System.out.println(hm.containsKey("USA1"));
    }
}