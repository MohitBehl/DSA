import java.util.Scanner;
class DSU{
    private int par[];
    private int rank[];

    DSU(int vtces){
        par = new int[vtces];
        rank = new int[vtces];

        for(int i = 0 ; i < vtces ; i++){
            par[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int mem){
        if(mem == par[mem]){
            return mem;
        }

        int leader = find(par[mem]);
        par[mem] = leader; // compression
        return leader;
    }

    public void union(int x,int y){
        int xl = find(x);
        int yl = find(y);
        if(xl != yl){
            if(rank[xl] > rank[yl]) par[yl] = xl;
            else if(rank[xl] < rank[yl]) par[xl] = yl;
            else{
                par[xl] = yl;
                rank[yl]++;
            }
        }
    }

}
class Main{
    public static boolean isConnected(DSU dsu,int x,int y){
        return dsu.find(x) == dsu.find(y);
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int edges = scn.nextInt();
        DSU dsu = new DSU(vtces);
        for(int i = 0 ; i < edges ; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            dsu.union(v1,v2);
        }

        System.out.println(isConnected(dsu,0,5));
        System.out.println(isConnected(dsu,7,8));
        System.out.println(isConnected(dsu,2,9));
    }
}