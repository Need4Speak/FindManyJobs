package point2offer;

public class JumpFloorII_9 {
	public int JumpFloorII(int target) {
		if (0 == target) {
			return 0;
		} else if (1 == target) {
			return 1;
		} else {
			int a1 = 1;
			int a2 = 2;
			while ((target--) > 2) {
				a2 = 2 * a2;
				a1 = a2 / 2;
			}
			return a2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpFloorII_9 jum = new JumpFloorII_9();
		System.out.println(jum.JumpFloorII(4));
	}
}
