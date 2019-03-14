package br.com.softblue.loucademia.application.util;

public class StringUtils {

	public static boolean isEmpty(String s) {
		if (s == null) {
			return true;
		}
		
		return s.trim().length() == 0;
	}
	
	public static String leftZeroes(int value, int finalSize) {
		return String.format("%0" + finalSize + "d", value);
	}
	
	public static void main(String[] args) {
		String str = "  a   ";
		
		boolean b = StringUtils.isEmpty(str);
		System.out.println(b);
		
		int v = 12345;
		System.out.println(StringUtils.leftZeroes(v, 8));
	}
}
