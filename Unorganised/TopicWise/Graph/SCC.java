//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    void dfs(ArrayList<ArrayList<Integer>> adj,int vtx,Stack<Integer> st,boolean vis[]){
        vis[vtx] = true;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for(int nbr : nbrs){
            if(vis[nbr] == false){
                dfs(adj,nbr,st,vis);
            }
        }
        st.push(vtx);
    }
    void dfs(ArrayList<ArrayList<Integer>> adj,int vtx,boolean vis[]){
        vis[vtx] = true;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for(int nbr : nbrs){
            if(vis[nbr] == false){
                dfs(adj,nbr,vis);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int vtx = 0 ; vtx < V ; vtx++){
            if(vis[vtx] == false){
                dfs(adj,vtx,st,vis);
            }
        }
        
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            revAdj.add(new ArrayList<>());
        }
        for(int vtx = 0 ; vtx < V ; vtx++){
            ArrayList<Integer> onbrs = adj.get(vtx);
            for(int nbr : onbrs){
                revAdj.get(nbr).add(vtx);   
            }
        }
        
        int count = 0;
        Arrays.fill(vis,false); 
        while(st.size() > 0){
            int vtx = st.pop();
            if(vis[vtx] == false){
                count++;
                dfs(revAdj,vtx,vis);
            }
        }
        
        return count;
    }
}
