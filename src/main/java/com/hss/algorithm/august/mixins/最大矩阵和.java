package com.hss.algorithm.august.mixins;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:47
 * @Version 1.0.0
 */
public class 最大矩阵和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //行
        int m = sc.nextInt();   //列
        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ints[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for (int start_row = 0; start_row < n; start_row++) {   //开始行
            for (int start_col = 0; start_col < m; start_col++) {   //开始列
                for (int end_row = start_row; end_row < n; end_row++) {   //结束行
                    int jisuan = 0; //矩阵和
                    for (int end_col = start_col; end_col < m; end_col++) {   //结束列
                        int rowindex = end_row; //将结束行作为边界
                        while (rowindex >= start_row) {    //最后一行不能超过开始行
                            jisuan += ints[rowindex][end_col];    //从结束行向上遍历到开始行
                            rowindex--;
                        }
                        max = Math.max(max, jisuan);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
