import java.util.*;
class L000{
    public static class Edge{
        int src,nbr;
        Edge(int src,int nbr){
            this.src = src;
            this.nbr = nbr;
        }
        public String toString(){
            return src+"->"+nbr;
        }
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int nvtces = scn.nextInt();
        int nedges = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[nvtces];

        for(int i = 0 ; i < nvtces ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < nedges ; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }

        // System.out.println(Arrays.toString(graph));
        printAllPath(graph,0,2,new boolean[nvtces],"0");
    }

    public static boolean hasPath(ArrayList<Edge>[]graph,int vtx,int dest,boolean vis[]){
        if(vtx == dest){
            return true;
        }

        vis[vtx] = true;
        for(Edge e : graph[vtx]){
            if(!vis[e.nbr]){
                boolean rres = hasPath(graph,e.nbr,dest,vis);
                if(rres) return true;
            }
        }

        return false;
    }

    public static void printAllPath(ArrayList<Edge>[]graph,int vtx,int dest,boolean vis[],String psf){
        if(vtx == dest){
            System.out.println(psf);
            return;
        }

        vis[vtx] = true;
        for(Edge e : graph[vtx]){
            if(!vis[e.nbr]){
                printAllPath(graph,e.nbr,dest,vis,psf+e.nbr);
            }
        }
        vis[vtx] = false;
    }
}
/*
4
6
0 1
0 2
0 3
1 2
3 2
1 3
*/

/*
7
8
0 1
1 2
2 3
0 3
3 4
4 5
5 6
4 6
*/