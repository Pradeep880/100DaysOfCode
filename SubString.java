public class SubString {
//      Longest common substring
     static int LCsbstr(String s1,String s2,int m,int n,int count) {
    	  if(m==0||n==0)
    		  return count;
    	  if(s1.charAt(m-1)==s2.charAt(n-1)) {
    	   return count = LCsbstr(s1,s2,m-1,n-1,count+1);
    	  }else {
    		  count=Math.max(count,Math.max(LCsbstr(s1,s2,m-1,n,0),LCsbstr(s1,s2,m,n-1,0)));
    	  }
    	  return count;
      }
      
//      LC substring to DP
    static int SbstrDP(String s1,String s2,int m,int n) {
    	  int result=0;
    	  int dp[][]=new int[m+1][n+1];
    	  for(int i=0;i<=m;i++) {
    		  for(int j=0;j<=n;j++) {
    			  if(i==0||j==0) {
    				  dp[i][j]=0;
    			  }else if(s1.charAt(i-1)==s2.charAt(j-1)) {
    				  dp[i][j]=1+dp[i-1][j-1];
    				  result=Math.max(result, dp[i][j]);
    			  }else {
    				dp[i][j]=0;  
    			  }
    		  }
    	  }
    	  return result;
      }
    public static void main(String args[]){
        //	longest common substring
		String str1="aabcaabcd";
		String str2="aabaabcd";
		int m=str1.length();
		n=str2.length();
		int lcs=l1.LCsbstr(str1, str2, m, n, 0);
		System.out.println("Substring:"+lcs);
		int lcsDp=l1.SbstrDP(str1, str2, m, n);
		System.out.println("Substring:"+lcsDp);
     }
}