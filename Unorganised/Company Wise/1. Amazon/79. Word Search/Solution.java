class Solution {
    public boolean exist(char[][] board , String word) {
        for(int r = 0 ; r < board.length ; r++){
            for(int c = 0 ; c < board[0].length ; c++){

                if(board[r][c] == word.charAt(0)){
                    System.out.println(r+" "+c);
                    
                    if(exist(board, word,r,c,0))
                        return true;
                    // System.out.println("----------------------");
                }
            }
        }
        return false;
    }
    int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
    public boolean exist(char[][] board , String word , int r , int c , int idx){
        // System.out.println(r+" "+c+" "+idx);
        if(idx == word.length()-1){
            return true;
        }
        char currCh = word.charAt(idx);
            board[r][c] = '-';
            for(int i = 0 ; i < 4 ; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length){ 
                    // next coordinate is out of the board
                    continue;
                }
                if(board[nr][nc] == '-'){
                    // next coordinate is already visited
                    continue;
                }
                if(board[nr][nc] != word.charAt(idx+1)){
                    // next block doesn't have matching character
                    continue;
                }
                if(exist(board, word,nr,nc,idx+1)) return true;
            }

            board[r][c] = currCh;
        return false;
    }
}