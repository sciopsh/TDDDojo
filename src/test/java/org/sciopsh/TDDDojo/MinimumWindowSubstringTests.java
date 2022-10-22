package org.sciopsh.TDDDojo;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.sciopsh.TDDDojo.MinimumWindowSubstring.*;

public class MinimumWindowSubstringTests {
	
	@Test
	public void solve_SNull_ReturnsEmptyString() {
		assertEquals("", solve(null, "asd"));
	}
	
	@Test
	public void solve_TNull_ReturnsEmptyString() {
		assertEquals("", solve("asd", null));
	}
	
	@Test
	public void solve_STooLarge_Throws() {
		
		String s = new String(new char[100001]);
		
		assertThrows(IllegalArgumentException.class ,()-> solve(s, "asd"));
		
	}
	
	@Test
	public void solve_TTooLarge_Throws() {
		
		String t = new String(new char[100001]);
		
		assertThrows(IllegalArgumentException.class ,()-> solve("asd", t));
		
	}
	
	@Test
	public void solve_SEmpty_ReturnsEmptyString() {
		assertEquals("", solve("", "asd"));
	}
	
	@Test
	public void solve_TEmpty_ReturnsEmptyString() {
		assertEquals("", solve("asd", ""));
	}
	
	@Test
	public void solve_TTooLarge_ReturnsEmptyString() {
		assertEquals("", solve("", "asd"));
	}
	
	@Test
	public void solve_SNonLetters_Throws() {
		assertThrows(IllegalArgumentException.class ,()-> solve("as d", "asd"));
	}
	
	@Test
	public void solve_TNonLetters_Throws() {
		assertThrows(IllegalArgumentException.class ,()-> solve("asd", "awd."));
	}

	@Test
	public void add_a_CorrectlyReturns() {
		int[] counts = new int[53];
		add(counts, 'a');
		assertEquals(1, counts[0]);
		assertEquals(1, counts[52]);
	}
	
	@Test
	public void add_z_CorrectlyReturns() {
		int[] counts = new int[53];
		add(counts, 'z');
		assertEquals(1, counts[25]);
		assertEquals(1, counts[52]);
	}
	
	@Test
	public void add_A_CorrectlyReturns() {
		int[] counts = new int[53];
		add(counts, 'A');
		assertEquals(1, counts[26]);
		assertEquals(1, counts[52]);
	}
	
	@Test
	public void add_Z_CorrectlyReturns() {
		int[] counts = new int[53];
		add(counts, 'Z');
		assertEquals(1, counts[51]);
		assertEquals(1, counts[52]);
	}

	@Test
	public void add_SomeSymbol_Throws() {
		int[] counts = new int[53];
		assertThrows(IllegalArgumentException.class ,()-> add(counts, '*'));
	}
	
	@Test
	public void remove_aExisting_CorrectlyReturns() {
		int[] baseline = new int[53];
		int[] counts = new int[53];
		counts[0]++;
		counts[52]++;
		baseline[0]++;
		baseline[52]++;
		
		remove(baseline, counts, 'a');
		
		assertEquals(0, counts[0]);
		assertEquals(0, counts[52]);
	}
	
	@Test
	public void remove_zExisting_CorrectlyReturns() {
		int[] baseline = new int[53];
		int[] counts = new int[53];
		counts[25]++;
		counts[52]++;
		baseline[25]++;
		baseline[52]++;
		
		remove(baseline, counts, 'z');
		
		assertEquals(0, counts[25]);
		assertEquals(0, counts[52]);
	}
	
	@Test
	public void remove_AExisting_CorrectlyReturns() {
		int[] baseline = new int[53];
		int[] counts = new int[53];
		counts[26]++;
		counts[52]++;
		baseline[26]++;
		baseline[52]++;
		
		remove(baseline, counts, 'A');
		
		assertEquals(0, counts[26]);
		assertEquals(0, counts[52]);
	}
	
	@Test
	public void remove_ZExisting_CorrectlyReturns() {
		int[] baseline = new int[53];
		int[] counts = new int[53];
		counts[51]++;
		counts[52]++;
		baseline[51]++;
		baseline[52]++;
		
		remove(baseline, counts, 'Z');
		
		assertEquals(0, counts[51]);
		assertEquals(0, counts[52]);
	}
	
