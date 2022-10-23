package org.sciopsh.TDDDojo;

public class SetMismatch {

	// How to TDD into getting a better solution?
	
	public static int[] solve(int[] nums) {
		
		checkArrayBoundaries(nums);
		
		int[] counts = countApparitions(nums);
		
		return findDuplicateAndMissing(counts);
	}

	private static void checkArrayBoundaries(int[] nums) {
		
		if(nums == null || nums.length < 2)
			throw new IllegalArgumentException("Argument should be an array of at least two elements");
		
		if(nums.length > 100000)
			throw new IllegalArgumentException("Argument should be an array of at most 100000 elements");
		
	}

	private static int[] countApparitions(int[] nums) {
		int[] counts = new int[nums.length + 1];
		
		for(int num : nums) {
			
			checkElementsOutOfBounds(num, nums.length);
			
			counts[num]++;
			
		}
		return counts;
	}

	private static int[] findDuplicateAndMissing(int[] counts) {
		
		int[] ans = {-1, -1};
		
		for(int i = 0; i < counts.length; i++) {
			
			reduce(counts[i], ans, i);
		}
		
		checkNoAnswer(ans);
		
		return ans;
		
	}

	private static void checkElementsOutOfBounds(int num, int max) {
		if(num > max || num < 1)
			throw new IllegalArgumentException("No element should be bigger than the array length");
	}

	private static void reduce(int count, int[] ans, int i) {
		
		if(count > 2)
			
			throw new IllegalArgumentException("Found three copies of the same element.");
		
		else if(count == 2) {
			
			updateDuplicate(ans, i);
			
		} else if(count == 0) {
			
			updateMissing(ans, i);
			
		}
	}

	private static void updateDuplicate(int[] ans, int i) {
		if(ans[0] == -1) {
			ans[0] = i;
		} else {
			throw new IllegalArgumentException("Found two elements with two copies each.");
		}
	}

	private static void updateMissing(int[] ans, int i) {
		ans[1] = i;
	}

	private static void checkNoAnswer(int[] ans) {
		if(ans[0] == -1) {
			throw new IllegalArgumentException("Didn't find any repeated element.");
		}
	}

}
