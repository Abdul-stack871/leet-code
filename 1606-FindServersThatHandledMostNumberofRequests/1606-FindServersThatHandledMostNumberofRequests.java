// Last updated: 11/9/2026, 7:22:42 AM
1import java.util.*;
2
3class Solution {
4    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
5
6        TreeSet<Integer> availableServers = new TreeSet<>();
7        for (int i = 0; i < k; i++) {
8            availableServers.add(i);
9        }
10
11        int[] countRequestsPerServer = new int[k];
12
13      
14        PriorityQueue<int[]> runningRequests = new PriorityQueue<>(
15            (a, b) -> Integer.compare(a[0], b[0])
16        );
17
18        for (int i = 0; i < arrival.length; i++) {
19            int currArrival = arrival[i];
20
21           
22            while (!runningRequests.isEmpty() && runningRequests.peek()[0] <= currArrival) {
23                int[] completed = runningRequests.poll();
24                availableServers.add(completed[1]);
25            }
26
27            if (availableServers.isEmpty()) {
28                continue;
29            }
30
31        
32            int targetServer = i % k;
33            Integer server = availableServers.ceiling(targetServer);
34
35          
36            if (server == null) {
37                server = availableServers.first();
38            }
39
40            runningRequests.add(new int[] { currArrival + load[i], server });
41            countRequestsPerServer[server]++;
42            availableServers.remove(server);
43        }
44
45        int maxRequests = 0;
46        for (int count : countRequestsPerServer) {
47            maxRequests = Math.max(maxRequests, count);
48        }
49
50        List<Integer> busiest = new ArrayList<>();
51        for (int i = 0; i < k; i++) {
52            if (countRequestsPerServer[i] == maxRequests) {
53                busiest.add(i);
54            }
55        }
56
57        return busiest;
58    }
59}