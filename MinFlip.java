class MinFlip {
    char flip(char ch){
    return  (ch=='0')? '1':'0';
    }
   static int getmin(String S,char expect){
        int n=S.length();
        int count=0;
        for(int i=0;i<n;i++){
             if(S.charAt(i)!=expect)
               count++;
             expect=flip(expect);  
        }
        return count;
    }
    public static int minFlips(String S) {
        // Code here
        int n=S.length();
        return Math.min(getmin(S,'0'),getmin(S,'1')); 
    }
  public static void main(String args[]){
      
      String bs="0001010111";
      System.out.print("Minimum number of bit:"+minFlips(bs));
   }
}