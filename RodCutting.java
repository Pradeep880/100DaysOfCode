package Dyanamic_Programming;

public class RodCutting {

	
      static int Rod(int arr[],int target,int n,int price[]) {
		if(n==0||target<=0)
			return 0;
		if(arr[n-1]>target) {
			return Rod(arr,target,n-1,price);
		}else {
			return Math.max(price[n-1]+Rod(arr,target-arr[n-1],n,price),Rod(arr,target,n-1,price));
		}
		
	}
      static int RodDp(int arr[],int target,int n,int price[]) {
    	  int dp[][]=new int [n+1][target+1];
    	  for(int i=0;i<=n;i++) {
    		  for(int j=0;j<=target;j++) {
    			  if(i==0||j==0) {
    				  dp[i][j]=0;
    			  }
    		  else if(arr[i-1]>j) {
    				  dp[i][j]=dp[i-1][j];
    			  }else {
    				  dp[i][j]=Math.max(price[i-1]+dp[i][j-arr[i-1]],dp[i-1][j]);
    			  }
    		  }
    	  }
    	  for(int i=0;i<=n;i++) {
     		 for(int j=0;j<=target;j++) {
     			 System.out.print("  "+dp[i][j]);
     		 }
     		 System.out.println();
     	 }
    	  return dp[n][target];
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]= {1,2,3,4,5,6,7,8};
       int price[]= {1,4,8,9,10,17,18,20};
       int n=arr.length;
       System.out.println("Maximum Profit:"+Rod(arr,8,n,price));
       System.out.println("Maximum Profit:"+RodDp(arr,8,n,price));
	}

}
