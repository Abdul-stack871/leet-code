// Last updated: 7/14/2026, 2:25:34 PM
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            // Adjust to 0-indexed for modulo operation
            columnNumber--; 
            
            // Get the current character
            char c = (char) ('A' + (columnNumber % 26));
            result.append(c);
            
            // Move to the next digit
            columnNumber /= 26;
        }
        
        // The characters are added in reverse order
        return result.reverse().toString();
    }
}