package Dyanamic_Programming;

import java.util.Arrays;

public class Subset {
    int memo[][];
    Subset(int n,int sum){
    	memo=new int[n][sum+1];
    	for(int i=0;i<n;i++) {
			Arrays.fill(memo[i],-1);
		}
    }
    boolean SumSubSet(int arr[],int n,int m) {
    	if(n==0&&m==0)
    		return true;
    	if(n==0&&m!=0)
    		return false;
    	if(n!=0&&m==0)
    		return true;
    	if(arr[n-1]>m)
    		return SumSubSet(arr,n-1,m);
    	else {
    	     
    		return SumSubSet(arr,n-1,m)||SumSubSet(arr,n-1,m-arr[n-1]);
    	}
    }
    int SumSubSetMemo(int arr[],int n,int m) {
    	if(n==0&&m==0)
    		return 1;
    	if(n==0&&m!=0)
    		return 0;
    	if(n!=0&&m==0)
    		return 1;
    	if(memo[n-1][m]!=-1)
    		return memo[n-1][m];
    	if(arr[n-1]>m)
    	return memo[n-1][m]= SumSubSetMemo(arr,n-1,m);
    	else {
    	 if(SumSubSetMemo(arr,n-1,m)==1||SumSubSetMemo(arr,n-1,m-arr[n-1])==1)
    		return memo[n-1][m]=1;
    	 return memo[n-1][m]=0;
    	}
    }
    public static void main(String args[]) {
//    	Sum Subset 
    	int arr[]= {10,11,1,1,1};
    	int sum=21;
    	int n1=arr.length;
    	Subset sub=new Subset(n1,sum);
//    	boolean res2=sub.SumSubSet(arr,n1,sum);
    	int res=sub.SumSubSetMemo(arr, n1, sum);
    	if(res==1) 
    		System.out.println("Subset is present");
    	else 
    		System.out.println("Subset is not present");
    }
}