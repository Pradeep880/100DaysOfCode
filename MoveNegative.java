public class MoveNegative {
    public static void main(String args[]) { 
    	int arr[]= {-12,11,-13,6,7,5,-6,-5};
    	int k;
    	int j;
    	for(int i=1;i<arr.length;i++) {
    		k=arr[i];
//    		if k is positive value so we have to stop the loop
    		if(k>0){
    			continue;
    		}
//    		if k is negative so we move positive value right one by one
    		for( j=i-1;arr[j]>0&&j>=0;j--) {
    			arr[j+1]=arr[j];
    		}
    		arr[j+1]=k;
    	}
    	for(int i:arr) {
    		System.out.print(i+" ");
    	}
    }
}