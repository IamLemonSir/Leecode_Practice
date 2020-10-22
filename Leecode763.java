package com.lemon.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串
 * 片段的长度的列表。 
 *
 * 示例 1：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class Leecode763 {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        // 创建hash表存储每个字符对应的last index
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++){
            if (!map.containsKey(S.charAt(i))){
                map.put(S.charAt(i), S.lastIndexOf(S.charAt(i)));
            }
        }

        Integer index = 0;
        Integer end = map.get(S.charAt(0));
        int length = 0;

        for (int j = 0; j < S.length(); j++){
            if (index < end){
                if (map.get(S.charAt(j)) <= end){
                    index++;
                }else {
                    end = Math.max(end, map.get(S.charAt(j)));
                    index++;
                }
            }else {
                list.add(index + 1 - length);
                length = index + 1;
                if ((index + 1) < S.length()){
                    end = map.get(S.charAt(index + 1));
                }
                index++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(Arrays.asList(list));
    }
}
