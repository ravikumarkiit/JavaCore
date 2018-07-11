import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ThreeDimensionalArray {
	
	public static void main(String[] args) {
		int[] arr1D = {1,2};
		int[][] arr2D = {arr1D, arr1D};
		int[][][] a = {arr2D, arr2D, arr2D};
//		int[][][] a = { {{1,2},{3,4}}, {{1,2},{3,4}}, {{1,2},{3,4}}};
		
		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[1].length);
		System.out.println(a[2].length);
		
		for(int i = 0; i<a.length; i ++) {
			for(int j = 0; j< a[i].length; j++) {
				for(int k = 0; k < a[i][j].length; k++) {
					System.out.print(a[i][j][k]+"\t");
				}
				System.out.println("\n");
			}
			System.out.println("\n");
		}
		
		List<Integer> list = new ArrayList<>();
		//Collect in List
		for(int i =0; i< a.length; i++) {
			for (int j =0; j <a[i].length; j++) {
				for (int k =0; k <a[i][j].length ; k++) {
					list.add(a[i][j][k]);
				}
			}
		}
		
		list.stream().sorted(Comparator.comparing(Function.identity(), Comparator.naturalOrder())).limit(5).forEach(System.out::println);
		
	}

}
