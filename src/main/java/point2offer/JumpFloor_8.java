package point2offer;
/*
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor_8 {

	public int JumpFloor(int target) {
		if (0 == target) {
			return 0;
		} else if (1 == target) {
			return 1;
		} else if (2 == target) {
			return 2;
		} else {
			int a1 = 1;
			int a2 = 2;
			while ((target--) > 2) {
				a2 = a1 + a2;
				a1 = a2 - a1;
			}
			return a2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpFloor_8 jum = new JumpFloor_8();
		System.out.println(jum.JumpFloor(3));
	}

}
