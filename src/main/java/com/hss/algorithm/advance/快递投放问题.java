package com.hss.algorithm.advance;

import java.util.*;

/**
 * @Author hss
 * @Date 2023/2/6 22:17
 * @Version 1.0.0
 */
public class 快递投放问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        /**
         * key：包裹名
         * value：运输路径
         */
        Map<String, String> mapPkg = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String[] strings = sc.nextLine().split(" ");
            mapPkg.put(strings[0], strings[1] + strings[2]);
        }

        /**
         * key：路径名
         * value：被拦截的包裹名
         */
        Map<String, List<String>> mapNo = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] strings = sc.nextLine().split(" ");
            List<String> noList = new ArrayList<>();
            for (int j = 2; j < strings.length; j++) {
                noList.add(strings[j]);
            }
            mapNo.put(strings[0] + strings[1], noList);
        }

        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, List<String>> map : mapNo.entrySet()) {
            String key = map.getKey();  //路径名
            List<String> list = map.getValue(); //被拦截的包裹
            for (String s : list) {
                if (key.equals(mapPkg.get(s))) {  //被拦截的包裹的运输路径等于此路径则表示包裹被拦截
                    resList.add(s);
                }
            }
        }

        System.out.println(resList);
    }

}
