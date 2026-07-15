// Last updated: 7/15/2026, 2:02:05 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        
14        if(head.next == null) return null ;
15
16        ListNode ptr = head ;
17        ListNode temp = head ;
18
19
20        int i = 1 ;
21        while(i <= n) {
22            ptr = ptr.next ;
23            i++ ;
24        }
25
26
27        if(ptr == null) return head.next ;
28
29
30        while(ptr.next != null){
31            ptr = ptr.next;
32            temp = temp.next ;
33        }
34
35        if(temp.next != null){
36            temp.next = temp.next.next ;
37        }
38
39        return head ;
40    }
41}