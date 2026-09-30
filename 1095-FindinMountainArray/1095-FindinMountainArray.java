// Last updated: 9/30/2026, 12:38:30 PM
1class Solution {
2    public int findInMountainArray(int target, MountainArray mountainArr) {
3        int n = mountainArr.length();
4
5        int left = 0, right = n - 1;
6
7        while (left < right) {
8            int mid = (left + right) / 2;
9
10            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
11                left = mid + 1;
12            else
13                right = mid;
14        }
15
16        int peak = left;
17
18        left = 0;
19        right = peak;
20
21        while (left <= right) {
22            int mid = (left + right) / 2;
23            int value = mountainArr.get(mid);
24
25            if (value == target)
26                return mid;
27            else if (value < target)
28                left = mid + 1;
29            else
30                right = mid - 1;
31        }
32
33        left = peak + 1;
34        right = n - 1;
35
36        while (left <= right) {
37            int mid = (left + right) / 2;
38            int value = mountainArr.get(mid);
39
40            if (value == target)
41                return mid;
42            else if (value > target)
43                left = mid + 1;
44            else
45                right = mid - 1;
46        }
47
48        return -1;
49    }
50}