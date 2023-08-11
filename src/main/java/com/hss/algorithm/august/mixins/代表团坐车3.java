package com.hss.algorithm.august.mixins;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/11 8:04
 * @Version 1.0.0
 */
public class 代表团坐车3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] nums =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        int bag = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(nums, bag));
    }

    private static int getResult(Integer[] nums, int bag) {
        int n = nums.length;

        int[] dp = new int[bag + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = bag; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }

        return dp[bag];
    }
}
