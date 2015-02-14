package test6;

import java.util.Random;
//Binary Tree Array form
//write a program to generate 100 numbers from 0-1000 and put it into a complete binary tree in array
//and then traverse the tree
public class BSTPractice {
	
	int[] bt;
	public BSTPractice(int n){
		bt = new int[n+1];
		
	}
	public void buildTree(){
		for(int i=1;i<bt.length;i++){
			bt[i] = (int)(Math.random()*1000);
			System.out.print(bt[i] + " ");
		}
	}
	//In Order traversing
	public void inOrderTrav(int i){
		//base case
		if(i >= bt.length) return; 
		
		//i is root
		inOrderTrav(i*2);//left kid
		System.out.print(bt[i] + " ");
		inOrderTrav(i*2+1);//right kid
		System.out.print(bt[i] + " ");
	}
	//By Level Traversing
	public void byLevelTrav(){
		for(int i=1;i<bt.length;i++){
			System.out.print(bt[i] + " ");
		}
	}
	public static void main(String args[]){
		BSTPractice btree = new BSTPractice(3);
		btree.buildTree();
		//btree.byLevelTrav();
		System.out.println();
		btree.inOrderTrav(1);
		
	}

}
