package TopicWise.Stacks;

import java.io.*;
import java.util.*;

class NGER{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   int ans[] = new int[arr.length];
   Stack<Integer> st = new Stack<>();

   for(int idx = arr.length-1 ; idx >= 0 ; idx--){
    if(idx == arr.length-1){
        ans[idx] = -1;
        st.push(arr[idx]);
    }else{
        while(st.size() > 0 && st.peek() < arr[idx]){
            st.pop();
        }       

        if(st.size() == 0){
            ans[idx] = -1;
        }else{
            ans[idx] = st.peek();
        }

        st.push(arr[idx]);
    }
   }
   return ans;
 }

}