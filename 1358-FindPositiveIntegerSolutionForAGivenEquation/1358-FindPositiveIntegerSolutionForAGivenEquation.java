// Last updated: 7/14/2026, 2:23:14 PM
class Solution {
    public List<List<Integer>> findSolution(CustomFunction func, int z) {
        List<List<Integer>> result= new ArrayList<>();

        for(int i=1; i<= 1000; i++){
            int x= i;

            int left= 1;
            int right= 1000;

            while(left <= right){
                int y= (left+right)/2;

                int val= func.f(x, y);
                if(val == z){
                    List<Integer> l1= new ArrayList<>();
                    l1.add(x);
                    l1.add(y);

                    result.add(l1);
                    break;
                }
                else if(val > z){
                    right= y-1;
                }
                else{
                    left= y+1;
                }
            }
        }

        return result;
    }
}