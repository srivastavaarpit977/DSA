import java.util.*;
class nQueens{


    public boolean canPlace(char[][] board,int row, int col){

        int n = board.length;  
        //  checking for same col 
         int x = row ; 
         int y = col ;
        while(x>=0){
             if(board[x][y] == 'Q'){
                return false;
             }
             x--; 
        }

        x = row ; 
        y = col ;
        // check for the left diagonal 
        
        while(x>=0 && y>=0){
            if(board[x][y] == 'Q'){
               return false;
            }
            x--;
            y--; 
       }



       x = row ; 
       y = col ;
       // check for the right  diagonal 
       
       while(x>=0 && y<n){
           if(board[x][y] == 'Q'){
              return false;
           }
           x--;
           y++; 
      }

      return true; 
         
    }

    public void helper(int row, char[][] board,List<List<String>> ans ){
         
        int n = board.length;

        if(row == n){
            List<String> cur = new ArrayList<>();

            for(int i =0 ; i<n ; i++){
                 cur.add(new String(board[i])); 
            }

            ans.add(cur);
            return; 
             
        }


        for(int col =0 ; col <n ; col++){
            if(canPlace(board,row,col)){
                board[row][col] = 'Q';
                helper( row + 1, board, ans);
                board[row][col] = '.';
            }

        }
    }

    public List<List<String>> solveNQueens(int n){
        List<List<String>> ans  = new ArrayList<>();
        char[][] board = new char[n][n]; 


        for(int i =0 ; i <n ; i++){
             for(int j =0 ; i<n ; j++){
                 board[i][j] = '.'; 
             }
        }

        helper(0,board,ans);

        return ans; 
    }




}