	@Test
	public void remove_NonExisting_Returns() {
		int[] baseline = new int[53];
		int[] counts = new int[53];
		counts[50]++;
		counts[52]++;
		baseline[50]++;
		baseline[52]++;
		
		remove(baseline, counts, 'Z');
		
		assertEquals(1, counts[50]);
		assertEquals(0, counts[51]);
		assertEquals(1, counts[52]);
	}
	
	@Test
	public void remove_BelowZero_DoesNotChangeTotal() {
		int[] baseline = new int[53];
		int[] counts = new int[53];
		counts[50]++;
		counts[52]++;
		baseline[51]++;
		baseline[52]++;
		baseline[50]++;
		baseline[52]++;
		
		remove(baseline, counts, 'Z');
		
		assertEquals(1, counts[50]);
		assertEquals(-1, counts[51]);
		assertEquals(1, counts[52]);
	}

	@Test
	public void remove_SomeSymbol_Throws() {
		int[] baseline = new int[53];
		int[] counts = new int[53];
		assertThrows(IllegalArgumentException.class ,()-> remove(baseline, counts, '*'));
	}
	
	@Test
	public void restore_aExisting_CorrectlyReturns() {
		int[] counts = new int[53];
		int[] baseline = new int[53];
		baseline[0]++;
		baseline[52]++;
		
		restore(baseline, counts, 'a');
		
		assertEquals(1, counts[0]);
		assertEquals(1, counts[52]);
	}
	
	@Test
	public void restore_NonExisting_CorrectlyReturns() {
		int[] counts = new int[53];
		int[] baseline = new int[53];
		baseline[0]++;
		baseline[52]++;
		
		restore(baseline, counts, 'Z');
		
		assertEquals(0, counts[0]);
		assertEquals(0, counts[51]);
		assertEquals(0, counts[52]);
	}
	
	@Test
	public void restore_Full_CorrectlyReturns() {
		int[] counts = new int[53];
		int[] baseline = new int[53];
		baseline[0]++;
		baseline[52]++;
		counts[0]++;
		counts[52]++;
		
		restore(baseline, counts, 'a');
		
		assertEquals(1, counts[0]);
		assertEquals(1, counts[52]);
	}
	
	@Test
	public void restore_BelowZero_DoesNotChangeTotal() {
		int[] baseline = new int[53];
		int[] counts = new int[53];
		counts[50]++;
		counts[51]--;
		counts[52]++;
		baseline[51]++;
		baseline[52]++;
		baseline[50]++;
		baseline[52]++;
		
		restore(baseline, counts, 'Z');
		
		assertEquals(1, counts[50]);
		assertEquals(0, counts[51]);
		assertEquals(1, counts[52]);
	}

	@Test
	public void restore_SomeSymbol_Throws() {
		int[] counts = new int[53];
		assertThrows(IllegalArgumentException.class ,()-> restore(counts, counts, '*'));
	}

	@Test
	public void solve_SUpperAndLowercaseLetters_ReturnsCorrectAnswer() {
		assertEquals("asd", solve("asdD", "asd"));
	}
	
	@Test
	public void solve_TUpperAndLowercaseLetters_ReturnsCorrectAnswer() {
		assertEquals("aSd", solve("aaSd", "aSd"));
	}
	
	@Test
	public void solve_MultipleSolutions_Throws() {
		String s = "abcabc";
		String t = "abc";
		
		assertThrows(IllegalArgumentException.class ,()-> solve(s, t));
	}
	
	@Test
	public void solve_WhenCalled_ReturnsCorrectAnswer() {
		String s = "sadfaghj";
		String t = "fdaa";
		
		assertEquals("adfa", solve(s, t));
	}
	
	@Test
	public void solve_WhenCalled_ReturnsCorrectAnswer2() {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		
		assertEquals("BANC", solve(s, t));
	}
	
	@Test
	public void solve_WhenCalled_ReturnsCorrectAnswer3() {
		String s = "a";
		String t = "a";
		
		assertEquals("a", solve(s, t));
	}
	
	@Test
	public void solve_WhenCalled_ReturnsCorrectAnswer4() {
		String s = "a";
		String t = "aa";
		
		assertEquals("", solve(s, t));
	}
}
