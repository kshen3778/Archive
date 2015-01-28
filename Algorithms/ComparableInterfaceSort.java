package test4;
//sort objects
//creating objects that store the data
//compare the data in the objects
import java.util.*;
public class Sort2 {
	StudentMarks[] sm;
	
	public Sort2(int size){
		sm = new StudentMarks[size];
		
	}
	public static void main(String[] args){
		Sort2 so = new Sort2(5);
		so.sm[0] = new StudentMarks("peter",100);
		so.sm[1] = new StudentMarks("tom",93);
		so.sm[2] = new StudentMarks("hash",60);
		so.sm[3] = new StudentMarks("john",88);
		so.sm[4] = new StudentMarks("juan",70);
	
		
		Arrays.sort(so.sm);
		
		for(int i = 0;i<so.sm.length; i++){
			System.out.println(so.sm[i].name + " "+ so.sm[i].mark);
		}
	}
	
	//inner class
	public static class StudentMarks implements Comparable<StudentMarks>{
		String name;
		int mark;
		public StudentMarks(String s,int m){
			name = s;
			mark = m;
		}
		
		public int compareTo(StudentMarks st) {
			if(mark > st.mark) return 1;
			if(mark < st.mark) return -1;
			return 0; //if marks are equal
		}
	}

}
