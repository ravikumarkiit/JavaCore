package sort;

/**
 * Time Complexity: O(n*n)
 * Auxiliary Space: O(1)
 * @author Ravi
 *
 */
public class InsertionSort {

	public int[] insertionSort(int[] arr) {

		for(int i =1; i< arr.length ;  i++) {
			int index = -1;
			while(index++ < i) {
				while(arr[i] < arr[index]) { // Start shifting when the smaller element  is found
					int start = index;
					int end = i;
					int Key = arr[i];
					while(start < end) {
						arr[end] = arr[end-1];
						end--;
					}
					arr[start] = Key;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int arr[] = {9,7,6,15,16,5,10,11};
		arr = is.insertionSort(arr);
		int i =0;
		while(i < arr.length){
			System.out.println(arr[i]);
			i++;
		}
	}

}
