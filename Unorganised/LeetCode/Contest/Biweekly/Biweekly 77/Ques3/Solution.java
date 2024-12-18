import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private void mark(int mat[][] ,int x,int y){
        for(int i = x , j = y+1 ; j < mat[0].length ; j++){
            if(mat[i][j] == 2 && mat[i][j] == 1) break;
            mat[i][j] = 3;
        }
        for(int i = x , j = y-1 ; j >= 0 ; j--){
            if(mat[i][j] == 2 && mat[i][j] == 1) break;
            mat[i][j] = 3;
        }
        for(int i = x-1 , j = y ; i >= 0 ; i--){
            if(mat[i][j] == 2 && mat[i][j] == 1) break;
            mat[i][j] = 3;
        }
        for(int i = x+1 , j = y ; i < mat.length ; i++){
            if(mat[i][j] == 2 && mat[i][j] == 1) break;
            mat[i][j] = 3;
        }
    }
    private class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 0 : unvisited , 1 : guard , 2 : wall , 3 : guarded area
        // make matrix
        int mat[][] = new int[m][n]; 
        // put walls
        for(int []wall : walls){
            int x = wall[0] , y = wall[1];
            mat[x][y] = 2;
        }
        // put guards
        Queue<Pair> queue = new ArrayDeque<>();
        for(int []guard : guards){
            int x = guard[0];
            int y = guard[1];
            mat[x][y] = 1;
            queue.add(new Pair(x,y));
        }
        while(queue.size() > 0){
            mark(mat,queue.peek().x,queue.peek().y);
        }
        
        int count = 0;
        for(int row[] : mat){
            for(int vl : row){
                if(vl == 0) count++;
            }
        }

        return count;
    }
}