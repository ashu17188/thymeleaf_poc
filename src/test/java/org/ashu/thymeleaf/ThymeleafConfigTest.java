package org.ashu.thymeleaf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ThymeleafConfigTest {

	@Test
	void test() {
//		fail("Not yet implemented");
	}

	class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	};

	@Test
	void testSumPair() {
		int arr [] = {1, 3, 8, 10, 15  };
		int key = 12;
		log.info("Start: {} and End: {} of range.", findStartOfRange(arr, key), findEndOfRange(arr, key) );
	}

	public int findStartOfRange(int arr[], int key) {
		int start = 0, end = arr.length - 1;
		int keyIndex = Integer.MAX_VALUE;
		while (start < end) {
			int mid = start + (end - start) / 2;
			keyIndex = mid;
			if (arr[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			
		}
		if(arr[keyIndex] !=  key) return -1;
		return  end + 1 >= arr.length ?-1: end + 1;
	}

	public int findEndOfRange(int arr[], int key) {
		int start = 0, end = arr.length - 1;
		int keyIndex = Integer.MAX_VALUE;
		while (start < end) {
			int mid = start + (end - start) / 2;
			keyIndex = mid;
			if (arr[mid] <= key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if(arr[keyIndex] !=  key) return -1;
		return start- 1;
	}

}
