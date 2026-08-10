// Last updated: 8/10/2026, 11:37:16 AM
1class Solution {
2    public boolean isPossible(int[] nums) {
3
4        PriorityQueue<int[]> heap = new PriorityQueue<>(
5            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
6        );
7        
8        for (int num : nums) {
9            while (!heap.isEmpty() && heap.peek()[0] < num - 1) {
10                if (heap.poll()[1] < 3) {
11                    return false; 
12                }
13            }
14            
15            if (!heap.isEmpty() && heap.peek()[0] == num - 1) {
16                int[] top = heap.poll();
17                heap.offer(new int[] { num, top[1] + 1 });
18            } else {
19                heap.offer(new int[] { num, 1 });
20            }
21        }
22        
23        while (!heap.isEmpty()) {
24            if (heap.poll()[1] < 3) {
25                return false;
26            }
27        }
28        
29        return true;
30    }
31}