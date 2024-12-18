import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt() , nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        for(int r = 0 ; r< nr ; r++){
            for(int c = 0 ; c < nc ; c++){
                mat[r][c] =scn.nextInt();
            }
        }

        // System.out.println(goldMine(mat));
        // System.out.println(goldMine_tab(mat));
        System.out.println(goldMine_optiTab(mat));
    }
    public static void initialize(int mat[][] , int val){
        for(int r = 0 ; r < mat.length ; r++){
            for(int c = 0 ; c < mat[0].length ; c++){
                mat[r][c] = val;
            }
        }
    }
    // @mohitbehl @aggressify
    public static int goldMine(int mat[][]){
        int ans = 0;
        int mem[][] = new int[mat.length][mat[0].length];
        initialize(mem,-1);
        for(int r = 0 , c = 0 ; r < mat.length ; r++){
            // ans = Math.max(ans,goldMine_rec(r,c,mat));
            ans = Math.max(ans,goldMine_mem(r,c,mat,mem));
        }
        return ans;
    }
    // @mohitbehl @aggressify
    public static int goldMine_rec(int r,int c,int mat[][]){
        if(c == mat[0].length-1){
            return mat[r][c];
        }
        int max = Integer.MIN_VALUE;
        if(r-1 >= 0){
            max = Math.max(max,goldMine_rec(r-1,c+1,mat));
        }
        max = Math.max(max,goldMine_rec(r,c+1,mat));
        if(r+1 < mat.length){
            max = Math.max(max,goldMine_rec(r+1,c+1,mat));
        }

        return max + mat[r][c];
    }
    // @mohitbehl @aggressify
    public static int goldMine_mem(int r,int c,int mat[][],int mem[][]){
        if(c == mat[0].length-1){
            return mem[r][c] = mat[r][c];
        }
        if(mem[r][c] != -1){
            return mem[r][c];
        }
        int max = Integer.MIN_VALUE;
        if(r-1 >= 0){
            max = Math.max(max,goldMine_mem(r-1,c+1,mat,mem));
        }
        max = Math.max(max,goldMine_mem(r,c+1,mat,mem));
        if(r+1 < mat.length){
            max = Math.max(max,goldMine_mem(r+1,c+1,mat,mem));
        }

        return mem[r][c] = max + mat[r][c];
    }
    // @mohitbehl @aggressify
    public static int goldMine_tab(int mat[][]){
        int nr = mat.length , nc = mat[0].length;
        int mem[][] = new int[nr][nc];
        for(int c = nc-1 ; c >= 0 ; c--){
            for(int r = nr-1 ; r >= 0 ; r--){
                if(c == nc-1){
                    mem[r][c] = mat[r][c];
                }else{
                    int max = 0;
                    if(r-1 >= 0) // d1
                        max = Math.max(max,mem[r-1][c+1]);

                    max = Math.max(max,mem[r][c+1]); // d2
                    
                    if(r+1 < mat.length) // d3
                        max = Math.max(max,mem[r+1][c+1]);

                    mem[r][c] = max + mat[r][c];
                }
            }
        }
        int ans = 0;
        for(int r = 0 , c = 0 ; r < mat.length ; r++){
            // ans = Math.max(ans,goldMine_rec(r,c,mat));
            ans = Math.max(ans,mem[r][c]);
        }
        return ans;
    }
    // @mohitbehl @aggressify
    public static int goldMine_optiTab(int mat[][]){
        int nr = mat.length , nc = mat[0].length;
        int mem[][] = new int[nr][2];
        for(int r = 0 ; r < nr ; r++){ // fill the last column
            mem[r][1] = mat[r][nc-1];
        }
        for(int c = nc-2 ; c >= 0 ; c--){
            for(int r = nr-1 ; r >= 0 ; r--){
                    int max = 0;
                    if(r-1 >= 0) // d1
                        max = Math.max(max,mem[r-1][1]);

                    max = Math.max(max,mem[r][1]); // d2
                    
                    if(r+1 < mat.length) // d3
                        max = Math.max(max,mem[r+1][1]);

                    mem[r][0] = max + mat[r][c];
            }

            for(int r = 0 ; r < nr ; r++){ // put all values of 1st col into 2nd col
                mem[r][1] = mem[r][0];
                mem[r][0] = 0;
            }
        }
        int ans = 0;
        for(int r = 0 , c = 1 ; r < mat.length ; r++){
            // ans = Math.max(ans,goldMine_rec(r,c,mat));
            ans = Math.max(ans,mem[r][c]);
        }return ans;
    }
}
/*
Input :
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

Output :
33

@mohitbehl @aggressify
*/