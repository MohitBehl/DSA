import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		int sum = 0;
		int count = 0 ;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0,1);
		for(int vl : arr){
			sum += vl;
			int freq = 0;
			if(map.containsKey(sum)) freq = map.get(sum);
			count += freq;
			map.put(sum,freq+1);
		}

		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}

}
