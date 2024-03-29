package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:24
 * @Version 1.0.0
 */
public class 可组成网络的服务器 {

    public static int[][] ints;
    public static int n;
    public static int m;
    public static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ints = new int[n][m];   //网络矩阵

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ints[i][j] = sc.nextInt();
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ints[i][j] == 1) {
                    count = 1;
                    ints[i][j] = 0;
                    internet(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

    public static void internet(int x, int y) {

        if (x > 0 && ints[x - 1][y] == 1) {
            ints[x - 1][y] = 0;
            count++;
            internet(x - 1, y);
        }
        if (y > 0 && ints[x][y - 1] == 1) {
            ints[x][y - 1] = 0;
            count++;
            internet(x, y - 1);
        }
        if (x < n - 1 && ints[x + 1][y] == 1) {
            ints[x + 1][y] = 0;
            count++;
            internet(x + 1, y);
        }
        if (y < m - 1 && ints[x][y + 1] == 1) {
            ints[x][y + 1] = 0;
            count++;
            internet(x, y + 1);
        }
    }
}
