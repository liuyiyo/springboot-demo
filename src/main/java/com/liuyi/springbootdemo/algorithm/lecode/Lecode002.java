package com.liuyi.springbootdemo.algorithm.lecode;

import java.util.List;

/**
 * @ClassName Lecode002
 * @description：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @author：liuyi
 * @Date：2021/5/27 15:19
 */
public class Lecode002 {

    /**
     * @Author liuyi
     * @Description //反转链表
     * 1>2>3>null 转为null<1<2<3
     * @Date 2021/5/27 16:36
     * @Param [head]
     * @return com.liuyi.springbootdemo.algorithm.lecode.ListNode
     **/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

