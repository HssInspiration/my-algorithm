package com.hss.algorithm.base;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 21:56
 * @Version 1.0.0
 */
public class 开心消消乐 {

    public static int[][] juzhen;
    public static int N;
    public static int M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        juzhen = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                juzhen[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (juzhen[i][j] == 1) {
                    juzhen[i][j] = 0;
                    clearHappy(i, j);
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static void clearHappy(int x, int y) {

        if (x > 0) {
            if (juzhen[x - 1][y] == 1) {    //正上
                juzhen[x - 1][y] = 0;
                clearHappy(x - 1, y);
            }
            if (y > 0) {
                if (juzhen[x - 1][y - 1] == 1) {  //左上
                    juzhen[x - 1][y - 1] = 0;
                    clearHappy(x - 1, y - 1);
                }
            }
            if (y < M - 1) {
                if (juzhen[x - 1][y + 1] == 1) {    //右上
                    juzhen[x - 1][y + 1] = 0;
                    clearHappy(x - 1, y + 1);
                }
            }
        }

        if (x < N - 1) {
            if (juzhen[x + 1][y] == 1) {    //正下
                juzhen[x + 1][y] = 0;
                clearHappy(x + 1, y);
            }
            if (y > 0) {
                if (juzhen[x + 1][y - 1] == 1) {    //左下
                    juzhen[x + 1][y - 1] = 0;
                    clearHappy(x + 1, y - 1);
                }
            }
            if (y < M - 1) {
                if (juzhen[x + 1][y + 1] == 1) {  //右下
                    juzhen[x + 1][y + 1] = 0;
                    clearHappy(x + 1, y + 1);
                }
            }
        }

        if (y > 0) {
            if (juzhen[x][y - 1] == 1) {    //正左
                juzhen[x][y - 1] = 0;
                clearHappy(x, y - 1);
            }
        }

        if (y < M - 1) {
            if (juzhen[x][y + 1] == 1) {    //正右
                juzhen[x][y + 1] = 0;
                clearHappy(x, y + 1);
            }
        }
    }
}
