public class DiffSubset {

	static int count=0;
//	  static void countDiffSubSet(int arr[],int sum,int ans,int n,int diff ) {
//		    
//	        if(n==0) {
//	        	System.out.print("   ans:"+ans);
////	        	int res=(sum-ans)-ans;
////	        	if(res==diff)
////	        		count++;
//	        	int res=(diff+sum)/2;
//	        	if(res==ans) 
//	        		count++;
//	        	return ;
//	        };
//	    	    countDiffSubSet(arr,sum,ans+arr[n-1],n-1,diff);
//	            countDiffSubSet(arr,sum,ans,n-1,diff);
//	   }
	static int countDiffSetDp(int arr[],int s1,int n ) {
		int dp[][]=new int[n+1][s1+1];
		for(int i=0;i<=n;i++) {
			dp[i][0]=1;
		}
		for(int i=1;i<=s1;i++)
			dp[0][i]=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=s1;j++) {
				if(j<arr[i-1])
					dp[i][j]=dp[i-1][j];
				else {
					dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
				}
			}
		}
//		for(int i=0;i<=n;i++) {
//			for(int j=0;j<=s1;j++) {
//				System.out.print("  "+dp[i][j]);
//			}
//			System.out.println();
//		}
		return dp[n][s1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]= {1,1,2,3};
       int n=arr.length;
       int sum=0;
       for(int i=0;i<n;i++) {
    	   sum+=arr[i];
       }
//       countDiffSubSet(arr,sum,0,n,1);
//       System.out.println("Count:"+count);
//       For Dp
//       s1+s2=s;
//       s1-s2=diff;
//       s1=(diff+s)/2;
       int diff=1;
       int s1=(diff+sum)/2;
       
       int res=countDiffSetDp(arr,s1,n);
       System.out.println("CountD:"+res);
	}

}