public class SecondMostRepeat
{
   static String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<N;i++){
            if(map.containsKey(arr[i])){
                int of=map.get(arr[i]);
                int nf=of+1;
                map.put(arr[i],nf);
            }else{
            map.put(arr[i],1);
            }
        }
        
        // System.out.print(map);
        int  first=Integer.MIN_VALUE;
        int  second=Integer.MIN_VALUE;
        String res="";
        // Find second Most frequent string
         for(Map.Entry<String,Integer>entry:map.entrySet()){
             int n=entry.getValue();
             if(n>first){
                //  System.out.print("First");
                //  res=entry.getKey();
                second=first;
                 first=n;
             }
            else if(first!=n&&n>second)
             {
                 second=n;
             }
         }    
          for(Map.Entry<String,Integer>entry:map.entrySet()){
             int n=entry.getValue();
             if(n==second){
                 res=entry.getKey();
                 return res;
             }
         }  
         return res;
    }
   public static void main(String args[]){
      String arr[]={aaa, bbb, ccc, bbb, aaa, aaa};
        String res=secFrequent(arr,arr.length);
      System.out.println("Second most repeated string:"+res);
   }

}