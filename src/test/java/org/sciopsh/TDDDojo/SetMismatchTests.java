package org.sciopsh.TDDDojo;

import static org.junit.jupiter.api.Assertions.*;
import static org.sciopsh.TDDDojo.SetMismatch.*;

import org.junit.jupiter.api.Test;

public class SetMismatchTests {
	
	@Test
	public void solve_NullArgument_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(null));
	}
	
	@Test
	public void solve_EmptyArgument_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new int[0]));
	}
	
	@Test
	public void solve_ArgumentOfLengthOne_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new int[1]));
	}
	
	@Test
	public void solve_ArgumentOfLengthTooBig_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new int[100001]));
	}
	
	@Test
	public void solve_ElementBiggerThanArgLength_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new int[] {1, 5}));
	}
	
	@Test
	public void solve_ElementSmallerThan1_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new int[] {1, 0}));
	}
	
	@Test
	public void solve_ThreeEqualElements_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new int[] {1, 1, 1}));
	}
	
	@Test
	public void solve_TwoDuplicates_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new int[] {1, 1, 2, 2}));
	}
	
	@Test
	public void solve_NoDuplicates_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve(new int[] {1, 2, 3, 4}));
	}
	
	@Test
	public void solve_TwoOnes_ReturnsOneThenTwo() {
		assertArrayEquals(new int[] {1, 2}, solve(new int[] {1, 1}));
	}
	
	@Test
	public void solve_TwoTwos_ReturnsTwoThenOne() {
		assertArrayEquals(new int[] {2, 1}, solve(new int[] {2, 2}));
	}
	
	@Test
	public void solve_AnotherExample_ReturnsCorrectly() {
		assertArrayEquals(new int[] {2, 3}, solve(new int[] {1, 2, 2, 4}));
	}
}
