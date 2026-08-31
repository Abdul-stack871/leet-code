// Last updated: 8/31/2026, 10:13:22 AM
1class Solution {
2    public int[] nodesBetweenCriticalPoints(ListNode head) {
3        List<Integer> nums = new ArrayList<>();
4        
5        while (head != null) {
6            nums.add(head.val);
7            head = head.next;
8        }
9        
10        List<Integer> criticalPoints = new ArrayList<>();
11        int n = nums.size();
12        
13        for (int i = 1; i < n - 1; i++) {
14            boolean isLocalMax = nums.get(i) > nums.get(i - 1) && nums.get(i) > nums.get(i + 1);
15            boolean isLocalMin = nums.get(i) < nums.get(i - 1) && nums.get(i) < nums.get(i + 1);
16            
17            if (isLocalMax || isLocalMin) {
18                criticalPoints.add(i);
19            }
20        }
21        
22        int m = criticalPoints.size();
23        if (m < 2) {
24            return new int[] { -1, -1 };
25        }
26        
27        int minDist = Integer.MAX_VALUE;
28        int maxDist = criticalPoints.get(m - 1) - criticalPoints.get(0);
29        for (int i = 1; i < m; i++) {
30            minDist = Math.min(minDist, criticalPoints.get(i) - criticalPoints.get(i - 1));
31        }
32        
33        return new int[] { minDist, maxDist };
34    }
35}