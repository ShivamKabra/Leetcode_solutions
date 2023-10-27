class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        res=[]
        for r in range(len(mat)):
            res.append((sum(mat[r]),r))
        res.sort()
        res=res[:k]
        for i in range(k):
            res[i]=res[i][1]
        return res