import java.util.PriorityQueue;

// class Solution {
//     public int largestInteger(int num) {
//         StringBuilder sb = new StringBuilder(num+"");
//         // System.out.println(sb);
//         for(int i = 0 ; i < sb.length() ; i++){
//             char ch = sb.charAt(i);
//             if(ch == '0' || ch == '2' || ch == '4' || ch == '6' || ch == '8'){
//                 int max = i;
//                 for(int j = i+1 ; j < sb.length() ; j++){
//                     if((sb.charAt(j) == '0' || sb.charAt(j) == '2' || sb.charAt(j) == '4' || sb.charAt(j) == '6' || sb.charAt(j) == '8') && sb.charAt(j) > sb.charAt(max)){
//                         max = j;
//                     }
//                 }
//                 if(max != i){
//                     char ch2 = sb.charAt(max);
//                     sb.setCharAt(i, ch2);
//                     sb.setCharAt(max, ch);
//                 }
//             }else{
//                 int max = i;
//                 for(int j = i+1 ; j < sb.length() ; j++){
//                     if(!(sb.charAt(j) == '0' || sb.charAt(j) == '2' || sb.charAt(j) == '4' || sb.charAt(j) == '6' || sb.charAt(j) == '8') && sb.charAt(j) > sb.charAt(max)){
//                         max = j;
//                     }
//                 }
//                 if(max != i){
//                     char ch2 = sb.charAt(max);
//                     sb.setCharAt(i, ch2);
//                     sb.setCharAt(max, ch);
//                 }
//             }
            
//             // System.out.println(sb);
//         }

//         return Integer.parseInt(sb.toString());
//     }
// }

// class Solution {
//     public String minimizeResult(String expression) {
//         int idx = 0;
//         while(idx < expression.length()){
//             if(expression.charAt(idx) == '+'){
//                 break;
//             }
//             idx++;
//         }       
//         // System.out.println(idx);
//         int len = 1;
//         int i = idx-1 , j = 0;
//         StringBuilder sb1 = new StringBuilder(expression.substring(0,idx));
//         StringBuilder sb2 = new StringBuilder(expression.substring(idx+1));
//         // int maxLen = Math.min(sb1.length(),sb2.length());
//         StringBuilder p2 = new StringBuilder("");
//         StringBuilder p3 = new StringBuilder("");
//         ArrayList<int[]> left = new ArrayList<>();
//         ArrayList<int[]> right = new ArrayList<>();
//         while(sb1.length() != 0){
//             p2.insert(0,sb1.charAt(i));
//             sb1.deleteCharAt(i--);
//             int n1 = sb1.toString() == "" ? 0 : Integer.parseInt(sb1.toString());
//             int n2 = Integer.parseInt(p2.toString());
//             left.add(new int[]{n1,n2});
//         }
//         while(sb2.length() != 0){
//             p3.append(sb2.charAt(j));
//             sb2.deleteCharAt(j);
//             int n3 = Integer.parseInt(p3.toString());            
//             int n4 = sb2.toString() == "" ? 0 : Integer.parseInt(sb2.toString());
//             right.add(new int[]{n3,n4});
//         }
//         StringBuilder res = new StringBuilder();
//         int min = Integer.MAX_VALUE;
//         for(int[] pair1 : left){
//             for(int[] pair2 : right){
//                 int n1 = pair1[0] , n2 = pair1[1];
//                 int n3 = pair2[0] , n4 = pair2[1];
//                 int ans = n2 + n3;
//                 ans = (n1 != 0) ? (n1 * ans) : ans;
//                 ans = (n4 != 0) ? (n4 * ans) : ans;
//                 // System.out.println(ans);
                
//                 // System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+ans);
//                 if(ans < min){
//                     res = new StringBuilder();
//                     if(n1 != 0) res.append(n1);
//                     res.append("(");
//                     res.append(n2);
//                     res.append("+");
//                     res.append(n3);
//                     res.append(")");
//                     if(n4 != 0) res.append(n4);
//                     min = ans;
//                 }
//             }
//         }
//         return res.toString();
//     }
// }

class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int vl : nums){
            pq.add(vl);
        }
        
        while(k-- > 0){
            int vl = pq.remove();
            pq.add(vl+1);
        }
        int mod = 1000_000_000+7;
        int ans = 1;
        while(pq.size() > 0){
            ans = (ans * pq.remove());
        }

        return ans%mod;
    }
}