/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            pq.offer(list);            
        }

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = curr;
            dummy = dummy.next;
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return res.next;
    }
}
