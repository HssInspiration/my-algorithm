package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/7/31 22:23
 * @Version 1.0.0
 */
public class 服务失效判断2 {

    public static List<String[]> list = new ArrayList<>();    //依赖关系集合
    public static List<String> errorSer = new ArrayList<>();   //故障集合

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        String[] guzhang = sc.nextLine().split(",");
        List<String> setSer = new ArrayList<>();     //所有服务集合（取出错误服务）
        errorSer = Arrays.asList(guzhang);
        for (String string : strings) {
            String[] temp = string.split("-");
            list.add(temp);
            String a = temp[0];
            String b = temp[1];
            if (!errorSer.contains(a) && !setSer.contains(a)) {
                setSer.add(a);
            }
            if (!errorSer.contains(b) && !setSer.contains(b)) {
                setSer.add(b);
            }
        }

        List<String> listZC = new ArrayList<>();    //保持正常的服务
        setSer.forEach(v -> {
            if (!isGz(v)) {      //如果非故障则取出
                listZC.add(v);
            }
        });
        int len = listZC.size();
        if (len == 0) {
            System.out.println(",");
        } else {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < len; i++) {
                res.append(listZC.get(i));
                if (i != len - 1) {
                    res.append(",");
                }
            }
            System.out.println(res);
        }
    }
    public static boolean isGz(String s) {  //服务依赖关系集合，需要判断的服务，故障服务集合
        if (errorSer.contains(s)) { //此时服务故障则返回true
            return true;
        }
        for (String[] strings : list) {
            if (strings[0].equals(s) && isGz(strings[1])) {    //如果此时服务依赖另外一个服务，则对依赖的服务进行一次故障判断，如为故障则返回true
                return true;
            }
        }
        return false;
    }
}
