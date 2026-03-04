import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/description/
public class N23MergeKSortedLists {


    public static void main(String[] args) {
        ListNode  node1 = new ListNode();
        node1.val = 1 ;
        ListNode  node4 = new ListNode();
        node4.val = 4;
        ListNode  node10 = new ListNode();
        node10.val = 10 ;
        ListNode  node6 = new ListNode();
        node6.val = 6 ;
        ListNode  node12 = new ListNode();
        node12.val = 12 ;
        ListNode  node5 = new ListNode();
        node5.val = 5 ;
        ListNode  node7 = new ListNode();
        node7.val = 7 ;


        node1.next = node4;
        node4.next = node10;
        node6.next = node12;
        node5.next = node7;

        List<ListNode> a = new ArrayList<>();
        a.add(node1);
        a.add(node6);
        a.add(node5);

        mergeKLists(a);

    }

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}


