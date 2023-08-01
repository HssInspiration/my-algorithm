package com.hss.algorithm.august.mixins;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:45
 * @Version 1.0.0
 */
public class 工号不够用 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            long minNumOfPeople = in.nextLong();
            int length = in.nextInt();
            int lenOfNum = 1;
            while (true) {
                double pow = Math.pow(26, length);
                double pow1 = Math.pow(10, lenOfNum);
                double maxNumOfPeople = pow * pow1;
                if (maxNumOfPeople >= minNumOfPeople) {
                    System.out.println(lenOfNum);
                    break;
                } else {
                    lenOfNum++;
                }
            }
        }
    }
}
