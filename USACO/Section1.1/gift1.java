import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: kevin.s5
LANG: JAVA
TASK: gift1
*/
public class gift1 {
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		
		int people = Integer.parseInt(in.readLine());
		//in.readLine();
		
		String[] names = new String[people];
		int[] networth = new int[people];
		
		for(int i=0; i < names.length; i++){
			names[i] = in.readLine();
		}
		
		/*//debug
		System.out.println(people);
		for(String n: names){
			System.out.println(n);
		}*/
		
		for(int count=0; count < people; count++){
			String person = in.readLine();
			
			String data = in.readLine();
			int initial = Integer.parseInt(data.split(" ")[0]);
			int receivers = Integer.parseInt(data.split(" ")[1]);
			/*int initial = Integer.parseInt(in.readLine());
			int receivers = Integer.parseInt(in.readLine());*/
			//in.readLine();
			
			
			int remainder;
			int gift;
			
			if(receivers != 0){ //catch divide by zero
				remainder = initial % receivers;
				System.out.println(remainder);
				gift = initial / receivers;
			}else{
				remainder = initial;
				gift = initial;
			}
			//gave away a chunk if his/her net worth
			for(int i=0; i<names.length; i++){
				if(names[i].equals(person)){
					networth[i] -= initial; //deduct giving
					networth[i] += remainder; //add on leftover
				}
			}
			
			//add to receiver's net worth
			for(int x=0; x<receivers; x++){
				String name = in.readLine();
				for(int i=0; i<names.length; i++){
					if(names[i].equals(name)){
						networth[i] += gift;
					}
				}
			}
		}
		
		//print out name and net worth
		for(int p=0; p<names.length; p++){
			out.println(names[p] + " " + networth[p]);
		}
		
		
		out.close();
	    System.exit(0);
	}
}
