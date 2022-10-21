package org.sciopsh.TDDDojo;

import java.util.*;

public class ContainsDuplicateII {
	
	public static boolean solve(int[] nums, int k) {
		
		if(k < 0 || k > 100000) {
			throw new IllegalArgumentException("k can not be less than zero or bigger than 10^5");
		}
		if(nums == null) {
			return false;
		}
		if(nums.length > 100000) {
			throw new IllegalArgumentException("nums can not be of size bigger than 10^5");
		}
		if(k == 0) {
			return false;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			
			int current = nums[i];
			
			if(map.containsKey(current)) {
				return true;
			}
			
			map.put(current, map.getOrDefault(current, 0) + 1);
			if(i - k >= 0) {
				int last = nums[i-k];
				
				if(map.get(last) == 1) {
					map.remove(last);
				} else {
					map.put(last, map.get(last) - 1);
				}
			}
		}
		
		return false;
		
	}
}
