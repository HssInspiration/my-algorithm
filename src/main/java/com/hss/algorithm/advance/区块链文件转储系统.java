package com.hss.algorithm.advance;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:20
 * @Version 1.0.0
 */
public class 区块链文件转储系统 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");

        int left = 0;   //滑窗左边界
        int right = 1;  //滑窗右边界
        int count = Integer.valueOf(strings[0]);    //连续文件大小之和
        int max = 0;    //最大连续和
        while (max != M && (right < strings.length || count > max)) {  //当max==M时直接图退出，当右边界到头且count小于max时退出
            if (count <= M) {
                max = Math.max(max, count);
                if (right < strings.length) {     //控制滑窗右边界
                    count += Integer.valueOf(strings[right]);
                    right++;
                }
            } else {
                count -= Integer.valueOf(strings[left]);
                left++;
            }
        }

        System.out.println(max);
    }
}
