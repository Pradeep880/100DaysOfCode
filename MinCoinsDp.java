     int MinCoinsDp(int arr[],int n,int sum) {
    	 int dp[][]=new int [n+1][sum+1];
    	 for(int i=0;i<=sum;i++)
    		 dp[0][i]=Integer.MAX_VALUE-1;
    	 for(int i=1;i<=n;i++) {
    		 dp[i][0]=0;
    	 }
//    	 For row 1 if arr[i-1](first element of array)equal to sum or its multiple equal to sum
    	 for(int i=1,j=1;j<=sum;j++) {
    		   if(j%arr[i-1]==0)
    			   dp[i][j]=j/arr[i-1];
    		   else {
    			   dp[i][j]=Integer.MAX_VALUE-1; 
    		   }
    	 }
    	 for(int i=2;i<=n;i++)
    		 for(int j=1;j<=sum;j++) {
    	          if(arr[i-1]>j) {
				       dp[i][j]=dp[i-1][j];
			       }
    	          else {
				       dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-arr[i-1]]);
			      }
           } 
    	 for(int i=0;i<=n;i++) {
    		 for(int j=0;j<=sum;j++) {
    			 System.out.print("  "+dp[i][j]);
    		 }
    		 System.out.println();
    	 }
    		return dp[n][sum]; 
     }
}