package com.hss.algorithm.base;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 21:49
 * @Version 1.0.0
 */
public class 分界线 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] newspaper = sc.nextLine().split(" ");
        String[] anonymousLetter = sc.nextLine().split(" ");
        boolean res = true;
        for (String anony : anonymousLetter) {
            for (int i = 0; i < newspaper.length; i++) {
                String news = newspaper[i];
                if (anony.length() == news.length() && handle(news, anony)) {    //长度相等才有资格匹配
                    newspaper[i] = " ";     //使用过的字符串之后就不能使用了
                    break;
                }
                if (i == newspaper.length - 1) {    //遍历到最后都没有匹配的，直接false
                    res = false;
                }
            }
            if (!res) {   //已经失败了，跳出循环
                break;
            }
        }
        System.out.println(res);
    }

    /**
     * 通过char字符的排序，然后判断是否一一匹配，只要一个不匹配，直接false
     *
     * @param news  报纸上的字符串
     * @param anony 匿名信上的字符串
     * @return
     */
    public static boolean handle(String news, String anony) {
        char[] newsChar = news.toCharArray();
        char[] anonyChar = anony.toCharArray();
        Arrays.sort(newsChar);
        Arrays.sort(anonyChar);
        boolean isTrue = true;
        for (int i = 0; i < newsChar.length; i++) {
            if (newsChar[i] != anonyChar[i]) {
                isTrue = false;
            }
        }
        return isTrue;
    }
}
