package TopicWise.HashMap.Questions.LargestSubArrayWithZeroSum;

import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		int len = 0;
		int sum = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0,-1);
		for(int i = 0 ; i < arr.length ; i++){
			int vl = arr[i];
			sum += vl;
			if(map.containsKey(sum)){
				int j = map.get(sum);
				len = Math.max(len,i-j);
			}else{
				map.put(sum,i);
			}
		}

		return len;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
