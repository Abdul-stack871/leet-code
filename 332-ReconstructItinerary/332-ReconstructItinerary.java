// Last updated: 7/14/2026, 2:24:48 PM
import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        
        List<String> itinerary = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        while (!stack.isEmpty()) {
            String curr = stack.peek();
            if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                stack.push(adj.get(curr).poll());
            } else {
                itinerary.add(0, stack.pop());
            }
        }
        
        return itinerary;
    }
}