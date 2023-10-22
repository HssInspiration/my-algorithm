package com.hss.algorithm.leetcode.editor.cn;//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 单调栈 👍 876 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  /*  public static void main(String[] args) {
        int[] ints = nextGreaterElements(new int[]{1, 2, 3, 4, 5});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }*/

    public int[] nextGreaterElements(int[] nums) {
        /*int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < len; i++) {
            int srcItem = nums[i];
            boolean needNext = true;
            for (int j = i; j < len; j++) {
                // 循环查找数组
                if (nums[j] > srcItem) {
                    res[i] = nums[j];
                    needNext = false;
                    break;
                }
            }
            if (needNext) {
                for (int j = 0; j < i; j++) {
                    // 循环查找数组
                    if (nums[j] > srcItem) {
                        res[i] = nums[j];
                        break;
                    }
                }
            }
        }
        return res;*/
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        // 遍历循环数组(数组长度为2*len-1, 对循环下标与原数组长度取余可以获取循环数组指定位置的值)
        for (int i = 0; i < 2 * len; i++) {
            // 当栈非空时且当前元素为栈顶元素[下一个更大元素]时（即当前元素大于栈顶元素），弹出栈内栈顶元素下标，并将当前元素赋值给新数组
            while (!deque.isEmpty() && nums[i % len] > nums[deque.peekLast()]) {
                int idx = deque.pollLast();
                res[idx] = nums[i % len];
            }
            deque.addLast(i % len);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
