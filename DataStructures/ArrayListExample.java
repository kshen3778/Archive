package test4;

import java.util.*;
public class ArrayListExample {

	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		
		//you don't need to worry about size
		//however don't load a billion elements because you will run out of memory
		for(int i=0; i<100; i++){
			list.add("Item" +i);
		}
		System.out.println("The arraylist has: " + list); //output arraylist 
		
		int pos = list.indexOf("Item3"); //returns the index of Item3
		System.out.println(pos);
		
		boolean check = list.isEmpty(); //is the list empty or not
		int size = list.size(); //get the list's length
		boolean hasElement = list.contains("Item2"); //does the list contain Item2
		String elementIn0pos = list.get(0); //get the element at the 0th index
		//traverse a list
		for(int i=0; i<list.size(); i++){ 
			System.out.println(list.get(i));
		}
		for(String str : list){
			System.out.println(str);
		}
		/*
		 Iterable<E> interface is implemented by ArrayList<E>.
		 It has one method called iterator() which ArrayList<E> implements.
		 list.iterator() returns an Iterator<E> which can be used to traverse
		 all elements in the list(like a tool).
		 The Iterator<E> interface is not implemented in Iterable<E> however
		 Iterator<E> is implemented by an inner class of ArrayList<E
		 The methods in Iterator<E> can access all the data in ArrayList<E> because
		 it's implemented by an inner class inside the scope of ArrayList<E>; the 
		 inner class must implement all of the interface's method
		 */
		for( Iterator<String> it = list.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
		list.remove(0); //remove an element
		
		ArrayList<Integer> list2 = new ArrayList<Integer>(); //arraylist of ints using wrapper class
		list2.add(3); //autoboxes 3 into new Integer(3)
		int v = list2.get(0); //auto unboxes 3 into an Integer
		//Java compiler supports autoboxing and auto unboxing
		
		
	}
}
