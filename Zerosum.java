class Zerosum{
    public static int findSubarray(int[] arr ,int n) 
{
    //Your code here
    HashMap<Integer,Integer>map=new HashMap<>();
    int sum=0;
    int count=0;
    map.put(sum,1);
    for(int i=0;i<n;i++){
        sum=sum+arr[i];
        if(map.containsKey(sum)){
           int prev=map.get(sum);
            count+=prev;
            prev++;
            map.put(sum,prev);
        }else{
            map.put(sum,1);
        }
    }
    return count;
}
public static void main(String args[]){
  int arr[]={0,0,5,5,0,0};
  int n=arr.length;
  Zerosum z1=new Zerosum();
  int count=z1.findSubarray(arr,n);
  System.out.println("COunt:"+count);
}
}