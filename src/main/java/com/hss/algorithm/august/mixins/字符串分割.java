package com.hss.algorithm.august.mixins;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:51
 * @Version 1.0.0
 */
public class 字符串分割 {

    public static int fuhe = 0; //能够实现的方案个数
    public static int zichuan = 1;  //分割出的子串个数

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        fenge(str, 0);
        int res = 0;
        if (fuhe == 1) {
            res = zichuan;  //只有一种情况符合
        } else if (fuhe > 1) {
            res = -1;   //大于一种情况符合
        }
        System.out.println(res);

    }

    public static void fenge(String s, int n) {

        int len = s.length();
        int count = 0;  //ACSII码技术和
        for (int i = 0; i < len; i++) {
            count += s.charAt(i);
            if (count > 999) {  //大于999之后都不符合要求，直接退出
                break;
            }
            if (count >= 100) {  //水仙数[100,999]之间
                if (isSXS(count)) {
                    if (i == len - 1) {
                        fuhe++; //字符串遍历到最后一位都符合水仙数，说明是符合要求的
                        zichuan = ++n;
                    } else {
                        int nums = n;
                        fenge(s.substring(i + 1), ++nums); //将剩下的字符继续遍历
                        //zichuan++;  //符合的子串+1
                    }
                }
            }
        }
    }

    public static boolean isSXS(int i) {

        int b = i / 100;  //百位数
        int s = i % 100 / 10;   //十位数
        int g = i % 100 % 10;   //个位数

        int count = (int) (Math.pow(b, 3) + Math.pow(s, 3) + Math.pow(g, 3));
        return count == i;
    }

}
