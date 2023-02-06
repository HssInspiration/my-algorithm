package com.hss.algorithm.advance;

import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 22:18
 * @Version 1.0.0
 */
public class 组装新的数组 {
    

        public static int max;
        public static int min;
        public static int res;

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String[] strings = sc.nextLine().split(" ");
            int M = sc.nextInt();

            min = Integer.valueOf(strings[0]);      //数组中的最小数
            max = Integer.valueOf(strings[strings.length - 1]);   //数组中的最大数
            handle(min, M);

            System.out.println(res);
        }

        /**
         * 3 4 5
         * 10
         * 5 5
         * 4 5 1
         * 4 4 2
         * 3 5 2
         * 3 3 4
         * 3 3 3 1
         *
         * @param n   数组中的数字
         * @param sum M减去数组中的数字的差值
         */
        public static void handle(int n, int sum) {

            if (sum < min) {  //剩下的小于最小数就可以组装（符合第三个规则）
                res++;
                return;
            }

            if (n > max) {    //大于最大数则返回
                return;
            }

            int i = 0;
            while (true) {

                handle(n + 1, sum - i * n);   //因为数组中的数字是连续的，所以只需要+1

                i++;
                if (sum - i * n <= 0) {
                    if (sum - i * n == 0) {     //完美符合
                        res++;
                    }
                    break;
                }
            }
        }
    }
