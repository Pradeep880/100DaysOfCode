import java.util.ArrayList;
import java.util.*;
 class ListRepresent {
//	For undirected graph
	int v;
	boolean visited[];
	ListRepresent(int v){
		this.v=v;
	    visited=new boolean[this.v];
	    Arrays.fill(visited,false);
	}
	 void addEdge(ArrayList<ArrayList<Integer>>adj,int f,int l) {      
    	adj.get(f).add(l);
    	adj.get(l).add(f);
    }
	  public boolean dfsOfGraph(ArrayList<ArrayList<Integer>>adj,int pos,int parent){
          visited[pos]=true;
          Iterator<Integer>i=adj.get(pos).listIterator();
          while(i.hasNext()){
              int n=i.next();
              if(!visited[n]){
                  if(dfsOfGraph(adj,n,pos))
                    return true;
              }      
                  else if(n!=parent)
                    return true;
          }
          return false;
 }
  public boolean isCycle(ArrayList<ArrayList<Integer>>adj)
  {
      // Code here
	  boolean isConnect=true;
	 boolean cycle= dfsOfGraph(adj,0,-1);
	//  if(cycle) {
	// 	 System.out.println("Delect Cycle");
	//  }else {
	// 	 System.out.println("not Delect Cycle");
	//  }
//	 For checking dis-connected
      for(int i=0;i<v;i++){
          if(!visited[i]) {
              isConnect=false;
          }  
      }
      if(!cycle&&isConnect) {
    	  return true;
      }
      return false;
  }
//	For checking graph is tree or not we check
//	1.There is no cycle in graph
//	2.Graph must be connected
	boolean isGraphTree(ArrayList<ArrayList<Integer>>adj) {
		if(isCycle(adj))
		return true;
		return false;
	}
}
public class IsGraphTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    	ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
		    	int v=5;
		    	for(int i=0;i<v;i++) {
		    		adj.add(new ArrayList<>());
		    	}
		    		
		    	ListRepresent l1=new ListRepresent(v);
		    	 l1.addEdge(adj, 0, 1);
//		         l1.addEdge(adj, 0, 4);
		        //  l1.addEdge(adj, 1, 2);
//		         l1.addEdge(adj, 1, 3);
//		         l1.addEdge(adj, 1, 4);
		    	   l1.addEdge(adj, 0, 2);
		         l1.addEdge(adj, 0, 3);
		         l1.addEdge(adj, 3, 4);
		    	System.out.println(); 
		        //  System.out.println("Check Graph is Tree or not");
		         boolean graph=l1.isGraphTree(adj);
		         if(graph) {
		        	 System.out.println("Graph is Tree");
		         }else {
		        	 System.out.println("Graph is not Tree"); 
		         }
		    }
}
