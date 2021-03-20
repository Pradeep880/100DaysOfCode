import java.util.*;
class Solution{
    ArrayList<ArrayList<Integer>>adj;
    boolean visited[];
    int v;
    Solution(int v){
        this.v=v;
        this.adj=new ArrayList<>();
         for(int i=0;i<this.v;i++){
             adj.add(new ArrayList<Integer>());
         }
       this.visited=new boolean[this.v];
       Arrays.fill(visited,false);
    }
     void addEdge(int f,int l){
            adj.get(f).add(l);
            adj.get(l).add(f);
    }
     public void createGraph(){
            addEdge(0,1);
            addEdge(0,4);
            addEdge(1,2);
            addEdge(1,4);
            addEdge(1,3);
            addEdge(2,3);
            addEdge(4,3);
    }
   void dfsOfGraph(ArrayList<Integer>a1 ,int pos){
            visited[pos]=true;
            a1.add(pos);
            Iterator<Integer>i=adj.get(pos).listIterator();
            while(i.hasNext()){
                int n=i.next();
                while(!visited[n]){
                    visited[n]=true;
                    dfsOfGraph(a1,n);
                }
            }
   }
}
class DFS{
    public static void main(String []args){
        // V =Number of Vertex 
        int V=6;
        Solution s1=new Solution(V);  
        s1.createGraph();
        // DFS Traversal for undirected graph
        ArrayList<Integer>a1=new ArrayList<>();
        s1.dfsOfGraph(a1,2);
        // Handle non-connected vertex
        for(int i=0;i<V;i++){
            if(s1.visited[i]==false)
               s1.dfsOfGraph(a1,i);
        }
        System.out.print(a1);
    }
}