# Last updated: 7/14/2026, 2:23:59 PM
class Solution:
    def checkRecord(self, n: int) -> int:
        MOD = 10**9 + 7
        P=1
        L1=1
        L2=0
        A=1
        L1_A=0
        L2_A=0
        P_A=0

        k=1
        while k<n:
            P_next= (P+L1+L2)%MOD
            L1_next= (P)%MOD
            L2_next= L1%MOD
            A_next= (L1+L2+P)%MOD
            P_A_next= (A+L1_A+L2_A +P_A)%MOD
            L1_A_next= (P_A+A)%MOD
            L2_A_next=(L1_A)%MOD
            k+=1

            P=P_next
            L1=L1_next
            L2=L2_next
            A=A_next
            L1_A=L1_A_next
            L2_A=L2_A_next
            P_A=P_A_next

        return(P+L1+L2+A+L1_A+L2_A+P_A)%MOD