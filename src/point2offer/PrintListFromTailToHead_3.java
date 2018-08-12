package point2offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PrintListFromTailToHead_3 {
    private static PrintListFromTailToHead_3 obj = new PrintListFromTailToHead_3();
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        List<Integer> list = obj.printListFromTailToHeadRecursion(listNode1);
        for (Integer value : list) {
            System.out.println(value);
        }
    }
    /**
     * 1. 栈缓存，ac
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHeadStack(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        ListNode tempNode = listNode;
        while (tempNode != null) {
            stack.push(tempNode.val);
            tempNode = tempNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHeadRecursion(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode != null) {
            if (listNode.next != null) {
                list = printListFromTailToHeadRecursion(listNode.next);
            }
            list.add(listNode.val);
        }
        return list;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


