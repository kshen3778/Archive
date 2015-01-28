package test4;

public class MergeSorting {

	/*
	 Merge sorting arranges a list of data in ascending or descending order.
	 If you use the classic sorting it is O(n^2) running time(which is too much)
	 O(n log n) is the best sorting algorithm(base 2 log)
	 Merge sorting is in O(n log n) runtime so its a good algorithm.
	 
	 Recursive algorithm, please google for more details. Hard to explain.
	 */

	int[] num;
	
	public MergeSorting(){
		num = new int[1000];
		for(int i=0; i<num.length; i++){
			num[i] = (int)(Math.random()*10000 - 5000);
		}
	}
	
	
	//merge list a and b in ascending order
	//PRECONDITION: Lists a and b must be in ascending order(sorted)
	//POSTCONDITION: Lists a and b are merged into c in ascending order(sorted)
	public void merge(int[] a, int[] b, int c[]){
		//both a and b are in ascending order and store in c(assuming c can hold everything)
		int i=0, j=0, k=0;//i is index of a, j is b, k is c
		while(i<a.length && j<b.length ){
			if(a[i] <= b[j]){
				c[k] = a[i]; //keep the smaller one
				i++;//next index of a
				k++;//next spot avaliable in c
			}
			else{
				c[k] = b[j];
				j++;//next index of b
				k++;//next spot avaliable in c
			}
		}
		
		//finish a or b
		//in case one of the list is longer than the other
		//we dont know which is longer so two while cases
		while(i<a.length){
			c[k] = a[i];
			i++;
			k++;
		}
		while(j<b.length){
			c[k] = b[j];
			j++;
			k++;
		}
		
		//yay so thats merge sorting!
	}
	
	public void merge(int[] a,int abegin, int bbegin, int end){
		//the array is divided in half(list a and list b)
		//one array. merge the lists.
	}
	
	//divides the list into smaller lists(recursive)
	//begin and end are the start and endpoints of the list
	//like in binary search
	public void mergesort(int[] a){
		//base case
		if(a.length < 2){//ones element in array doesn't need sorting
			return;
		}
		int mid = a.length / 2;
		int[] left = new int[mid];
		int[] right = new int[a.length - mid];
		//fill left and right arrays
		for(int i=0; i<mid-1; i++){
			left[i] = a[i];
		}
		for(int i=mid; i<a.length-1; i++){
			right[i] = a[i];
		}
		mergesort(right);
		mergesort(left);
		merge(left,right,a);
		
		
	}
	
	
	public static void main(String[] args) {
		MergeSorting ms = new MergeSorting();
		int[] test = {-2,0,4,8,15,18};
		int[] test2 = {-3,1,2,9};
		int result[] = new int[10];
		ms.merge(test, test2, result);
		for(int l=0; l<result.length; l++){
			System.out.println(result[l]);
		}
		
	}

}
