import java.util.Scanner;
public class Main{
    public static int fib_rec(int n){
        if(n == 0 || n == 1){
            return n;
        }

        return fib_rec(n-1)+fib_rec(n-2);
    }
    public static int fib_mem(int n,int []dp){
        if(n == 0 || n == 1){
            return dp[n] = n;
        }
        
        if(dp[n] != 0){
            return dp[n];
        }

        int ans = fib_mem(n-1,dp) + fib_mem(n-2,dp);
        return dp[n] = ans;
    }
    public static int fib_tab(int n){
        int dp[] = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            if(i == 0 || i == 1){
                dp[i] = i;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    public static int fib_tabOpti(int n){
        int first = 0 , second = 1;
        for(int i = 2 ; i <= n ; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(fib_rec(n));
        System.out.println(fib_mem(n,new int[n+1]));
        System.out.println(fib_tab(n));
        System.out.println(fib_tabOpti(n));
    }
}