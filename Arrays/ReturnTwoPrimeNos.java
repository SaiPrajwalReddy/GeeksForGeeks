package Arrays;

public class ReturnTwoPrimeNos {

	public static void main(String[] args) {
		int n = 74;
		findPrimePair(n);
	}

	private static void findPrimePair(int n) {
		// TODO Auto-generated method stub
		boolean isPrime[] = new boolean[n + 1];

		generatePrimes(n, isPrime);

		for (int i = n; i >= 0; i--) {
			if (isPrime[n - i] && isPrime[i]) {
				System.out.println("The 2 pairs are " + (n - i) + " " + i);
				break;
			}
		}
	}

	private static void generatePrimes(int n, boolean[] isPrime) {
		// TODO Auto-generated method stub
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= n; i++)
			isPrime[i] = true;
		for (int i = 2; i * i < n; i++) {

			if (isPrime[i] = true) {				
				for (int k = i*i; k <= n; k = k + i) {
					isPrime[k] = false;
				}
			}
		}

		for (int i = 0; i < n; i++)
			if (isPrime[i]);
				//System.out.print(i + " ");
	}
}
