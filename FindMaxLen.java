static int FindMaxLen(String S) {
        // code here
        int r=0;int l=0;
        int max1=0;
        int n=S.length();
        for(int i=0;i<n;i++){
            char c=S.charAt(i);
            if(c=='('){
                l++;
            }else
            r++;
            
            if(l==r){
                max1=Math.max(max1,r*2);
            }else if(r>l){
                    r=0;
                    l=0;
                }
        }
        l=0;
        r=0;
        for(int i=n-1;i>=0;i--){
            char c=S.charAt(i);
            if(c=='('){
                l++;
            }else
            r++;
            
            if(l==r){
                max1=Math.max(max1,l*2);
            }else if(r<l){
                    r=0;
                    l=0;
                }
        }
        return max1;
    }