public class wordbreak {
    public int wordBreak(String s, ArrayList<String> B) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; // set first to be true, why?
        // Because we need initial state
        Set<String> dict = new HashSet<>(B);
        for(int i=0; i<s.length(); i++){
            // should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()]?1:0;
    }
}