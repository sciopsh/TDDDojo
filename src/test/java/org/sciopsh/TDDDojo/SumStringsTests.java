package org.sciopsh.TDDDojo;

import static org.junit.Assert.*;
import static org.sciopsh.TDDDojo.SumStrings.*;
import org.junit.jupiter.api.Test;

public class SumStringsTests {
	@Test
	public void Solve_Empty_ReturnsEmpty() {
		assertEquals(0, solve(""));;
	}
	
	@Test
	public void Solve_Null_ReturnsEmpty() {
		assertEquals(0, solve(null));;
	}
	
	@Test
	public void Solve_SingleNumber_ReturnsNumber() {
		assertEquals(5, solve("5"));;
	}
	
	@Test
	public void Solve_TwoNumbersWithComma_ReturnsSum() {
		assertEquals(5, solve("3,2"));;
	}
	
	@Test
	public void Solve_ThreeNumbersWithComma_ReturnsSum() {
		assertEquals(10, solve("3,2,5"));;
	}
	
	@Test
	public void Solve_TwoNumbersWithNewline_ReturnsSum() {
		assertEquals(5, solve("3\n2"));;
	}
	
	@Test
	public void Solve_EmptyLast_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve("3\n2,"));
	}
	
	@Test
	public void Solve_CustomDelimiter_ReturnsSum() {
		assertEquals(5, solve("//;\n3;2"));;
	}
	
	@Test
	public void Solve_NegativeNumbers_Throws() {
		assertThrows(IllegalArgumentException.class, () -> solve("3\n-2"));
	}
}
