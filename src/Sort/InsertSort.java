package Sort;

//Direct Insert sort.
public class InsertSort {

	public static void main(String[] args) {
		for (int i : sort(new int[] { 1, 2, 9, 5, 78, 8, 4 })) {
			System.out.println(i);
		}
	}

	public static int[] sort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			// loop from i-1 to 0, if arr[j] >temp, move every element
			for (; j >= 0 && temp < arr[i - 1]; j--) {
				if (arr[j] > temp) {
					arr[j + 1] = arr[j];
				} else {
					arr[j + 1] = temp;
					break;
				}
			}
			
		}
		return arr;
	}

}
