// Last updated: 8/24/2026, 12:13:37 PM
1class Solution {
2    public Node copyRandomList(Node head) {
3
4        if (head == null) {
5            return null;
6        }
7
8        HashMap<Node, Node> map = new HashMap<>();
9
10        Node current = head;
11
12        while (current != null) {
13            map.put(current, new Node(current.val));
14            current = current.next;
15        }
16
17        current = head;
18
19        while (current != null) {
20
21            Node copy = map.get(current);
22
23            copy.next = map.get(current.next);
24            copy.random = map.get(current.random);
25
26            current = current.next;
27        }
28
29        return map.get(head);
30    }
31}