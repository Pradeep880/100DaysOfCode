import java.util.*;
class Solution
{
    boolean visited[];
    ArrayList<ArrayList<Integer>>adj;
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
            // addEdge(1,2);
            addEdge(1,4);
            addEdge(1,3);
            addEdge(2,3);
            // addEdge(4,3);
    }
   public boolean dfsOfGraph(int pos,int parent){
            visited[pos]=true;
            Iterator<Integer>i=adj.get(pos).listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    if(dfsOfGraph(n,pos))
                      return true;
                }      
                    else if(n!=parent)
                      return true;
            }
            return false;
   }
    public boolean isCycle(int V)
    {
        // Code here
        for(int i=0;i<V;i++){
            if(!visited[i]) {
                if(dfsOfGraph(i,-1))
                   return true;
            }  
        }
        return false;
    }
}
class Cyclic_graph{
    public static void main(String args[]){
        int V=5;
        Solution s1=new Solution(V);
        s1.createGraph();
        boolean cycle=s1.isCycle(V);
        if(cycle){
            System.out.print("There is cycle in Graph");
        }else{
            System.out.print("There is no cycle in Graph");
        }
    }
}