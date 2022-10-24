package org.sciopsh.TDDDojo;

public class SumStrings {
	public static int solve(String s) {
		
		if(nullOrEmpty(s)) return 0;
		
		char separator = ',';
		if(s.charAt(0) == '/') {
			separator = s.charAt(2);
			s = s.substring(4);
		}
		
		if(nullOrEmpty(s)) return 0;
		
		checkLastIsNumber(s);
		
		int ans = 0;
		
		for(String str : s.split(String.format("[%c\n]", separator)))
			ans += solveIndividual(str);
		
		return ans;
	}

	private static boolean nullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}

	private static void checkLastIsNumber(String s) {
		char last = s.charAt(s.length() - 1);
		if(last < '0' || last > '9') throw new IllegalArgumentException();
	}

	private static int solveIndividual(String s) {
		if(s.length() == 0) return 0;
		int ans = Integer.parseInt(s);
		if(ans < 0) throw new IllegalArgumentException();
		return ans;
	}
}
