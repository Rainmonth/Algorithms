package cn.rainmonth.solution;

/**
 * @author 张豪成
 * @date 2019/9/21
 */
public class Solution {
    /**
     * 大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素。
     *
     * @param A 要处理的数组
     * @return 重复了N次的那个元素
     */
    public int repeatNTimes(int[] A) {
        for (int i = 0;i< A.length;i++) {
            if (A[i] == A[i+1]) {
                return A[i];
            }
        }
        if ((A[0] == A[3]) || A[0] == A[2]) {
            return A[0];
        } else {
            return A[1];
        }
    }
}
