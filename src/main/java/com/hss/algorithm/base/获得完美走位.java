package com.hss.algorithm.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author hss
 * @Date 2023/2/6 21:51
 * @Version 1.0.0
 */
public class 获得完美走位 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int len = str.length();
        int count = len / 4;  //求出每个方向所需的个数（题目已规定len是4的倍数）

        /**
         * key：A、S、D、W四个方向
         * value：各个方向的个数
         */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            m.setValue(m.getValue() - count);   //计算出各个方向多余的个数
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {

            char cIndexI = str.charAt(i);

            int res = 0;
            Map<Character, Integer> copyMap = new HashMap<>(map);   //需要复制一个map，以防影响原始map的数据
            if (copyMap.get(cIndexI) > 0) {  //大于0，说明此方向有多余，不能到达原点

                /**
                 * 从index=i开始向后遍历
                 * 遍历到的方向可以变换成任意方向
                 * 假如此时方向我们进行改变，则map中该方向的个数进行-1，变换的次数+1
                 * 每次变换完都需要判断map中是否有value值大于0
                 * 如果有value大于0，则代表还有多余的方向，无法到达原点，继续进行遍历
                 * 如果没有value大于0，则代表没有多余的方向，可以到达原点，结束遍历
                 * 以此类推，求出最小的变换次数
                 * 如AAAA，计算出每个方向应该出现1（4/4）次
                 * map{ key:A, value:3（4-1）}
                 * 当i=0时，char=A，map.get(A)=3>0，方向多余，不能到达原点;
                 * 从j=0开始遍历，char=A，map.get(A)-1=3-1=2，res+1=1；
                 * map中只有A，value=2>0，有方向多余，不能到达原点；
                 * 向后遍历，j=1，char=A，map.get(A)-1=2-1=1，res+1=2；
                 * map中只有A，value=1>0，有方向多余，不能到达原点；
                 * 向后遍历，j=2，char=A，map.get(A)-1=1-1=0，res+1=3；
                 * map中只有A，value=0==0，没有方向多余，可以到达原点；
                 * 则变换的长度为3
                 * 当i=1时，char=A，map.get(A)=3>0，方向多余，不能到达原点;
                 * 从j=1开始遍历，char=A，map.get(A)-1=3-1=2，res+1=1；
                 * map中只有A，value=2>0，有方向多余，不能到达原点；
                 * 向后遍历，j=2，char=A，map.get(A)-1=2-1=1，res+1=2；
                 * map中只有A，value=1>0，有方向多余，不能到达原点；
                 * 向后遍历，j=3，char=A，map.get(A)-1=1-1=0，res+1=3；
                 * map中只有A，value=0==0，没有方向多余，可以到达原点；
                 * 则变换的长度为3
                 * 当i=2时，char=A，map.get(A)=3>0，方向多余，不能到达原点;
                 * 但是后面的A只剩1个，最后map中A的value会剩下1，不能到达原点；
                 * 所以最终更换的最小长度为3
                 */
                for (int j = i; j < len; j++) {
                    char cIndexJ = str.charAt(j);
                    copyMap.put(cIndexJ, copyMap.get(cIndexJ) - 1);    //此方向可以变换成任意方向，个数-1
                    res++;     //需要变换的连续走位的个数
                    if (isTrue(copyMap)) {   //判断是否可以到达原点
                        break;  //如果可以到达原点，则退出循环
                    }
                }
            }

            if (isTrue(copyMap)) {   //如果到达原点则求出其中的最小值
                min = Math.min(min, res);
            }
        }

        System.out.println(min);
    }

    /**
     * 没有多余的方向，说明可以到达原点
     *
     * @param map
     * @return
     */
    public static boolean isTrue(Map<Character, Integer> map) {

        for (Integer i : map.values()) {
            if (i > 0) {  //任何方向有多余的都不能回到原点
                return false;
            }
        }

        return true;    //所有方向多余的个数为0则能回到原点
    }
}
