class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
    
        def dfs(i, j, row_offset, col_offset, my_set):
            if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == 0:
                return
            
            grid[i][j] = 0
            my_set.add((row_offset,col_offset))
            
            dfs(i+1, j, row_offset+1, col_offset, my_set)
            dfs(i-1, j, row_offset-1, col_offset, my_set)
            dfs(i, j+1, row_offset, col_offset+1, my_set)
            dfs(i, j-1, row_offset, col_offset-1, my_set)
            return my_set
            
        islands = set()
        for i, j in itertools.product(range(m), range(n)):
            if grid[i][j] == 1:
                island = list(dfs(i, j, 0, 0, set()))
                islands.add(tuple(island))
                
        return len(islands)
        