package com.hss.algorithm.august.mixins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/7/31 22:21
 * @Version 1.0.0
 */
public class 服务失效判断 {

    public static List<String[]> list = new ArrayList<>();    //依赖关系集合
    public static List<String> errorSer = new ArrayList<>();   //故障集合

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        String[] guzhang = sc.nextLine().split(",");
        List<String> listError = Arrays.asList(guzhang);
        errorSer = new ArrayList<>(listError);
        List<String> listSer = new ArrayList<>();   //所有服务

        for (String string : strings) {
            String[] temp = string.split("-");
            list.add(temp);
            String a = temp[0];
            String b = temp[1];
            if (!listSer.contains(a)) listSer.add(a);
            if (!listSer.contains(b)) listSer.add(b);
        }
        for (String s : guzhang) {
            checkError(s);
        }
        listSer.removeAll(errorSer);    //从所有服务中剔除故障服务
        if (listSer.size() == 0) {
            System.out.println(",");
        } else {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < listSer.size(); i++) {
                res.append(listSer.get(i));
                if (i != listSer.size() - 1) {
                    res.append(",");
                }
            }
            System.out.println(res);
        }
    }

    /**
     * @param s 故障服务
     *          请求出所有依赖故障服务的服务，并将其放入故障服务集合中
     */
    public static void checkError(String s) {
        for (String[] temp : list) {
            if (temp[1].equals(s) && !errorSer.contains(temp[0])) {
                errorSer.add(temp[0]);
                checkError(temp[0]);
            }
        }
    }
}
