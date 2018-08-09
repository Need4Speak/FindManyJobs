package interview;

/**
 * 伪递归
 * 
 * @author I353561
 *
 */
public class TailRecursion {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(simpleFactorial(10));
		long endTime = System.nanoTime();
		System.out.println("simpleFactorial run time: " + (endTime - startTime));

		startTime = System.nanoTime();
		System.out.println(tailRecursionFactorial(1, 10));
		endTime = System.nanoTime();
		System.out.println("tailRecursionFactorial run time: " + (endTime - startTime));
	}

	public static int simpleFactorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * simpleFactorial(n - 1);
	}

	public static int tailRecursionFactorial(int result, int n) {
		if (n == 1)
			return result;
		else {
			return tailRecursionFactorial(result * n, n - 1);
		}
	}
}
