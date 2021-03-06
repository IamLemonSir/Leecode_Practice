package com.test.leecode;

/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。如果不含有 “山脉” 则返回 0。
 *
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 *
 * 示例 2：
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class Leecode845 {

    public int longestMountain(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        for (int i = 1; i < A.length; i++){
            left[i] = A[i] > A[i - 1] ? left[i - 1] + 1 : 0;
        }

        for (int j = A.length - 2; j >= 0; j--){
            right[j] = A[j] > A[j + 1] ? right[j + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++){
            if (left[i] > 0 && right[i] > 0){
                if (left[i] == right[i]){
                    ans = Math.max(ans, left[i] + right[i] + 1);
                }else {
                    ans = Math.max(ans, Math.min(left[i], right[i]) * 2 + 1);
                }
            }
        }
        return ans;
    }
}
