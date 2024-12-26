package TopicWise.HashMap.Questions.CheckIfArrayPairsDivisibleByk;

import java.util.HashMap;

class Main {
    public boolean canArrange(int[] arr, int k) {
        if(arr.length%2 == 1) return false;
        HashMap<Integer,Integer> freq = new HashMap<>();
		for(int vl : arr){
			int rem = vl % k;
            if(rem < 0) rem += k;
			freq.put(rem,freq.getOrDefault(rem,0)+1);
		}
		for(int rem : freq.keySet()){
			if(rem == 0 ){
				if(freq.get(rem)%2 == 1)
                {
                    return false;
                }
			}else if(rem*2 == k){
				if(freq.get(rem)%2==1)
                {   
                    return false;
                }
			}
			else{
                Integer tmp = freq.get(k-rem);
                if(tmp == null || freq.get(rem).equals(tmp) == false){
                    return false;
                }  
            } 
		}
        return true;
    }
}