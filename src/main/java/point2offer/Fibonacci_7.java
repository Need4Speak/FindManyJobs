package point2offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * @author I353561
 */
public class Fibonacci_7 {

    public int Fibonacci(int n) {
    	if(0 == n) {
    		return 0;
    	} else if(1 == n || 2 == n) {
    		return 1;
    	} else {
    		int a1 = 1;
    		int a2 = 1;
    		int temp;
    		for(int i = 2; i < n; i++) {
    			temp = a2;
    			a2 = a1 + a2;
    			a1 = temp;
    		}
    		return a2;
    	}
 
    }
	public static void main(String[] args) {
		Fibonacci_7 fib = new Fibonacci_7();
		System.out.println(fib.Fibonacci(2));

	}

}
