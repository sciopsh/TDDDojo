package org.sciopsh.TDDDojo;

public class StringArraysEquivalency {
	public static boolean solve(String[] a, String[] b) {
		
		checkNulls(a, b);
		
		checkArraysTooBig(a, b);
		
		int totalA = getTotal(a), totalB = getTotal(b);
		
		checkTotalsTooBig(totalA, totalB);
		
		if(totalA != totalB) {
			return false;
		} else if(totalA == 0) {
			return true;
		}
		
		return compareLetterByLetter(a, b);
	}

	private static void checkNulls(String[] a, String[] b) {
		if(a == null || b == null) {
			throw new IllegalArgumentException("Arguments shouldn't be null");
		}
	}

	private static void checkArraysTooBig(String[] a, String[] b) {
		if(a.length > 1000 || b.length > 1000) {
			throw new IllegalArgumentException("Arrays should't be of size > 1000");
		}
	}

	private static int getTotal(String[] arr) {
	int total = 0;
		for(String s : arr) {
			total += s.length();
		}
		return total;
	}

	private static void checkTotalsTooBig(int totalA, int totalB) {
		if(totalA > 1000 || totalB > 1000) {
			throw new IllegalArgumentException("total amounts of chars shouldn't be > 1000");
		}
	}

	private static boolean compareLetterByLetter(String[] a, String[] b) {
		int ia = 0, ja = 0, ib = 0, jb = 0;
		while(ia < a.length || ib < b.length) {
			if(ia >= a.length || ib >= b.length) return false;

			if(a[ia].charAt(ja) < 'a' || a[ia].charAt(ja) > 'z')
				throw new IllegalArgumentException("Only lowercase letters are allowed");
			if(b[ib].charAt(jb) < 'a' || b[ib].charAt(jb) > 'z')
				throw new IllegalArgumentException("Only lowercase letters are allowed");
			if(a[ia].charAt(ja) != b[ib].charAt(jb)) return false;
			ja++;
			while(ia < a.length && ja >= a[ia].length()) {
				ja = 0;
				ia++;
			}
			jb++;
			while(ib < b.length && jb >= b[ib].length()) {
				jb = 0;
				ib++;
			}
		}
		return true;
	}
}
