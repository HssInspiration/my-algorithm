package com.hss.algorithm.base;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 21:52
 * @Version 1.0.0
 */
public class 简单的自动曝光 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int len = strs.length;
        double count = 0;   //输入值总和
        for (int i = 0; i < len; i++) {
            int num = Integer.valueOf(strs[i]);
            count += num;
        }

        double averages = count / len - 128;  //平均差
        int res = (int) Math.round(averages);   //对平均差进行四舍五入

        int lessThenZeroNum = 0;    //newImg小于0的个数
        int lessThenZero = 0;    //newImg小于0的与0的差值的和
        for (int i = 0; i < len; i++) {
            int num = Integer.valueOf(strs[i]);
            if (num - res < 0) {    //考虑到newImg的值小于0
                lessThenZeroNum++;
                lessThenZero += num - res;
            }
        }

        res -= lessThenZero / (len - lessThenZeroNum);

        System.out.println(0 - res);    //取反
    }
}
