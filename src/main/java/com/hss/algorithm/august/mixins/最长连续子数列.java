package com.hss.algorithm.august.mixins;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:43
 * @Version 1.0.0
 */
public class 最长连续子数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        int[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        int sum = sc.nextInt();
        int left = 0, right = 0, count = ints[0], max = -1;
        while (left < ints.length) {
            if (count >= sum) {
                if (count == sum) {
                    max = Math.max(max, right - left + 1);
                }
                //大于等于sum则左边界右移
                count -= ints[left];
                left++;
            } else if (count < sum) {
                //小于sum则右边界右移
                right++;
                if (right == ints.length) {
                    //滑窗右边界超界了
                    break;
                }
                count += ints[right];
            }
        }
        System.out.println(max);
    }
}
