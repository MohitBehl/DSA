import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		HashMap<String,Boolean> tmp = new HashMap<>();

		for(String src : map.keySet()){
			String dest = map.get(src);
			tmp.put(dest,false);
			if(tmp.containsKey(src)){
				boolean status = tmp.get(src);
				tmp.put(src,status && true);
			}else{
				tmp.put(src,true);
			}
		}
		String st = "";
		for(String src : tmp.keySet()){
			boolean status = tmp.get(src);
			if(status) st = src;
		}

		System.out.print(st+" -> ");
		int count = noofpairs_src_des;
		while(count != 0){
			st = map.get(st);
			System.out.print(st);
			count--;
			if(count != 0) System.out.print(" -> ");
			else System.out.println(".");
		}
	}
}
