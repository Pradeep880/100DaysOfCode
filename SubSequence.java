public class SubSequence {
	static int dp[][];
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
     
     String printLCS(String s1,String s2,int m,int n) {
    	 String str=" ";
    	 
    	 while(m>0||n>0) {
    		 if(s1.charAt(m-1)==s2.charAt(n-1)) {
    			 char ch=s1.charAt(m-1);
    			 str=str+String.valueOf(ch);
    			 m--;
    			 n--;
    		 }else if(dp[m-1][n]>dp[m][n-1]) {
    			 m--;
    		 }else {
    			 n--;
    		 }
    	 }
//    	 Reverse the string 
    	 StringBuilder s=new StringBuilder(str);
    	 s.reverse();
    	 str=s.toString();
    	 return str;
     }
 public static void main(String args[]){
   //		LCS(Longest common subSquence)
		
		String str1="acbcf";
		String str2="abcdaf";
		int m=str1.length();
		int n=str2.length();
		SubSequence s1=new SubSequence(m,n);
		int lcs=s1.LCS(str1, str2, m, n);
		System.out.println("LCS length:"+lcs);
		String res=s1.printLCS(str1, str2, m, n);
		System.out.print("LCS String is:"+res);

  }
}