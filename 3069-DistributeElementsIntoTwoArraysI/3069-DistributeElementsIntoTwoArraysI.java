// Last updated: 8/20/2026, 12:02:08 PM
1class Solution {
2    public int[] resultArray(int[] nums) {
3        int n = nums.length;
4        int[] arr1 = new int[n];
5        int[] arr2 = new int[n];
6        if(nums == null) return new int[0];
7        if(n <=1 ) return nums;
8        int index = 0, i=0, j=0;
9        arr1[i++] = nums[index++];
10        arr2[j++] = nums[index++];
11        while(index<n){
12            if(arr1[i-1]>arr2[j-1]) arr1[i++] = nums[index++];
13            else arr2[j++] = nums[index++];
14        }
15        System.arraycopy(arr2, 0, arr1, i, j);
16        return arr1;
17    }
18}