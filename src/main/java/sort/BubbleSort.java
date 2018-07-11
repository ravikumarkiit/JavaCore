package sort;

/**
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
Auxiliary Space: O(1)
 * @author Ravi
 *
 */
public class BubbleSort {
	public static void main (String[] args) {
		System.out.println("GfG!");
		/*Bubble Sort*/
		int[] arr = new int[]{1,5,4,3,2,6};
		int count = 0;
		int index = 0;
		int lastIndex = arr.length-1;
		while(count < lastIndex){
			if(arr[count] > arr[count+1]){
				int t= arr[count];
				arr[count] = arr[count+1];
				arr[count+1] = t;
			}
			count++;

			if(count == lastIndex){
				lastIndex--;
				count = 0;
				//		    System.out.println(lastIndex);
			}

		}
		
		int i = 0;
		while(i < arr.length){
			System.out.println("      "+arr[i]);
			i++;
		}
	}
}
