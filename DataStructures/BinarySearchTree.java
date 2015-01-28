package test4;

import java.util.Scanner;
import java.util.Stack;

//BST demonstration
//creation,insertion,deletion,search
//http://poj.org/problem?id=1577
//POJ problem 1577 binary tree with letters
public class BinarySearchTree {
	//inner class
	public class TreeNode{
		public char value;
		public TreeNode leftKid;
		public TreeNode rightKid;
		public TreeNode(char v){
			value = v;
			leftKid = null;
			rightKid = null;
		}
	}
	
	//insert a node with value k into the tree
	public void insert(TreeNode root, char k){
		//suppose root is not null
		if(root.value > k){
			if(root.leftKid == null){
				root.leftKid = new TreeNode(k);
				return;
			}
			
			insert(root.leftKid,k);
			
		}
		else{
			if(root.rightKid == null){
				root.rightKid = new TreeNode(k);
				return;
			}
			
			insert(root.rightKid,k);
		}
	}
	
	//preorder traversal
	public void preOrder(TreeNode root){
		if(root == null) return;
		System.out.println(root.value + " ");
		
		preOrder(root.leftKid);
		preOrder(root.rightKid);
	}
	
	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree();
		//input
		Scanner sc = new Scanner(System.in);
		Stack<String> input = new Stack<String>();
		
		while(true){
			String s = sc.nextLine();
			if(!s.equals("*")){
				input.push(s);
			}
			break;
		}
		
		//build the tree
		char[] rootnode = input.pop().toCharArray();
		BinarySearchTree.TreeNode root = bst.new TreeNode(rootnode[0]); //root
		
		//pop the stack empty and fill the tree
		while(input.isEmpty() == false){
			char[] nodes = input.pop().toCharArray();
			//insert all the nodes
			for(int i=0;i<nodes.length; i++){
				bst.insert(root, nodes[i]);
			}
		}
		
		//output the preorder traversal
	}
}
