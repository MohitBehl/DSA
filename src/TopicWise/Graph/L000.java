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
        // printAllPath(graph,0,2,new boolean[nvtces],"0");
        // System.out.println(gcc(graph));
        BFS(graph,2);
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

    public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int vtx = 0 ; vtx < vis.length ; vtx++){
            if(!vis[vtx]){
                ArrayList<Integer> compList = new ArrayList<>();
                compWiseDFS(graph,vtx,vis,compList);
                res.add(compList);
            } 
        }
        return res;
    }

    public static void compWiseDFS(ArrayList<Edge>[] graph,int vtx,boolean vis[],ArrayList<Integer> compList){
        vis[vtx] = true;
        compList.add(vtx);
        for(Edge e : graph[vtx]){
            if(!vis[e.nbr]) compWiseDFS(graph,e.nbr,vis,compList);
        }
    }

    public static boolean isGraphConnected(ArrayList<Edge>[] graph){
        return (gcc(graph).size() == 1);
    }
    public static class BFSPair{
        int vtx;
        String psf;
        BFSPair(int vtx,String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
    public static void BFS(ArrayList<Edge>[] graph,int src){
        Queue<BFSPair> queue = new ArrayDeque<>();
        queue.add(new BFSPair(src,""+src));
        boolean vis[] = new boolean[graph.length];
        while(queue.size() > 0){
            BFSPair rem = queue.remove();

            if(vis[rem.vtx] == false){
                vis[rem.vtx] = true;

                System.out.println(rem.vtx+"@"+rem.psf);

                for(Edge e : graph[rem.vtx]){
                    if(!vis[e.nbr]){
                        queue.add(new BFSPair(e.nbr,rem.psf+e.nbr));
                    }
                }
            }
        }
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph){
        int src = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        boolean vis[] = new boolean[graph.length];
        while(queue.size() > 0){
            int rem = queue.remove();

            if(vis[rem] == false){
                vis[rem] = true;

                for(Edge e : graph[rem]){
                    if(!vis[e.nbr]){
                        queue.add(e.nbr);
                    }
                }
            }else{
                // multiple ways to reach same vtx -> cyclic 
                return true;
            }
        }
        return false;
    }
}
/*
9
7
0 1
0 2
1 2
3 4
4 5
6 7
6 8
*/

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