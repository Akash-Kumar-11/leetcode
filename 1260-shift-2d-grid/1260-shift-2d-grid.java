class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        List<List<Integer>> list = new ArrayList<>();


        k = k % (row * col);

        for(int i = 0; i<k;i++){
            int curr = grid[0][0];
            int prev = grid[0][0];

            for(int r=0;r<row;r++){
                for(int c = 0;c<col;c++){
                    prev = curr;
                    curr = grid[r][c];
                    grid[r][c] = prev;
                }
            }
            grid[0][0] = curr;
        }

        for(int i = 0; i < row ; i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<col;j++){
                l.add(grid[i][j]);
            }
            list.add(l);
        }     

        return list;   


    }
}