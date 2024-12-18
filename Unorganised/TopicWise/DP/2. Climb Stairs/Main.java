import java.util.Scanner;
public class Main{
    public static int climbStairs_rec(int n){
        if(n == 0){
            return 1;
        }
        int ans = 0;
        if(n >= 1){
            ans += climbStairs_rec(n-1);
        }
        if(n >= 2){
            ans += climbStairs_rec(n-2);
        }
        if(n >= 3){
            ans += climbStairs_rec(n-3);
        }
        return ans;
    }
    public static int climbStairs_mem(int n,int mem[]){
        if(n == 0){
            return mem[0] = 1;
        }
        if(mem[n] != 0){
            return mem[n];
        }
        int ans = 0;
        if(n >= 1){
            ans += climbStairs_rec(n-1);
        }
        if(n >= 2){
            ans += climbStairs_rec(n-2);
        }
        if(n >= 3){
            ans += climbStairs_rec(n-3);
        }
        return mem[n] = ans;
    }
    public static int climbStairs_tab(int n){
        int mem[] = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            if(i == 0 || i == 1) mem[i] = 1;
            else if(i == 2) mem[i] = 2;
            else mem[i] = mem[i-1] + mem[i-2] + mem[i-3]; 
        }
        return mem[n];
    }
    public static int climbStairs_tabOpti(int n){
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        int first = 1 , second = 1, third = 2;
        for(int i = 3 ; i <= n ; i++){
            int fourth = first + second + third;
            first = second;
            second = third;
            third = fourth;
        }
        return third;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(climbStairs_rec(n));
        System.out.println(climbStairs_mem(n,new int[n+1]));
        System.out.println(climbStairs_tab(n));
        System.out.println(climbStairs_tabOpti(n));
    }
}