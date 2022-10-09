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

        System.out.println(Arrays.toString(graph));
    }
}

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