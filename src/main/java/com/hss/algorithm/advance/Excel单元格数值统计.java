package com.hss.algorithm.advance;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:09
 * @Version 1.0.0
 */
public class Excel单元格数值统计 {


    /*public static String[][] strings;

    public static void main3(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        strings = new String[row][col];
        for (int i = 0; i < row; i++) {
            strings[i] = sc.nextLine().split(" ");
        }

        String[] nums = sc.nextLine().split(":");
        int[] start = zuobiao(nums[0]);
        int[] end = zuobiao(nums[1]);

        int sum = 0;
        for (int i = start[0]; i <= end[0]; i++) {
            for (int j = start[1]; j <= end[1]; j++) {
                String temp = strings[i][j];
                if (temp.contains("=")) {
                    sum += jisuan(temp);
                } else {
                    sum += Integer.valueOf(temp);
                }
            }
        }

        System.out.println(sum);
    }

    public static int jisuan(String s) {

        s = s.replace("=", "");
        boolean jiafa = true;   //是否为加法运算
        boolean isDigit = true;     //是否为纯数字
        int num1 = 0;
        int num2 = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+') {
                if (c == '-') {
                    jiafa = false;
                }
                if (isDigit) {    //纯数字
                    num1 = Integer.valueOf(temp);
                } else {
                    int[] ints = zuobiao(temp); //先求出其坐标位置
                    String str = strings[ints[0]][ints[1]];
                    if (str.contains("=")) {  //如果此坐标位置还是一个算式需要继续求值
                        num1 = jisuan(str);
                    } else {
                        num1 = Integer.valueOf(str);
                    }
                }
                temp = "";
                isDigit = true;
            } else {
                if (Character.isLetter(c)) {
                    isDigit = false;    //包含字母则非纯数字
                }
                temp += c;
            }
            if (i == s.length() - 1) {
                if (isDigit) {    //纯数字
                    num2 = Integer.valueOf(temp);
                } else {
                    int[] ints = zuobiao(temp); //先求出其坐标位置
                    String str = strings[ints[0]][ints[1]];
                    if (str.contains("=")) {  //如果此坐标位置还是一个算式需要继续求值
                        num2 = jisuan(str);
                    } else {
                        num2 = Integer.valueOf(str);
                    }
                }
            }
        }

        return jiafa ? num1 + num2 : num1 - num2;
    }

    public static int[] zuobiao(String s) {

        int y = s.charAt(0) - 'A';
        String num = "";
        for (int i = 1; i < s.length(); i++) {
            num += s.charAt(i);
        }

        return new int[]{Integer.valueOf(num) - 1, y};
    }*/

    private static String[][] excel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        excel = new String[row][col];
        for (int i = 0; i < row; i++) {
            excel[i] = sc.nextLine().split(" ");
        }
        String[] locations = sc.nextLine().split(":");
        int[] startArray = location(locations[0]);
        int[] endArray = location(locations[1]);
        int sum = 0;
        for (int i = startArray[0]; i <= endArray[0]; i++) {
            for (int j = startArray[1]; j <= endArray[1]; j++) {
                String temp = excel[i][j];
                if (temp.contains("=")) {
                    // 是公式进行计算
                    sum += cal(temp);
                } else {
                    // 否则直接加
                    sum += Integer.parseInt(temp);
                }
            }
        }
        System.out.println(sum);
    }

    private static int cal(String temp) {
        temp = temp.replace("=", "");
        int numFirst = 0, numSec = 0;
        boolean plusFlag = true, isNum = true;
        StringBuilder val = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (c == '+' || c == '-') {
                if (c == '-') {
                    plusFlag = false;
                }
                numFirst = getNum(isNum, val.toString());
                // 重置原有的值
                val = new StringBuilder();
                isNum = true;
            } else {
                if (!Character.isDigit(c)) {
                    isNum = false;
                }
                val.append(c);
            }
            if (i == temp.length() - 1) {
                numSec = getNum(isNum, val.toString());
            }
        }
        return plusFlag ? numFirst + numSec : numFirst - numSec;
    }

    private static int getNum(boolean isNum, String val) {
        if (isNum) {
            return Integer.parseInt(val);
        }
        int result;
        if (val.contains("=")) {
            result = cal(val);
        } else {
            int[] intArr = location(val);
            String actualVal = excel[intArr[0]][intArr[1]];
            result = Integer.parseInt(actualVal);
        }
        return result;
    }

    private static int[] location(String location) {
        // 获取列
        int col = location.charAt(0) - 'A';
        // 返回行与列
        return new int[]{Integer.parseInt(location.substring(1)) - 1, col};
    }
}
