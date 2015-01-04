package test4;

public class BinarySearch {
	
	static int binarySearch(int[] A, int N) {
		int low = 0;
		int high = A.length - 1;
		while (high >= low) {
			int middle = (low + high) / 2;
			if (A[middle] == N) {
				// N has been found at this index!
				return middle;
			}
			else if (A[middle] > N) {
				// eliminate locations >= middle
				high = middle - 1;
			}
			else {
				// eliminate locations <= middle
				low = middle + 1;
			}
		}
		
		return -1;
		}
	
	//test client
	public static void main(String args[]){
		int[] array = {1,2,3,4,5,6};
		//find the position of the number 5 in the array
		System.out.println("Position " + BinarySearch2.binarySearch(array, 5));
		//should output Position 4, which correctly identifies the number 5 at index 4
	}
}
