class Solution {
    //  initial code
    public String tictactoe(int[][] moves) {
        char mat[][] = new char[3][3];
        
        boolean flag = true;
        for(int[] move : moves){
            int r = move[0] , c = move[1];
            mat[r][c] = flag ? 'X' : 'O';
            flag = (flag ^ true);
        }
        int hz[] = new int[3];
        int vt[] = new int[3];
        int ldiag = 0 , rdiag = 0;
        String winner = "";
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                char ch = mat[i][j];
                if(i == j){
                    if(ch == 'X') 
                        ldiag++;
                    else if(ch == 'O')
                        ldiag--;
                }
                if(i+j == 2){
                    if(ch == 'X') 
                        rdiag++;
                    else if(ch == 'O')
                        rdiag--;
                }
                if(ch == 'X'){
                    hz[i] += 1;
                    vt[j] += 1;
                }else if(ch == 'O'){
                    hz[i] -= 1;
                    vt[j] -= 1;
                }
                if(hz[i] == 3 || vt[j] == 3 || ldiag == 3 || rdiag == 3){
                    return "A";
                }else if(hz[i] == -3 || vt[j] == -3 || ldiag == -3 || rdiag == -3){
                    return "B";
                }
            }
        }
        
        if(moves.length != 9){
            return "Pending";
        }else{
            return "Draw";
        }
    }
}