package org.ashu.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ThymeleafConfigTest {

	@Test
	void test() {
//		fail("Not yet implemented");
	}

	@Test
	void testSumPair() {
		int[] a = new int[] {1, 2, 7, 1, 5};
		log.info("Minimum subset sum difference: {}", canPartition(a));
	}

	public int canPartition(int num[]) {
		int sum = 0;
		for (int a : num) {
			sum += a;
		}
		Integer dp[][] = new Integer[num.length][sum + 1];
		return canPartitionRec(dp, num, 0, 0, 0);
	}

	private int canPartitionRec(Integer dp[][], int num[], int currentIndex, int sum1, int sum2) {
		if (currentIndex == num.length) {
			return Math.abs(sum1 - sum2);
		}
		if (dp[currentIndex][sum1] == null) {
			int diff1 = canPartitionRec(dp, num, currentIndex + 1, sum1 + num[currentIndex], sum2);

			int diff2 = canPartitionRec(dp, num, currentIndex + 1, sum1, sum2 + num[currentIndex]);
			int min = Math.min(diff1, diff2);
			dp[currentIndex][sum1] = min;
		}
		return dp[currentIndex][sum1];
	}

}
