package test4;

import java.util.Queue;

public class LinkedListExample {
	
	public class DataNode{
		public int value;
		public DataNode next; //reference to the next node in the list
		
		public DataNode(int a, DataNode n){
			value = a;
			next = n;
		}
		
		//unused?
		public void setNext(DataNode n){
			next = n;
		}
		
	}
	
	public DataNode head;
	
	
	public void buildList(){ //build list backwards
		int n = 0;
		DataNode temp = null;
		//linkedlist with 10 elements with values 0-9
		while(n < 10){
			temp = new DataNode(n, temp);
			n++;
		}
		head = temp;
		
		
	}
	
	public void traverseList(DataNode h){
		while(h != null){
			System.out.println(h.value);
			h = h.next;
		}
	}
	
	public void buildListForward(){ //build list forwards
		int n = 0;
		
		head = new DataNode(n, null);//create the head
		//the head takes the value of 0 so we increment n
		n++; //n is one cus 0 was taken by head
		DataNode temp = head;
		
		while(n<10){
			DataNode temp2 = new DataNode(n, null);
			temp.next = temp2;
			//bump down the head shortening the list
			temp = temp2; //move the location of temp to the newly create node(temp2)
			n++;
			//temp2 is used to create our nodes, then they are assigned to temp.next
		}
	}
	
	public void outputLastNodeValue(){
		//assignment
		//output the value of the last node in the forward list
		//last value should be 9
		DataNode a = head;
		while(a.next != null){
			a = a.next;
		}
		System.out.println("Last node value: "+a.value);
		
		
	}
	
	public void insertBefore(int a, int b){
		//PROBLEM: If the node containing a is the head node then we need to make a method for adding a head to the list
		
		//insert a node with value b before a node with value a (assuming all nodes have different values)
		DataNode h = head;
		
		if(head.value == a){
		     head = new DataNode(b, h); // create a new node and attach it to the old value of head
		}else{


		//traverse through the list
			while(h != null && !(h.next.value == a)){ 
			
				h = h.next;
			}
		//create a node with value b pointing to the next one
			DataNode node = new DataNode(b, h.next);//at this point h.next is the node containing a
		//sever the old link between h and h.next and attach h to the new node
		
			h.next = node;//reattach h to node
		}
		
	}
	
	public void insertAfter(int a, int b){
		//insert a node with value b after a node with value a (assuming all nodes have different values)
				DataNode h = head;
				//traverse through the list
				while(h != null && !(h.value == a)){
					
					h = h.next;
				}
				//create a node with value b pointing to the next one
				DataNode node = new DataNode(b, h.next);//at this point h.next is the node after the one containing a
				//sever the old link between h and h.next and attach h to the new node
				
					//make the pointer of h point to the new node
					h.next = node;//reattach h to node. the next node is now the new node instead of h.next
	}
	
	public void deleteNode(int a){
		DataNode h = head;
		while(h.next.value != a && h.next != null){
			//System.out.println(h.value);
			h = h.next;
		}
		
		h.next = h.next.next;
	}
	
	public void outputListBackWards(){
		
	}
	
	public void reverseList(){ //reverse list using recursion
		
		
	}
	
	public static void main(String[] args){
		//create a list and outputs it backwards
		LinkedListExample backward = new LinkedListExample();
		backward.buildList();
		backward.traverseList(backward.head);
		
		System.out.println();
		
		LinkedListExample forward = new LinkedListExample();
		forward.buildListForward();
		forward.traverseList(forward.head);
		forward.outputLastNodeValue();
		
		LinkedListExample test = new LinkedListExample();
		test.buildListForward();
		test.insertBefore(0, 100);
		test.insertAfter(9, 200);
		test.deleteNode(8);
		test.traverseList(test.head);
		
		}
}
