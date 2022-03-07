import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        // fibonacci();
        sample();
    }
    public static void fibonacci(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // int res = fibonacci_rec(n);
        int dp[] = new int[n+1];
        // int res = fibonacci_memoization(n,dp);
        int res = fibonacci_tabulation(n,dp);
        
        System.out.println(res);
    }
    public static int fibonacci_rec(int n){
        if(n <= 1){
            return n;
        }

        int res = fibonacci_rec(n-1) + fibonacci_rec(n-2);

        return res;
    }

    public static int fibonacci_memoization(int n,int dp[]){
        if(n <= 1){
            return dp[n] = n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int res = fibonacci_memoization(n-1,dp)+fibonacci_memoization(n-2,dp);
        return dp[n] = res;
    }

    public static int fibonacci_tabulation(int N,int dp[]){
        for(int n = 0 ; n <= N ; n++){
            if(n <= 1){
                dp[n] = n;
                continue;
            }
            int res = dp[n-1]+dp[n-2];//fibonacci_memoization(n-1,dp)+fibonacci_memoization(n-2,dp);
            dp[n] = res;
        }
        
        return dp[N];
    }

    static void sample(){
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addFirst(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.node(1);
    }
    
}
