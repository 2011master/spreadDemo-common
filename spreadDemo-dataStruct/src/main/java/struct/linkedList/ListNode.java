package struct.linkedList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 单链表
 */
public class ListNode {

    private int val;
    private ListNode next;

    ListNode(int val) {

        this.val = val;
        this.next = null;
    }

    //给链表赋值

    public static ListNode getListNode() {

        ListNode listNode = new ListNode(1);

        ListNode cur = listNode;
        for (int i = 2; i <= 4; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }


        return listNode;
    }

    public static void printListNode(ListNode head) {

       while (null != head){

           System.out.print(head.val + "->");
           head = head.next;
       }
        System.out.print("null");

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }


    public static void main(String[] args) {
//
//        ListNode listNode = getListNode();
//        printListNode(listNode);
//
//        ListNode reverse = reverse(listNode);
//        System.out.println();
//        printListNode(reverse);
//
//        ListNode listNode1 = reverseByStack(getListNode());
//        System.out.println();
//
//        printListNode(listNode1);

        ListNode node = detectCycle(new ListNode(1));

        printListNode(node);

    }

    /**
     * 思路:先将 当前处理head存到tmp中,待处理下个节点时将tmp赋值给该节点.
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {

        ListNode cur = null;
        ListNode pre = null;

        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }

        return pre;
    }


    /**
     * 通过栈进行反转
     * @param head
     * @return
     */
    public static ListNode reverseByStack(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        while (null != head) {
            stack.push(head);
            head = head.next;
        }

        ListNode reverseNode = stack.pop();
        ListNode curNode = reverseNode;

        while (!stack.empty()) {
             curNode.next = stack.pop();
             curNode = curNode.next;
        }
        curNode.next = null;

        return reverseNode;
    }

    /**
     * 环路检测
     *https://leetcode-cn.com/problems/linked-list-cycle/
     * @param head
     * @return
     */
    public boolean isCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow.val != fast.val) {
            if (slow.next == null || fast.next.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }

    /**
     * 环路检测:如果是环,找到环的入口
     *https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
     * @param head
     * @return
     */

    public static ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {

            if (fast.next != null) {
                fast = fast.next.next;
            }else {
                return null;
            }

            slow = slow.next;

            if (slow == fast) {
                ListNode temp = head;
                while (temp != slow) {
                    slow = slow.next;
                    temp = temp.next;
                }
                return temp;
            }

        }

        return null;
    }

    /**
     * 合并两个有序链表(递归法) https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
             l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
             l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }



    }

    /**
     * 删除链表的倒数第N个节点
     * 快慢指针法
     * 思考:
     *  1. 单链表在删除时要找到其前驱节点
     *  2. 通过让快指针比慢指针快n步,那么当快指针指向null时,慢指针正常位于倒数第n个节点
     *  3. 增加哨兵,并让second等于哨兵,这样当快指针指向null时,慢指针正常位于倒数第n+1个节点,即前驱节点
     * @param head
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head ,int n) {

        if (null == head) return null;

        ListNode pre = new ListNode(-1);

        pre.next = head;

        ListNode first = head;
        ListNode second = pre;

        //让快指针前进至n+1个节点
        int count = 1;
        while (count <= n) {
            count++;
            if (first == null) return null;
            first = first.next;
        }
        //快慢指针共同向前走
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        //删除
        second.next = second.next.next;

        return pre.next;

     }

    /**
     * 删除链表的倒数第N个节点
     * 通过栈的特性实现
     * 思考: 可以发现要删除的节点的前驱节点正好是pop n个节点后的栈顶节点.
     * @param head
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head ,int n) {

        Deque<ListNode> stack = new LinkedList<ListNode>();

        ListNode pre = new ListNode(-1);

        pre.next = head;

        ListNode cur = pre;
        while (cur != null) {

            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode listNode = stack.peek();

        listNode.next = listNode.next.next;

        return pre.next;

    }


    /**
     * 链表的中间结点
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点
     * 如果有两个中间结点，则返回第二个中间结点。
     * 快慢指针法
     * 思考: 让快指针与慢指针都从head开始,快指针每次比慢指针多走一步git config --global user.name ,这样,当快指针走到终点时,慢指针正好到中间节点.
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {

        if (null == head || null == head.next) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        while (first.next != null) {
            first = first.next.next;
            second = second.next;
        }

        return second;
    }

}
