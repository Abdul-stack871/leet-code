# Last updated: 7/14/2026, 2:22:56 PM
class Solution:
    def sumAndMultiply(self, s: str, queries: list[list[int]]) -> list[int]:
        m = len(s)
        MOD = 1_000_000_007
        
        nz_digits = []
        nz_indices = []
        for i, char in enumerate(s):
            if char != '0':
                nz_digits.append(int(char))
                nz_indices.append(i)
        
        n = len(nz_digits)
        pref_sum = [0] * (n + 1)
        pref_concat = [0] * (n + 1)
        pow10 = [1] * (n + 1)
        
        for i in range(n):
            pref_sum[i + 1] = (pref_sum[i] + nz_digits[i]) % MOD
            pref_concat[i + 1] = (pref_concat[i] * 10 + nz_digits[i]) % MOD
            pow10[i + 1] = (pow10[i] * 10) % MOD
            
        import bisect
        
        results = []
        for l, r in queries:
            start_idx = bisect.bisect_left(nz_indices, l)
            end_idx = bisect.bisect_right(nz_indices, r) - 1
            
            if start_idx > end_idx:
                results.append(0)
                continue
            
            s_c, e_c = start_idx + 1, end_idx + 1
            
            current_sum = (pref_sum[e_c] - pref_sum[s_c - 1]) % MOD
            
            # Concatenated value x
            length = e_c - s_c + 1
            x = (pref_concat[e_c] - (pref_concat[s_c - 1] * pow10[length])) % MOD
            
            results.append((x * current_sum) % MOD)
            
        return results