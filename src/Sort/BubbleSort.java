package Sort;

public class BubbleSort {
	public static void main(String[] args) {
		for (int i : sort(new int[] { 1, 2, 9, 5, 78, 8, 4 })) {
			System.out.println(i);
		}
	}

	public static int[] sort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			// arr.length-i is because after loop i times, the i to length-1
			// already been biggest number, don't need to sort again
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		return arr;
	}
}
