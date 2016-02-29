package Sort;

public class SelectionSort {

	public static void main(String[] args) {
		for (int i : sort(new int[] { 1, 2, 9, 5, 78, 8, 4 })) {
			System.out.println(i);
		}
	}

	// for every element, select minimum element, after i ( i+1 to length-1),
	// and swap the minimum element with arr[i]
	public static int[] sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			int min = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					minIndex = j;
				}
			}
			min = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = min;
		}
		return arr;
	}
}
