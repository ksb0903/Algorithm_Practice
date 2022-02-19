package day1_rec_arr;

public class R1_Array {
	static int arr[] = {10, 20, 30, 40};
	
	public static void printArray(int idx) {
		System.out.print(arr[idx] + " ");
		if(idx==arr.length-1) return;
		else {
			printArray(idx+1);
		}
	}
	
	public static void main(String[] args) {
		printArray(0);
	}
}
