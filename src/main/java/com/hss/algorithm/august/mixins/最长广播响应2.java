package com.hss.algorithm.august.mixins;

import java.util.*;

/**
 * @Author hss
 * @Date 2023/8/11 7:35
 * @Version 1.0.0
 */
public class 最长广播响应2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] relations = new int[t][2];
        for (int i = 0; i < t; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }
        int src = sc.nextInt();
        System.out.println(getResult(n, src, relations));
    }

    public static int getResult(int n, int src, int[][] relations) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int[] relation : relations) {
            int u = relation[0];
            int v = relation[1];
            graph.putIfAbsent(u, new ArrayList<>(Collections.singletonList(v)));
            graph.putIfAbsent(v, new ArrayList<>(Collections.singletonList(u)));
        }
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(src, 0);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        while (true) {
            if (graph.containsKey(src)) {
                for (Integer v : graph.get(src)) {
                    int newDist = dist.get(src) + 1;
                    if (newDist < dist.get(v)) {
                        dist.set(v, newDist);
                        pq.offer(new Integer[]{v, newDist});
                    }
                }
            }
            if (pq.isEmpty()) break;
            src = pq.poll()[0];
        }
        dist.remove(0);
        return dist.stream().max(Comparator.comparingInt(a -> a)).get() * 2;
    }
}
