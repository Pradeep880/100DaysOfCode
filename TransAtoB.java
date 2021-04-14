public class SubSequence{

       static int dp[][];
	SubSequence(int m,int n){
		dp=new int[m+1][n+1];
	}
       int LCS(String s1,String s2,int m,int n) {
    	 int j;
    	   for(int i=0;i<=m;i++) {
    		   for( j=0;j<=n;j++) {
    			   if(i==0||j==0)
    				   dp[i][j]=0;
    		   else if(s1.charAt(i-1)==s2.charAt(j-1)) {
    			   dp[i][j]=1+dp[i-1][j-1];
    		   }else {
    			   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
    		   }
    	   }
       }
    	   return dp[m][n];
    } 
    //     minimum number of insertion and deletion to transform a string to b
     void AtoB(String s1,String s2,int m,int n) {
    	 int len=LCS(s1,s2,m,n);
    	 System.out.println("len:"+len);
    	 System.out.println("Minimum number of insertion:"+(m-len));
    	 System.out.println("Minimum number of insertion:"+(n-len));
     }
}
public class TransAtob{

    public static void main(String args[]){
          String str1="heap";
		String str2="pea";
		int m=str1.length();
		int n=str2.length();
		SubSequence s1=new SubSequence(m,n); 
               s1.AtoB(str1, str2, m, n); 
    }

}


