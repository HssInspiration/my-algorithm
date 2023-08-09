package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/9 22:34
 * @Version 1.0.0
 */
public class 代表团坐车 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String[] nums = inputStr.split(",");
        List<Integer> a = new ArrayList<>();
        for (String num : nums) {
            a.add(Integer.parseInt(num.trim()));
        }
        int m = scanner.nextInt();
        // dp[n]表示恰好装成容量为n的方案数
        int[] dp = new int[m + 1];
        // 初始化dp[0] = 1,表示容量为0的方案为1种
        dp[0] = 1;
        for (int i : a) {
            for (int j = m; j >= i; j--) {
                // 转移方程为：dp[n] += dp[n - i]
                dp[j] += dp[j - i];
            }
        }
        System.out.println(dp[m]);
    }
}
