package com.hss.algorithm.advance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:14
 * @Version 1.0.0
 */
public class 统计差异值大于相似值二元组个数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");

        int[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (handle(ints[i], ints[j])) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static boolean handle(int A, int B) {

        String binaryA = Integer.toBinaryString(A);     //十进制转二进制
        String binaryB = Integer.toBinaryString(B);

        int indexA = binaryA.length() - 1;      //二进制字符串长度
        int indexB = binaryB.length() - 1;

        StringBuffer chayi = new StringBuffer();    //差异值字符串
        StringBuffer xiangsi = new StringBuffer();  //相似值字符串

        while (indexA >= 0 || indexB >= 0) {

            char charA = ' ';
            char charB = ' ';

            if (indexA >= 0) {    //索引大于等于0才有值
                charA = binaryA.charAt(indexA);     //从尾部开始比较
            }
            if (indexB >= 0) {
                charB = binaryB.charAt(indexB);
            }

            if (charA == charB) {
                chayi.append("0");
            } else {
                chayi.append("1");
            }

            if (charA == '1' && charB == '1') {
                xiangsi.append("1");
            } else {
                xiangsi.append("0");
            }

            indexA--;
            indexB--;
        }

        int intChayi = Integer.valueOf(String.valueOf(chayi.reverse()), 2);     //因为是从尾部开始比较，需要反转
        int intXiangsi = Integer.valueOf(String.valueOf(xiangsi.reverse()), 2);

        return intChayi > intXiangsi;
    }
}
