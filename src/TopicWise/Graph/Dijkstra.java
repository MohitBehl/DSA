package TopicWise.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Dijkstra
{
    public static class Pair implements Comparable<Pair>{
        int vtx,wsf;
        Pair(int vtx,int wsf){
            this.vtx = vtx;
            this.wsf = wsf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int vtces = adj.size();
        int[] ans = new int[vtces];
        Arrays.fill(ans,-1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S,0));
        while(pq.size() > 0)
        {
            Pair rem = pq.remove();
            
            if(ans[rem.vtx] == -1){
                ans[rem.vtx] = rem.wsf;
                
                ArrayList<ArrayList<Integer>> edges = adj.get(rem.vtx);
                
                for(ArrayList<Integer> edge : edges){
                    int wt = edge.get(1);
                    int nbr = edge.get(0);
                
                    if(ans[nbr] == -1){
                        pq.add(new Pair(nbr,rem.wsf+wt));
                    }
                }
            }
        }
        return ans;
    }
}