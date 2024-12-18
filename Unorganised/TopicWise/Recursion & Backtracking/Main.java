import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int nr = 9;
        int nc = 9;
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++)
            for(int j = 0 ; j < nc ; j++)
                mat[i][j] = scn.nextInt();

        boolean res = isValidSudoku(mat);
        System.out.println(res);
        solveSudoku(mat, 0, 0);
    }
    public static boolean isValidSudoku(int mat[][]){
        // implementation
        // row wise
        for(int r = 0 ; r < 9 ; r++){
            boolean vis[] = new boolean[10];
            for(int c = 0 ; c < 9 ; c++){
                int vl  = mat[r][c];
                if(vl < 1 || vl > 9 || vis[vl]) return false;
                vis[vl] = true;
            }
        }
        // col wise
        for(int c = 0 ; c < 9 ; c++){
            boolean vis[] = new boolean[10];
            for(int r = 0 ; r < 9 ; r++){
                int vl  = mat[r][c];
                if(vl < 1 || vl > 9 || vis[vl]) return false;
                vis[vl] = true;
            }
        }

        // block
        for(int block = 0 ; block < 9 ; block++){
            int sr = (block/3)*3 , sc = (block%3)*3;
            boolean vis[] = new boolean[10];
            for(int  i = 0 ; i < 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                    int vl = mat[sr+i][sc+j];
                    if(vl < 1 || vl > 9 || vis[vl]) return false;
                    vis[vl] = true;
                }
            }
        }

        return true;
    }

    public static boolean isValid(int [][]mat,int r, int c, int num){
        // implementation
        // row wise
            for(int j = 0 ; j < 9 ; j++){
                int vl  = mat[r][j];
                if(vl == num) return false;
            }
        // col wise
            for(int i = 0 ; i < 9 ; i++){
                int vl  = mat[i][c];
                if(vl == num) return false;
            }

        // block
        int sr = (r/3)*3 , sc = (c/3)*3;
        for(int  i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                int vl = mat[i+sr][j+sc];
                if(vl == num) return false;
            }
        }

        return true;
    }
    // board : 9x9
    public static void solveSudoku(int[][] board, int r, int c) {
        if(r == 9){
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++){
                    System.out.print(board[i][j]+" ");      
                }
                System.out.println();
            }
            System.out.println(isValidSudoku(board));
            return;
        }
        int nr = 0 , nc = 0;
        if(c == 8){
            nr = r+1;
            nc = 0;
        }else{
            nr = r;
            nc = c+1;
        }
        int vl = board[r][c];
        if(vl != 0){
            // directly move to next coordinate
            solveSudoku(board,nr,nc);
        }else{
            for(int num = 1 ; num <= 9 ; num++){
                if(isValid(board,r,c,num)){
                    board[r][c] = num;
                    solveSudoku(board,nr,nc);    
                    board[r][c] = 0;
                }
            }
        }
    }
    
}
/*
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
*/