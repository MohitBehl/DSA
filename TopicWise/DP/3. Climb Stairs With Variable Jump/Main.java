import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int moves[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            moves[i] = scn.nextInt();
        }

        // System.out.println(climbStairsVarJump_rec(0,n,moves));
        int mem[] = new int[n+1];
        Arrays.fill(mem,-1);
        System.out.println(climbStairsVarJump_mem(0,n,moves,mem));
        System.out.println(climbStairsVarJump_tab(moves));
    }
    public static int climbStairsVarJump_rec(int currStep,int totalStep,int moves[]){
        if(currStep == totalStep){
            return 1;
        }
        int maxJump = moves[currStep];
        int ans = 0;
        for(int step = 1 ; step <= maxJump ; step++){
            if(currStep + step <= totalStep){
                ans += climbStairsVarJump_rec(currStep + step,totalStep,moves);
            }
        }
        return ans;
    }
    public static int climbStairsVarJump_mem(int currStep,int totalStep,int moves[],int mem[]){
        if(currStep == totalStep){
            return mem[currStep] = 1;
        }
        if(mem[currStep] != -1){
            return mem[currStep];
        }
        int maxJump = moves[currStep];
        int ans = 0;
        for(int step = 1 ; step <= maxJump ; step++){
            if(currStep + step <= totalStep){
                ans += climbStairsVarJump_mem(currStep + step,totalStep,moves,mem);
            }
        }
        return mem[currStep] = ans;
    }

    public static int climbStairsVarJump_tab(int moves[]){
        int n = moves.length;
        int mem[] = new int[n+1];

        for(int stair = n ; stair >= 0 ; stair--){
            if(stair == n){
                // number of ways @ nth stair is 1
                mem[stair] = 1;
                continue;
            }
            int maxMovement = moves[stair];
            int ways = 0;
            for(int jmpLen = 1 ; jmpLen <= maxMovement ; jmpLen++){
                int nextStair = jmpLen + stair; // stair after moving
                if(nextStair <= n){ // next stair should be within range
                    ways += mem[nextStair]; 
                }else{ // if next stair is not in range , then no need to traverse further
                    break;
                }
            }
            mem[stair] = ways; //  store number of ways to climb from curr-stair to nth-stair         
        }

        return mem[0]; // number of ways to climb from 0th-stair to nth-stair
    }

}

/*
Input : 
10
3
3
0
2
1
2
4
2
0
0

Output :
5
*/