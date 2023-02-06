package com.hss.algorithm.advance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:18
 * @Version 1.0.0
 */
public class 优雅数组 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }

        /**
         * 将数组中的数字作为index新建一个长度为A的lenInts数组（数组中元素<=n）
         * lenInts数组中的数字则为index出现的次数
         */
        int[] lenInts = new int[n + 1];

        int res = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {     //相当于左滑块
            if (i > 0) {
                lenInts[ints[i - 1]]--;   //i==0时数组中没有数据所以需要区别开
            } else {
                lenInts[ints[i]]++;
            }
            int max = Arrays.stream(lenInts).max().getAsInt();  //最大值为数组中元素出现的最多次数
            if (max == k) {
                res += n - right;   //最大次数已满足则后面自然都满足
                continue;
            }
            for (int j = right + 1; j < n; j++) {       //相当于右滑块
                lenInts[ints[j]]++;
                max = Arrays.stream(lenInts).max().getAsInt();
                if (max == k) {
                    res += n - j;
                    right = j;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
