package com.hss.algorithm.august.mixins;

import java.util.Scanner;

public class IPV4地址转换成整数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ips = in.next().split("#");
        System.out.println(getIpAddr(ips));
    }

    private static String getIpAddr(String[] ips) {
        int len = ips.length;
        StringBuilder res = new StringBuilder();
        // 长度不符合要求
        String DEFAULT_RES = "invalid IP";
        if (len != 4) {
            return DEFAULT_RES;
        }
        // 在范围内返回指定格式的数字, 不在范围内返回invalid IP
        for (int i = 0; i < ips.length; i++) {
            int item;
            try {
                item = Integer.parseInt(ips[i]);
            } catch (NumberFormatException e) {
                return DEFAULT_RES;
            }
            if (i == 0 && (item < 1 || item > 128)) {
                return DEFAULT_RES;
            }
            if (i > 0 && (item < 0 || item > 255)) {
                return DEFAULT_RES;
            }
            // 在范围内将IP的每一段转成32位并拼接
            res.append(getItem32BinaryVal(item));
        }
        long parsedLong = Long.parseLong(res.toString(), 16);
        return Long.toString(parsedLong);
    }

    private static String getItem32BinaryVal(int item) {
        String itemStr = Integer.toHexString(item);
        if (itemStr.length() < 2) {
            itemStr = "0" + itemStr;
        }
        return itemStr;
    }
}