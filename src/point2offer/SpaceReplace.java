package point2offer;

public class SpaceReplace {

	public static void main(String[] args) {
		
		String testStr = "We Are Happy.";
		System.out.println(replace(testStr));
	}
	
	public static String replace(String str) {
		StringBuilder builder = new StringBuilder();
		int length = str.length();
		for(int index = 0; index < length; index++) {
			char element = str.charAt(index);
			if( element != ' ') {
				builder.append(element);
			} else {
				builder.append("20%");
			}
		}
		return builder.toString();		
	}

}
