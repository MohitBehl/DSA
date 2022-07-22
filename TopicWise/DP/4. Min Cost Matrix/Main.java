import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt() , nc = scn.nextInt();
        int cost[][] = new int[nr][nc];
        for(int r = 0 ; r< nr ; r++){
            for(int c = 0 ; c < nc ; c++){
                cost[r][c] =scn.nextInt();
            }
        }

        System.out.println(minCost_rec(0,0,cost));

        int mem[][] = new int[nr][nc];
        initialize(mem,-1);
        System.out.println(minCost_mem(0,0,cost,mem));

        System.out.println(minCost_tab(cost));
        
        System.out.println(minCost_optiTab(cost));
    }
    public static void initialize(int mat[][] , int val){
        for(int r = 0 ; r < mat.length ; r++){
            for(int c = 0 ; c < mat[0].length ; c++){
                mat[r][c] = val;
            }
        }
    }
    // @mohitbehl @aggressify
    public static int minCost_rec(int r,int c,int cost[][]){
        if(r == cost.length-1 && c == cost[0].length-1){ // reached dest
            return cost[r][c]; // return cost of visiting dest
        }

        int min = Integer.MAX_VALUE;
        if(c+1 < cost[0].length){ // check for horizontal movement
            min = Math.min(min,minCost_rec(r,c+1,cost));
        }

        if(r+1 < cost.length){ // check for vertical movement
            min = Math.min(min,minCost_rec(r+1,c,cost));
        }

        return min + cost[r][c];
    }

    // @mohitbehl @aggressify
    public static int minCost_mem(int r,int c,int cost[][],int mem[][]){
        if(r == cost.length-1 && c == cost[0].length-1){ // reached dest
            return cost[r][c]; // return cost of visiting dest
        }

        if(mem[r][c] != -1){ // check for already calculated minCost
            return mem[r][c]; // return already calculated minCost
        }

        int min = Integer.MAX_VALUE;
        if(c+1 < cost[0].length){ // check for horizontal movement
            min = Math.min(min,minCost_mem(r,c+1,cost,mem));
        }

        if(r+1 < cost.length){ // check for vertical movement
            min = Math.min(min,minCost_mem(r+1,c,cost,mem));
        }

        return mem[r][c] = min + cost[r][c]; // store the calculated result
    }

    // @mohitbehl @aggressify
    public static int minCost_tab(int cost[][]){
        int nr = cost.length , nc = cost[0].length;
        int mem[][] = new int[nr][nc];

        for(int r = nr-1 ; r >= 0 ; r--){
            for(int c = nc-1; c >= 0 ; c--){
                if(r == nr-1 && c == nc-1){ // last block, already on dest
                    mem[r][c] = cost[r][c]; // store cost of visiting block
                }else if(r == nr-1){ // last row : only horizontal movement allowed
                    mem[r][c] = mem[r][c+1] + cost[r][c];
                }else if(c == nc-1){ // last col : only vertical movement allowed
                    mem[r][c] = mem[r+1][c] + cost[r][c];
                }else{ // Min(H,V)+cost_of_visiting_current_block 
                    mem[r][c] = Math.min(mem[r][c+1],mem[r+1][c])+cost[r][c];
                }
            }
        }
        return mem[0][0]; // minCost to travel from (0,0)Top-Left-Block to (nr-1,nc-1)Bottom-right-Block 
    }

    // @mohitbehl @aggressify
    public static int minCost_optiTab(int cost[][]){
        int nr = cost.length , nc = cost[0].length;
        int mem[][] = new int[2][nc];
        for(int c = nc-1 ; c >= 0 ; c--){ // fill the last row
            if(c == nc-1){ // last block, already on dest
                mem[1][c] = cost[nr-1][c]; // store cost of visiting block
            }else{ // last row : only horizontal movement allowed
                mem[1][c] = mem[1][c+1] + cost[nr-1][c];
            }
        }
        for(int r = nr-2 ; r >= 0 ; r--){
            for(int c = nc-1; c >= 0 ; c--){
                if(c == nc-1){ // last col : only vertical movement allowed
                    mem[0][c] = mem[1][c] + cost[r][c];
                }else{ // Min(H,V)+cost_of_visiting_current_block 
                    mem[0][c] = Math.min(mem[0][c+1],mem[1][c])+cost[r][c];
                }
            }

            mem[1] = mem[0];
            mem[0] = new int[nc];
        }
        return mem[1][0]; // minCost to travel from (0,0)Top-Left-Block to (nr-1,nc-1)Bottom-right-Block 
    }
}

/*
Input : 
3 3
0 1 4
4 3 6
1 2 4

Output : 
10

@mohitbehl @aggressify 
*/