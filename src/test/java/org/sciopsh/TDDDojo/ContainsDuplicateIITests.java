package org.sciopsh.TDDDojo;

import static org.junit.Assert.*;
import static org.sciopsh.TDDDojo.ContainsDuplicateII.*;

import org.junit.Test;

public class ContainsDuplicateIITests {
	
	@Test
	public void Solve_KIs0_ReturnsFalse() {
		assertFalse(solve(new int[] {1, 2, 3}, 0));
	}
	
	@Test
	public void Solve_KLessThan0_Throws() {
		assertThrows(IllegalArgumentException.class ,()-> solve(new int[] {1, 2, 3}, -1));
	}
	
	@Test
	public void Solve_KOverAHundredThousand_Throws() {
		assertThrows(IllegalArgumentException.class ,()-> solve(new int[] {1, 2, 3}, 100001));
	}
	
	@Test
	public void Solve_KAHundredThousand_DoesNotThrow() {
		assertFalse(solve(new int[] {1, 2, 3}, 100000));
	}
	
	@Test
	public void Solve_NumsEmpty_ReturnsFalse() {
		assertFalse(solve(new int[] {}, 1000));
	}
	
	@Test
	public void Solve_NumsNull_ReturnsFalse() {
		assertFalse(solve(null, 1000));
	}
	
	@Test
	public void Solve_NumsTooBig_Throws() {
		assertThrows(IllegalArgumentException.class ,()-> solve(new int[100001], 0));
	}
	
	@Test
	public void Solve_NumsAlmostTooBig_Throws() {
		assertFalse(solve(new int[100000], 0));
	}
	
	@Test
	public void Solve_ConditionsForReturningTrue_ReturnsTrue() {
		assertTrue(solve(new int[] {1, 2, 3, 2}, 2));
	}
	
	@Test
	public void Solve_TooFarAway_ReturnsFalse() {
		assertFalse(solve(new int[] {1, 2, 3, 2}, 1));
	}
	
	@Test
	public void Solve_NoDuplicates_ReturnsFalse() {
		assertFalse(solve(new int[] {1, 2, 3, 4}, 4));
	}
	
}
