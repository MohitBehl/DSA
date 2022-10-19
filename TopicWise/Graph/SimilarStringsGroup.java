class Solution {
    class DSU{
        String strs[];
        DSU(String strs[]){
            this.strs = strs;
            par = new int[strs.length];
            rank = new int[strs.length];
            for(int i = 0 ; i < strs.length ; i++){
                par[i] = i;
                rank[i] = 1;
            }
            this.groups = strs.length;
        }
        int par[];
        int rank[];
        int groups;
        public int find(int idx){
            if(par[idx] == idx){
                return idx;
            }
            int leader = find(par[idx]);
            par[idx] = leader;
            return leader;
        }
        public void union(int idx1,int idx2){
            int idx1L = find(idx1);
            int idx2L = find(idx2);
            if(idx1L != idx2L && isSimilar(strs,idx1,idx2)){
                if(rank[idx1L] > rank[idx2L]){
                    par[idx2L] = idx1L;
                }else if(rank[idx1L] < rank[idx2L]){
                    par[idx1L] = idx2L;
                }else{
                    par[idx1L] = idx2L;
                    rank[idx2L]++:
                }
                groups--;
            }
        }
        public boolean isSimilar(String[] strs,int idx1,int idx2){

        }
    }
    
    public int numSimilarGroups(String[] strs) {
        DSU uf = new DSU(strs);
        for(int i = 0 ; i < strs.length ; i++){
            for(int j = i+1 ; j < strs.length ; j++){
                uf.union(i,j);
            }
        }
        return uf.groups;
    }
}