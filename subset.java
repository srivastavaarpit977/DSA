public class subset {
    
    public ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public void subgen(ArrayList<Integer> A , int i ,ArrayList<Integer> list){
        if(i>= A.size()) {
            ans.add(new ArrayList<>(list));
            return ;
        }
        list.add(A.get(i));
        subgen(A,i+1,list);
        list.remove(list.size()-1);
        subgen(A,i+1,list);
        
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(A);
        subgen(A,0,list);
        Collections.sort(ans,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                for(int i=0; i<Math.min(a.size(),b.size()); i++){
                if(a.get(i) > b.get(i)) return 1;
                else if(b.get(i) >a.get(i))return -1;
                }
                return a.size() -b.size();
            }
        });
        return ans;
    }
}