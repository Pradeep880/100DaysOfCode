import java.util.*;
class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean vis[]=new boolean[V];
        Queue<Integer>q1=new LinkedList<>();
        ArrayList<Integer>a1=new ArrayList<>();
        vis[0]=true;
        q1.add(0);
        while(!q1.isEmpty()){
            int s=q1.remove();
            a1.add(s);
             Iterator<Integer>v=adj.get(s).listIterator();
             while(v.hasNext()){
                int n=v.next();
                if(!vis[n]){
                    vis[n]=true;
                    q1.add(n);
                }
            }
        }
        return a1;
    }
    void addEdge(ArrayList<ArrayList<Integer>>adj,int f,int l){
            adj.get(f).add(l);
            adj.get(l).add(f);
    }
    public void createGraph(ArrayList<ArrayList<Integer>>adj,int v){
         for(int i=0;i<v;i++){
             adj.add(new ArrayList<Integer>());
         }
            addEdge(adj,0,1);
            addEdge(adj,0,4);
            addEdge(adj,1,2);
            addEdge(adj,1,4);
            addEdge(adj,1,3);
            addEdge(adj,2,3);
            addEdge(adj,4,3);
    }
}
class BFS{
    public static void main(String []args){
        Solution s1=new Solution();
        int v=5;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        s1.createGraph(adj,v);
        // BFS Traversal for undirected graph
        ArrayList<Integer>a1=s1.bfsOfGraph(v,adj);
        System.out.print(a1);
    }
}