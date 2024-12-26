package leetcode.questions.leetcode59_spiralMatrix2;

class Solution {
    public int[][] generateMatrix(int n) {
        int rmin = 0  , cmin = 0 , rmax = n-1 , cmax = n-1;
        int mat[][] = new int[n][n];
        int count = 1;
        while(count <= n*n){
            // top wall
            for(int c = cmin ; c <= cmax ; c++){
                mat[rmin][c] = count;
                count++;
            }
            // right wall
            for(int r = rmin+1 ; r <= rmax ; r++){
                mat[r][cmax] = count;
                count++;
            }
            // bottom wall
            for(int c = cmax-1 ; c >= cmin ; c--){
                mat[rmax][c] = count;
                count++;
            }
            // left wall
            for(int r = rmax-1 ; r >= rmin+1 ; r--){
                mat[r][cmin] = count;
                count++;
            }
            
            rmin++;
            cmin++;
            rmax--;
            cmax--;
        }
        
        return mat;
    }
}