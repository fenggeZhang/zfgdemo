package com.zfg.test.javatest.algorithm;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/8/23
 * desc   :
 */
public class ReverLinkedList {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node5.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;
        node1.next = null;
        reverseList(node5);
    }

    //  3 2 1
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
//			System.out.println("return" + head.val);
            return head;
        }
        ListNode newNode = reverseList(head.next);
//        System.out.println("head val" + head.val);
//        System.out.println("newNode " + newNode.val);
        head.next.next = head;
//        System.out.println("head.next.next val " + head.next.next.val);
        head.next = null;
//        System.out.print(newNode.val);
        return newNode;
    }
}
