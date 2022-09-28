public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int nr = 9
        int nc = 9
        int mat[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++)
            for(int j = 0 ; j < nc ; j++)
                mat[i][j] = scn.nextInt();

        boolean res = isValidSudoku(mat);
        System.out.println(res);
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
}