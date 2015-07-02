

import java.io.*;
import java.util.Scanner;

/*
ID: kevin.s5
LANG: JAVA
TASK: ride
*/
class ride {
	
	public static void main(String args[]) throws IOException{
		 BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		 
		 String comet = f.readLine();
		 String group = f.readLine();
		 
		 int cometproduct = 1;
		 for(int i=0; i<comet.length(); i++){
			 char c = comet.charAt(i);
			 int ascii = c - 'A' + 1; //convert to a number
			 cometproduct *= ascii;
		 }
		 
		 int groupproduct = 1;
		 for(int i=0; i<group.length(); i++){
			 char c = group.charAt(i);
			 int ascii = c - 'A' + 1; //convert to a number
			 groupproduct *= ascii;
		 }
		 
		 if(cometproduct % 47 == groupproduct % 47){
			 out.println("GO");
			 
		 }else{
			 out.println("STAY");
			 
		 }
		 out.close();
		 System.exit(0);
	}
}
