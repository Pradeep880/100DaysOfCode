import java.util.Arrays;

public class Pascal {
//    /Pascal’s triangle, in which each number is the sum of the two above it, with ones along the sides of the triangle
	int memo[][]=new int [1000][1000];
	Pascal() {
		for(int i=0;i<1000;i++) {
			Arrays.fill(memo[i],-1);
		}
	}
	int pascal(int row,int col) {
		if(row==0)
			return 1;
		if(col==0||row==col)
			  return 1;
		else{
			return pascal(row-1,col)+pascal(row-1,col-1);
		}
	}
int pascalUsingDp(int row,int col) {	
			if(row==0)
				return 1;
			if(memo[row][col]!=-1) {
				return memo[row][col];
			}
			if(col==0||row==col)
				return 1;
			else {
				return memo[row][col]=pascalUsingDp(row-1,col)+pascalUsingDp(row-1,col-1);
			}
		}
}
class PascalCalculate{
     pulblic static void main(String args[]){
               Pascal pas=new Pascal();
               int res= pas.pascal(10, 3);
               int res1=pas.pascalUsingDp( 10, 9);
               System.out.println("Result of pascal:"+res1);
        }

}
