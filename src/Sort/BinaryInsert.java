package Sort;

// Binary insert.
public class BinaryInsert {

	public static void main(String[] args) {
		for (int i : sort(new int[] { 1, 2, 9, 5, 78, 8, 4 })) {
			System.out.println(i);
		}
	}

	public static int[] sort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int left = 0, right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (arr[mid] < temp) {
					left = mid + 1;
				} else if (arr[mid] > temp) {
					right = mid - 1;
				}
			}
			for (int j = i - 1; j > left; j--) {
				arr[j + 1] = arr[j];

			}
			arr[left] = temp;
		}
		return arr;
	}
}
