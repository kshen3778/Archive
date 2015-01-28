package test4;

import java.util.*;
//Set interface
//given two arrays, combine them into another array and remove duplicates
public class SetExample {
	
	public static void main(String args[]){
		//input
		Scanner sc = new Scanner(System.in);
		Set<Integer> s1 = new TreeSet<Integer>();
		int n = sc.nextInt();
		for(int i=0;i<n; i++){
			s1.add(sc.nextInt());
		}
		Set<Integer> s2 = new HashSet<Integer>();
		int m = sc.nextInt();
		for(int i=0;i<m;i++){
			s2.add(sc.nextInt());
		}
		
		
		s1.addAll(s2); //union
		//s1.retainAll(s2); //intersection
		
		//output new set
		for(Integer in: s1){
			System.out.println(in + "");
		}
	}
}
