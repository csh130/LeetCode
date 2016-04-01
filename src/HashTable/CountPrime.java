package HashTable;

//count prime number within number n
public class CountPrime {
	public int countPrimes(int n) {
		boolean isPrime[] = new boolean[n]; // default all are false
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!isPrime[i]) {
				count++;
				// careful here, i*j <n
				for (int j = 2; i * j < n; j++) {
					isPrime[i * j] = true;
				}
			}
		}
		return count;
	}
}
