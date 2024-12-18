//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    int par[],disc[],low[];
    boolean ap[],vis[];
    int osrc;
    int time;
    int count; // for detecting ap at src
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        par = new int[V];
        disc = new int[V];
        low = new int[V];
        osrc = 0;
        ap = new boolean[V];
        vis = new boolean[V];
        time = 0;
        count = 0;
        
        dfs(osrc,adj);
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            if(ap[i]) ans.add(i);    
        }
        
        if(ans.size() == 0){
            ans.add(-1);
        }
        
        return ans;
    }
    
    public void dfs(int curr,ArrayList<ArrayList<Integer>> graph){
        vis[curr] = true;
        disc[curr] = low[curr] = time;
        time++;
        
        ArrayList<Integer> nbrs = graph.get(curr);
        for(int nbr : nbrs){
            if(vis[nbr]){
                if(nbr == par[curr]){
                    continue;
                }else{
                    low[curr] = Math.min(low[curr],disc[nbr]);
                }
            }else{
                par[nbr] = curr;
                dfs(nbr,graph);
                
                if(curr == osrc){
                    count++;
                    if(count >= 2){ // src is connecting multiple comp
                         ap[osrc] = true;
                    }
                }else{
                    if(low[nbr] >= disc[curr]){
                        ap[curr] = true;
                    }
                }
                
                low[curr] = Math.min(low[curr],low[nbr]);
            }
        }
    }
}