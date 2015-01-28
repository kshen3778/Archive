package test4;

import java.util.*;
public class StackExample {
	/*
	 Stack is an abstract data structure 
	 Stack:
	 First in last out(like stacking plates)
	 */
	public static void main(String args[]){
		//create a stack of integers
		Stack<Integer> si = new Stack<Integer>();
		
		//fill the stack
		for(int i=0;i<10;i++){
			si.push(i); //fill the stack with ints from 0-9
		}
		
		//pop out all the stuffs
		while(!si.isEmpty()){
			int temp = si.pop();
			System.out.println(temp);
		}
	}
}
