package com.makun.data_struct;

/**
 * @author Created by makun
 * @Date 2018/5/29.
 */
public class Demo {
    public static void main(String[] a){
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode current = head;
        head = head.next;
        ListNode tmp ;
        ListNode preNode = current;
        while (current != null && current.next != null){
            tmp = current.next;
            current.next = tmp.next;
            tmp.next = current;
            current = current.next;
            preNode.next = tmp;
        }
        return head;
    }
    static class ListNode {
        int data ;
        ListNode next;
        public ListNode(int data)
        {
            this.data = data;
        }
    }
}
