package com.hss.algorithm.august.mixins;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/8/1 22:44
 * @Version 1.0.0
 */
public class 英文输入法 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine()
                .replace("'", " ")   //对“'”符号进行空格处理
                .replace(",", "")
                .replace(".", "")
                .replace("?", "")
                .replace("!", "")    //对“, . ? !”符号进行删除处理
                .split(" ");    //按照空格进行分割

        Arrays.sort(strings);   //因为是字典需要进行排序
        String key = sc.nextLine();
        int keyLen = key.length();
        StringBuilder res = new StringBuilder();
        for (String s : strings) {
            if (s.length() >= keyLen && s.substring(0, keyLen).equals(key)) {    //匹配的字符串需要判断长度，并进行关键词长度的分割
                if (res.length() != 0) {
                    res.append(" ");
                }
                res.append(s);
            }
        }
        if (res.length() == 0) {
            res = new StringBuilder(key);
        }
        System.out.println(res);
    }
}
