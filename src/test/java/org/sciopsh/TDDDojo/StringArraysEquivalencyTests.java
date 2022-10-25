package org.sciopsh.TDDDojo;

import static org.junit.Assert.*;
import static org.sciopsh.TDDDojo.StringArraysEquivalency.*;
import org.junit.jupiter.api.Test;

public class StringArraysEquivalencyTests {
	
	@Test
	public void Solve_Nulls_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(null, new String[1]));
		assertThrows(IllegalArgumentException.class, () -> solve(new String[1] ,null));
		assertThrows(IllegalArgumentException.class, () -> solve(null, null));
	}
	
	@Test
	public void Solve_BothEmpty_True() {
		assertTrue(solve(new String[]{}, new String[]{}));
	}
	
	@Test
	public void Solve_OneEmptyOneZeroLength_True() {
		assertTrue(solve(new String[]{""}, new String[]{}));
	}
	
	@Test
	public void Solve_BigArray_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new String[1001], new String[]{}));
	}
	
	@Test
	public void Solve_BigString_Throws() {
		String big = "abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdea";
		assertTrue(big.length() > 1000);
		assertThrows(IllegalArgumentException.class, () -> solve(new String[] {big}, new String[]{}));
	}
	
	@Test
	public void Solve_WierdChars_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new String[] {"."}, new String[]{"a"}));
	}
	
	@Test
	public void Solve_OneEmptyOneWitValue_False() {
		assertFalse(solve(new String[]{"sd"}, new String[]{}));
	}
	
	@Test
	public void Solve_DifferentValues_False() {
		assertFalse(solve(new String[]{"sdf"}, new String[]{"asd"}));
	}
	
	@Test
	public void Solve_DifferentValues2_False() {
		assertFalse(solve(new String[]{"sdf", "asd"}, new String[]{"sdf", "sdf"}));
	}
	
	@Test
	public void Solve_Equals_True() {
		assertTrue(solve(new String[]{"as", "dasd"}, new String[]{"a", "sd", "as", "d"}));
	}
	
}
