// Last updated: 7/14/2026, 2:26:43 PM
import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            if (i < n) {
                factorial *= i;
            }
        }
        
        k--;
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int index = k / factorial;
            result.append(numbers.get(index));
            
            numbers.remove(index);
            
            if (numbers.size() > 0) {
                k %= factorial;
                factorial /= numbers.size();
            }
        }
        
        return result.toString();
    }
}