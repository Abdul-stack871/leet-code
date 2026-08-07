// Last updated: 8/7/2026, 11:05:55 AM
1class Solution {
2    public boolean circularArrayLoop(int[] nums) {
3        int len = nums.length;
4
5        boolean[] visited = new boolean[len];
6        for(int i = 0; i < len; i++){
7            if(!visited[i]){
8                if(nums[i] > 0){
9                    pos = true;
10                    if(passing(visited, i, nums, len, true, new boolean[len]) && pos) return true;
11                }
12                else{
13                    pos = false;
14                    if(passing(visited, i, nums, len, true, new boolean[len]) && !pos) return true;
15                }
16
17            }
18        }
19
20        return false;
21    }
22
23    boolean pos;
24    public boolean passing(boolean[] visited, int ind, int[] nums, int len, boolean flg, boolean[] visit){
25        if(visit[ind]) return true;
26        visited[ind] = true;
27
28        visit[ind] = true;
29        int limit = ind+nums[ind];
30        limit %= len;
31        
32        if(flg && pos && nums[ind] < 0){
33            pos = false;
34            flg = false;
35        }
36        else if(flg && !pos && nums[ind] > 0){
37            pos = true;
38            flg = false;
39        }
40
41        if(limit >= len) limit %= len;
42        if(limit < 0) limit = len+limit;
43
44        if(limit == ind || !flg) return false;
45        return passing(visited, limit, nums, len, flg, visit);
46    }
47}