import java.util.*;
public class ratInMaze {

    boolean flag = true;

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {

        int i = 0;
        int j = 0;
        findPath(i,j,A);
        return A;
    }
    public void findPath( int i ,int j,ArrayList<ArrayList<Integer>> A){
        if((i==A.size()-1 && j == A.size()-1 )|| A.get(i).get(j)== 0) {
            flag=false; 
            return ;
            }
            if(checkValid(i+1,j,A)){
                findPath(i+1,j,A);
                if(!flag) return;
            }
            if(checkValid(i,j+1,A)){
                    findPath(i,j+1,A);
                    if(!flag) return;
                    
                }
            A.get(i).set(j,0);
                       return;

                
            


      

        
        


        
    }

    public boolean checkValid(int i , int j ,ArrayList<ArrayList<Integer>> A ){

    if (i < 0 || i > A.size()-1) return false; 

    if (j < 0 || j > A.get(i).size()-1) return false; 

    if (A.get(i).get(j) == 0) return false; 
    
    return true;
    }}