import java.util.*;
import java.lang.*;
 
class Main
{
	public static class Edge{
		int src,nbr,wt;
		Edge(int src,int nbr,int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	public static class MSTPair implements Comparable<MSTPair>{
		int vtx,par,wt;
		MSTPair(int vtx,int par,int wt){
			this.vtx = vtx;
			this.par = par;
			this.wt = wt;
		}
		
		public int compareTo(MSTPair obj){
			return this.wt-obj.wt;
		}
	}
	public static int MST(ArrayList<Edge>[] graph){
		PriorityQueue<MSTPair> pq = new PriorityQueue<>();
		pq.add(new MSTPair(1,-1,0));
		boolean vis[] = new boolean[graph.length+1];
		int cost = 0;		
		while(pq.size() > 0){
			MSTPair rem = pq.remove();
			if(!vis[rem.vtx]){
				vis[rem.vtx] = true;
				
				cost += rem.wt;
				
				ArrayList<Edge> edges = graph[rem.vtx];
				for(Edge edge : edges){
					if(!vis[edge.nbr]){
						pq.add(new MSTPair(edge.nbr,rem.vtx,edge.wt));
					}
				}
			}
		}
		return cost;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
		int nvtces = scn.nextInt();
		ArrayList<Edge>[] graph = new ArrayList[nvtces+1];
		for(int i = 0 ; i <= nvtces ; i++){
			graph[i] = new ArrayList<>();
		}
		int nedges = scn.nextInt();
		while(nedges-- > 0){
			int v1 = scn.nextInt() , v2 = scn.nextInt() , wt = scn.nextInt();
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v2,v1,wt));
		}
		
		System.out.println(MST(graph));
	}
}   