package test4;

public class StringBuilderExample {
	
	public static void main(String args[]){
		String str = "Hello world";
		StringBuilder s = new StringBuilder(str);
		
		s.insert(6, 'r');//insert a character after an offset of 6
		//Hello rworld
		
		//new string: Hello rworld
		s.replace(10, 11, "c");//replace second last letter of Hello rworld
		//Hello rworcd
		System.out.println(s);
		
	}
}
