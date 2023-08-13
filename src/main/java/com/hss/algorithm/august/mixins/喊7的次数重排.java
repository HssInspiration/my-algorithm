package com.hss.algorithm.august.mixins;

import java.util.Arrays;
import java.util.Scanner;

public class 喊7的次数重排 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 初始化N个人喊过的数组
        String[] passArr = in.nextLine().split(" ");
        // 数组长度对应N
        int N = passArr.length;
        // 将原数组转成目标数组targetArr[i]-每个人喊过的次数
        int[] targetArr = new int[N];
        for (int i = 0; i < N; i++) {
            targetArr[i] = Integer.parseInt(passArr[i]);
        }
        // 喊过的总次数
        int passTotal = Arrays.stream(targetArr).sum();
        // 获取排序后的结果
        String res = getSortedRes(N, passTotal).toString();
        System.out.println(res);
    }

    private static StringBuilder getSortedRes(int N, int passTotal) {
        // 每次喊的数字，从1开始
        int num = 1;
        // 初始化一个空数组用于记录每次喊过的人的位置
        int[] resArr = new int[N];
        int position = 0;
        while (passTotal > 0) {
            if (position >= N) {
                position = 0;
            }
            // 记录7的倍数或者包含7这个关键字的场景
            if (num % 7 == 0 || String.valueOf(num).contains("7")) {
                // 记录指定位置的人喊了几次过
                resArr[position]++;
                // 符合条件将喊过的总次数-1
                passTotal--;
            }
            // 每数一次num自增1,同时位置加1
            num++;
            position++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(resArr[i]).append(" ");
        }
        return sb;
    }
}
