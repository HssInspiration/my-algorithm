package com.hss.algorithm.base;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 21:57
 * @Version 1.0.0
 */
public class 获取最大软件版本号 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strings1 = sc.nextLine();
        String strings2 = sc.nextLine();

        String[] arrA = strings1.replace("-", ".").split("\\.");
        String[] arrB = strings2.replace("-", ".").split("\\.");

        String[] mvnA = new String[]{"", "", "", ""};
        for (int i = 0; i < arrA.length; i++) {
            mvnA[i] = arrA[i];
        }

        String[] mvnB = new String[]{"", "", "", ""};
        for (int i = 0; i < arrB.length; i++) {
            mvnB[i] = arrB[i];
        }

        int res = 1;
        for (int i = 0; i < 4; i++) {
            if (i == 3 ||
                    (i == 2 && (mvnA[i].equals("") || mvnB[i].equals("")))) {
                res = mvnA[i].compareTo(mvnB[i]) < 0 ? 2 : 1;
                break;
            }
            int a = Integer.valueOf(mvnA[i]);
            int b = Integer.valueOf(mvnB[i]);
            if (a > b) {
                res = 1;
                break;
            } else if (a < b) {
                res = 2;
                break;
            }
        }

        System.out.println(res == 1 ? strings1 : strings2);
    }
}
