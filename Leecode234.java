package com.test.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class Leecode234 {
    public boolean isPalindrome(ListNode head) {
        if (head != null) {
            List<Integer> list = new ArrayList();

            while (head != null){
                list.add(head.value);
                head = head.nextNode;
            }

            int start = 0;
            int end = list.size() - 1;

            while (start < end){
                if (!list.get(start).equals(list.get(end))){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(-129 == -129);
    }
}

class ListNode{
    int value;
    ListNode nextNode;

    ListNode(int value){
        this.value = value;
    }
}
