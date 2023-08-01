package com.hss.algorithm.august.mixins;

import java.util.*;

/**
 * @Author hss
 * @Date 2023/8/1 22:38
 * @Version 1.0.0
 */
public class 相同数字组成图形的周长 {
    static int n = 64;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // g 表示图形
    static int[][] g = new int[n][n];

    // nums 表示所有出现在 g 中的值
    static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            int v = Integer.parseInt(line[0]);
            nums.add(v);
            for (int j = 1; j < line.length; j += 2) {
                int x = Integer.parseInt(line[j]);
                int y = Integer.parseInt(line[j + 1]);
                // 给对应的格子赋值
                g[x][y] = v;
            }
        }
        // 统计每个值的周长之和
        Map<Integer, Integer> val = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 当一个格子有值，才会有边长
                if (g[i][j] > 0) {
                    int v = g[i][j];
                    int res = 4;
                    for (int k = 0; k < 4; ++k) {
                        int nx = i + dx[k], ny = j + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx][ny] == v) {
                            res -= 1;
                        }
                    }
                    val.put(v, val.getOrDefault(v, 0) + res);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.print(val.get(nums.get(i)));
            if (i + 1 == m) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}
