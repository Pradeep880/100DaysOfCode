class ProductArray
{ 
	public static long[] productExceptSelf(int arr[], int n) 
	{ 
        // code here
        long l1[]=new long[n];
        // long b=1000000007;
        long sum=1;
        /* In this loop, temp variable contains product of 
		elements on left side excluding arr[i] */
        for(int i=0;i<n;i++){
           l1[i]=sum;
          sum=sum*arr[i];
        }
        sum=1;
        /* Initialize temp to 1 for product on right side */
        for(int i=n-1;i>=0;i--){
        l1[i]=sum*l1[i];
        sum=sum*arr[i];
        }
        return l1;
	} 
    public static void main(String args[]){
       ProductArray s1=new ProductArray();
        int arr[]={10,3,5,6,2};
        long res[]=s1.productExceptSelf(arr,arr.length);
        for(long i:res){
            System.out.print(i+"  ");
        }
    }
} 