public class CountSubset{
  static void countSubSet(int arr[],int sum,int ans,int n ) {
	  if(ans==sum) {
	       	 count++;
	       		 ans=0;
	       		 System.out.println("Count");
	       	 return ;
	        }
        if(n==0)
       	 return ;
     
       if(ans>sum) {	 
    	   
    countSubSet(arr,sum,ans,n-1);
       }else {
//    	   System.out.println("ebvz");
//    	   System.out.println("ans:"+ans+"Arr[n-1]"+arr[n-1]);
            System.out.print(" v :"+(arr[n-1]+ans));
    	 countSubSet(arr,sum,ans+arr[n-1],n-1);
     countSubSet(arr,sum,ans,n-1);
       }
    
   }
   static int countDp(int arr[],int sum,int n){
	    // Initializing the matrix
	    int tab[][]=new int [n+1][sum+1];
	  // Initializing the first value of matrix
	    tab[0][0] = 1;
	    for (int i = 1; i <= sum; i++)
	        tab[0][i] = 0;
	    for (int i = 1; i <= n; i++)
	        tab[i][0] = 1;
	 
	    for (int i = 1; i <= n; i++)
	    {
	        for (int j = 1; j <= sum; j++)
	        {
	          // if the value is greater than the sum
	            if (arr[i - 1] > j)
	                tab[i][j] = tab[i - 1][j];
	            else
	            {
	                tab[i][j] = tab[i - 1][j] + tab[i - 1][j - arr[i - 1]];
	            }
	        }
	    }
	 
	 
	    return tab[n][sum];
	}
   public static void main(String args){
     int arr[]= {2,3,5,6,8,10};
    	int sum=10;
    	int n=arr.length;
     System.out.println("All Subset:"+countDp(arr,sum,n));
}

}
