package test4;

import java.util.*;
public class QueueExample {
	/*
	 * Is another abstract data structure.
	 First in first out
	 (more like a pipe)
	 The first obj you put in comes out the other end.
	 NOTE: Queue is an interface and not a class in Java(so no constructor)
	 The LinkedList class implements the Queue interface
	 */
	public static void main(String args[]){
		Queue<String> qu = new LinkedList<String>();
		
		for(int i=0; i<10; i++){
			qu.offer(i+"");
		}
		
		while(!qu.isEmpty()){
			System.out.println(qu.poll());
		}
	}
}
