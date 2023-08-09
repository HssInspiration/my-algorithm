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

    public static List<String[]> dependencyList = new ArrayList<>();

    public static List<String> faultList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入
        String[] services = sc.nextLine().split(",");
        String[] faultArrays = sc.nextLine().split(",");
        // 1.初始化所有输入的依赖服务与故障服务
        List<String> serviceList = initServiceList(services);
        faultList = new ArrayList<>(Arrays.asList(faultArrays));
        // 2.校验故障服务
        for (String fault : faultArrays) {
            checkError(fault);
        }
        // 3.获取打印结果
        String res = getResult(serviceList);
        System.out.println(res);
    }

    private static String getResult(List<String> serviceList) {
        // 从所有服务中剔除故障服务
        serviceList.removeAll(faultList);
        if (serviceList.size() == 0) {
            return ",";
        }
        StringBuilder res = new StringBuilder();
        for (String s : serviceList) {
            res.append(s).append(",");
        }
        return res.substring(0, res.lastIndexOf(","));
    }

    private static List<String>  initServiceList(String[] services) {
        List<String> serviceList = new ArrayList<>();
        for (String string : services) {
            // 按-分割服务服务数组
            String[] dependencies = string.split("-");
            // 将分割后的服务数组添加到依赖关系集合中
            dependencyList.add(dependencies);
            // 将分割后的服务添加到服务集合中
            if (!serviceList.contains(dependencies[0])) {
                serviceList.add(dependencies[0]);
            }
            if (!serviceList.contains(dependencies[1])) {
                serviceList.add(dependencies[1]);
            }
        }
        return serviceList;
    }

    /**
     * 判断所有依赖故障服务的服务，并将其放入故障服务集合中
     *
     * @param fault 故障服务
     */
    public static void checkError(String fault) {
        // 遍历服务集合（含分割后的服务数组）
        for (String[] dependency : dependencyList) {
            // 判断是否为故障服务，前一个服务依赖后一个服务，如果后一个为故障服务那这两个服务都是故障服务(a1-a2,a2故障,a1也是故障)
            if (dependency[1].equals(fault) && !faultList.contains(dependency[0])) {
                faultList.add(dependency[0]);
                checkError(dependency[0]);
            }
        }
    }
}
