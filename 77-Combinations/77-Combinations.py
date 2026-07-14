# Last updated: 7/14/2026, 2:26:26 PM
class Solution(object):
    def combine(self, n, k):
        return list(combinations(range(1,n+1), k))

        
        