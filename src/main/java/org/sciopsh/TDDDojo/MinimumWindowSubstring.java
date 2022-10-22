package org.sciopsh.TDDDojo;

public class MinimumWindowSubstring {
	
	public static String solve(String s, String t) {
		if(s == null || s.length() == 0 || t == null || t.length() == 0) {
			return "";
		}
		
		if(s.length() > 100_000 || t.length() > 100_000) {
			throw new IllegalArgumentException("Both strings must be of length < 100 000");
		}
		
		int[] counts = new int[53];
		
		for(char c : t.toCharArray()) {
			add(counts, c);
		}
		
		int[] baseline = new int[53];
		for(int i = 0; i < 53; i++) {
			baseline[i] = counts[i];
		}
		
		String ans = "";
		boolean multipleSolutions = false;

		for(int i = 0, j = 0; i < s.length(); i++) {
			
			remove(baseline, counts, s.charAt(i));
			
			while(counts[52] == 0) {
				
				if(ans.length() == 0 || ans.length() > i - j + 1) {
					
					ans = s.substring(j, i + 1);
					multipleSolutions = false;
					
				} else if(ans.length() == i - j + 1) {
					
					multipleSolutions = true;
					
				}
				restore(baseline, counts, s.charAt(j++));
				
			}
		}
		
		if(multipleSolutions) {
			throw new IllegalArgumentException("Multiple solutions");
		}
		return ans;
	}
	
	static void add(int[] counts, char c) {
		
		if(c >= 'a' && c <= 'z') {
			
			counts[c - 'a']++;
			
		} else if(c >= 'A' && c <= 'Z') {
			
			counts[c - 'A' + 26]++;
			
		} else {
			throw new IllegalArgumentException("Illegal characters");
		}
		
		counts[52]++;
	}
	
	static void remove(int[] baseline, int[] counts, char c) {
		
		if(c >= 'a' && c <= 'z') {
			
			if(baseline[c - 'a'] > 0) {
				
				counts[c - 'a']--;
				
				if(counts[c - 'a'] >= 0) {
					
					counts[52]--;
					
				}
			}
			
		} else if(c >= 'A' && c <= 'Z') {
			
			if(baseline[c - 'A' + 26] > 0) {
				
				counts[c - 'A' + 26]--;
				
				if(counts[c - 'A' + 26] >= 0) {
					
					counts[52]--;
					
				}
				
			}
			
		} else {
			throw new IllegalArgumentException("Illegal Characters");
		}
		
	}
	
	static void restore(int[] baseline, int[] counts, char c) {
		
		if(c >= 'a' && c <= 'z') {
			
			if(baseline[c - 'a'] > counts[c - 'a']) {
				
				counts[c - 'a']++;
				
				if(counts[c - 'a'] > 0) {
					
					counts[52]++;
					
				}
				
			}
			
		} else if(c >= 'A' && c <= 'Z') {
			
			if(baseline[c - 'A' + 26] > counts[c - 'A' + 26]) {
				
				counts[c - 'A' + 26]++;
				
				if(counts[c - 'A' + 26] > 0) {
					
					counts[52]++;
					
				}
				
			}
			
		} else {
			throw new IllegalArgumentException("Illegal characters");
		}
	}
	
}
