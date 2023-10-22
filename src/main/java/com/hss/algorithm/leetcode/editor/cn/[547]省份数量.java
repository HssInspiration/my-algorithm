//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
// 
// 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
// 
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
// 
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 1057 👎 0


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // BFS广度优先搜索
        int cities = isConnected.length;
        boolean[] isVisited = new boolean[cities];
        int provinceCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cities; i++) {
            // 判断对应节点元素是否已访问
            if (!isVisited[i]) {
                // 往队列中添加一个元素
                queue.offer(i);
                // 当队列非空时，持续遍历
                while (!queue.isEmpty()) {
                    // 移除并获取栈元素
                    int j = queue.poll();
                    // 标记该元素已访问
                    isVisited[j] = true;
                    // 遍历数组
                    for (int k = 0; k < cities; k++) {
                        // 按照原先栈内的下标（对应第i行）与第j列判断该值是否为1，且是否未访问
                        if (isConnected[j][k] == 1 && !isVisited[k]) {
                            // 符合条件将k添加进队列中
                            queue.offer(k);
                        }
                    }
                }
                // 外层更新答案
                provinceCount++;
            }
        }
        return provinceCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
