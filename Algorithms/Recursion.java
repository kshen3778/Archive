package test4;

import java.util.Scanner;

public class Recursion {
	//recursion = a method can call itself
	//recurson makes lots of copies of the same method which does a small portion of the job
	//all these methods work in a chain and returns info to the next one.
	
	//stack memory: the first one in is the last(and last one out).
	
	//recursion uses stack. sum(5) is at the bottom, it calls sum(4), which calls sum(3)
	//and once it hits sum(1) it goes down the stack again and returns info to the sum(num) below it.
	//once sum() returns 1 sum(1) pops out of the stack. sum(2) calculates and returns.
	//once sum(2) returns, it pops out and hands control to sum(3) and so on until sum(5).
	
	//ARITHEMATIC SEQUENCES(SUMS)
	int sumOfN(int n){ //returns sum fron 1 to n
		if(n == 1){ //base case: the first guy will just return one to the next
			return 1;
		}//once this method hits n = 1 it will start returning and going back up the chain
		//as each guy will give his info to the next to be modified
		
		//when method is still going down the stack every person person will call the one below them.
		int s = sumOfN(n-1); //call the next person to find sum fron 1 to n-1
		//each sumofN(num) has its own personal memory with its own variable s.
		
		//when method hits bottom and start returning(going up) everyone will do their part and return to the next
		return s + n; //i do my part and add n to the number the previous person gave me
		
	}
	
	//FACTORIAL
	int factorial(int n){ //find n factorial
		if(n == 1){//base case
			return 1;
		}
		
		int s = factorial(n-1);//call the next person to do his part
		
		return s*n; //i do my part
		
	}
	
	//FIBONACCI SEQUENCE 
	int fseq(int n){ // find nth term in the fibonacci sequence(starting at 1)
		//fib sequence:
		//n is the nth element in the fib sequence
		//f(n) = f(n-1) + f(n-2) provided n > 2
		//if f(1) or f(2) then f(1) = f(2) = 1
		//1 1 2 3 5 <-- first two numbers are one
		
		if(n == 1 || n == 2){ //base case
			return 1;
		}
		
		int a = fseq(n-1) + fseq(n-2); 
		
		return a;
		 	
	}
	
	// METHODS TO REVERSE STRING
	String reverseString(String s){//reverse a string
		//use substring() method
		if(s.length() == 1){ //one character in the string
			return s;
		}
		
		 String a = s.substring(1); //I chop of the first letter
		 reverseString(a); //I give the remainder of the string to you to reverse it
		 
		 //method begins returning values for String a and that value(a) is used on the previous reverseString()'s process
	
		 
		 return a + s.charAt(0);//once I get the remainder of the string from you(which is now reversed), I add the chopped of letter at the end
		
	}
	
	public void reverseStr(String st){
		//base case
		if(st.length() == 0) return;//if the string length is zero we return
		
		String temp = st.substring(1); //I chop of the first letter of the string
		//I hold the first letter and wait for you to reverse the string
		reverseStr(temp);//you reverse the remainder of the string
		
		System.out.print(st.charAt(0)); //I add the chopped of letter to the remainder(which is now reversed)
		
		return;
	}
	
	//STAIR PROBLEM
	//there is a stair with n steps
	//each time, we can jump one step or two steps
	//find out how many different ways to go up to the nth step
	
	//f(n) is the number of different ways to get to the top
	//multiplicative principle of combination
	//f(n) = f(n-1) + f(n-2)
	
	//similar to fibonacci sequence but the return values for base case is different
	int stair(int n){
		//base cases
		if(n == 1) return 1; //at the first step you cannot calculate f(n-1) or f(n-2) cus then you go to negative steps
		if(n == 2) return 2; //at the second step you CAN do f(n-1) but f(n-2) brings you to negative steps
		//these base cases are exceptions to the f(n)=f(n-1)+f(n-2) rule so they must be caught when going down the recursive chain
		
		return stair(n-1) + stair(n-2); 
		//to get to f(n) you must either be at f(n-1) or f(n-2). In either cases there is only
		//one more way left to get to f(n)
		//Proof:
		//at f(n-1) there is one way to get to f(n)
		//at f(n-2) there is technically two more ways to get to f(n),a large two step or two single steps,
		//but if you take two single steps the first step you take will land on the step f(n-1) which is already calculated by f(n-1)
		//so there is one way from f(n-2) to f(n) which involves taking a large two step.
	}
	
	//TOWER PROBLEM
	//move all disks from A to C without a larger disk on a smaller disk
	
