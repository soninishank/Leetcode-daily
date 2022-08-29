class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        // add all 0 in queue 
        for(int i = 0 ; i < rooms.length; i++){
            for(int j = 0 ; j < rooms[i].length ; j++){
                if(rooms[i][j]== 0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        while(!queue.isEmpty())
        {
            int[] pollValue = queue.poll();
            for(int[] dir : directions)
            {
                int x = pollValue[0] + dir[0];
                int y = pollValue[1] + dir[1];
                if(x >= 0 && y >= 0 && x <= rooms.length - 1 && y <= rooms[0].length-1 && rooms[x][y] == 2147483647)
                {
                   int value = rooms[pollValue[0]][pollValue[1]] + 1;
                    rooms[x][y] = Math.min(value, rooms[x][y]);
                   queue.add(new int[]{x,y});
                }
            }
        }   
    }
}