	//ask another guy to move n-1 disks to C using B
	//that guy asks another guy to move n-2 disks to C using A(cus all the disks are piled on B)
	public void moveDisk(int n, char a, char b, char c){//a,b,c are poles
		//first parameter is source, third parameter is destintion, second parameter is helper
		//base case(one disk)
			if(n==1){//when there is one disk left all you have to do is move it from a to c
				System.out.println("Move a disk from "+a+" to "+c);
				return;
			}
		moveDisk(n-1,a,c,b); //move n-1 disks from a to b with the help of c
		//a is source and b is destination
		System.out.println("Move a disk from "+a+" to "+c);
		
		moveDisk(n-1,b,a,c); //move from the source(b) to destination(c) with the help of a
		
		return;
	}
	/* Grid
	 f(m,n) = f(m-1,n) + f(m,n-1)
	 */
	/*
	 Modified/expansion/second assignment/next level:
	 User will input dimenstions of grid(number of points)
	 User will input the number of obstacles they want
	 User will input coordinates of obstacles
	 ORIGIN CAN'T be blocked!!!
	 PAY ATTENTION TO BASE CASE!!!
	 */
	public int grid(int m,int n){//m and n are # of points on x and y axis.
		//every recursive iteration creates smaller grid 
		
		//base case
		if(m == 0 || n == 0){//you'll never get to (0,0) cus u have to enter 0,1 or 1,0 and then this base case will catch you
			return 1; //one way to get to the two adjacent points
		}
		//otherwise add the possibilities of two adjacent points
		else{
			return grid(m-1,n) + grid(m,n-1);
		}
		
	}
	//two dimensional array of obstacles
	boolean[][] blockArray;
	int m,n;
	//input
	public void input(){
		Scanner sc = new Scanner(System.in);
		//dimensions of grid # of points
		 m = sc.nextInt();
		 n = sc.nextInt();
		//initialize all coordinates to unblocked(false)
		blockArray = new boolean[m+1][n+1];//arrays start counting at 0
		//from 0 to m,n
		for(int i=0;i<=m;i++){
			for(int j=0;j<n;j++){
				blockArray[i][j] = false; //unblocked by default
			}
		}
		//inputting obstacles
		int k = sc.nextInt();//# of blocks
			for(int i = 0;i<k;i++){
				//sketchy input for array(new stuff)
				blockArray[sc.nextInt()][sc.nextInt()] = true;//reads row input and then column input and set an obstacle there
			}
		
	}
	public int grid2(int m, int n){
		if(blockArray[m][n] == true){//if blocked
			return 0;
		}
		//the default base case is different than the normal grid() one
		//you must consider the fact that one of the blocks might be along m=0 or n=0, so you don't want one of the neighbouring point to return 1
		//if there is a block on the m=0 or n=0 line, all points past(bigger) those blocks on the same line must return 0
		if(m==0){//case 1: along the m=0 line if theres a block
			for(int i=0;i<=n;i++){//sweeps through the entire line
				if(blockArray[0][i] == true){//check if there are blocks on the line
					return 0;//if the block's position returns 0 then you are effectively returning 0 for all points to the left of the block on the m=0 line
				}
			}
			return 1;//else if its safe and no blocks then return 1
		}
		//all points pass block on the line return 0
		if(n==0){//case 2:along the n=0 line if theres a block
			for(int i=0;i<=m;i++){
				if(blockArray[i][0] == true){
					return 0;
				}
			}
			return 1;//else if its safe and no blocks then return 1
		}
		
		return grid2(m-1,n) + grid2(m,n-1);//just like the previous grid() assignment 
	}
	
	//to call f(x) how much times is f(y) is called
	//condition: x > y > 1
	public int timesToCallFM(int x,int y){
		if(x == y){
			//checking for if x is equal to y
			//also check if x is less than y(below)
			//called f(y) one time
			return 1;
		}
		if(x < y){
			//you went beyond, stop calling now
			return 0;
		}
		
		return timesToCallFM(x-1,y) + timesToCallFM(x-2,y);//just like the fibonnaci sequence
		//you are narrowing down the fibonnacci branching tree and checking for y's
	}
	public static void main(String[] args){
		Recursion r = new Recursion();
		/*System.out.println(r.sumOfN(5));
		System.out.println(r.factorial(6));
		System.out.println(r.fseq(10));
		System.out.println(r.reverseString("hello"));
		r.reverseStr("abcd");
		System.out.println("");
		System.out.println(r.stair(4));*/
		//r.moveDisk(4,'A','B','C');
		
		/*Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(r.grid(3, 3));*/
		
		r.input();
		System.out.println(r.grid2(r.m, r.n));//for a 4x4 grid cus we started counting at 0
		//System.out.println(r.timesToCallFM(7, 4));
		
	}
}
