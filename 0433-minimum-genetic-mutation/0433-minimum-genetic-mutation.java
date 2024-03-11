class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> hashset = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        for (String str : bank) {
            hashset.add(str);
        }
        
        char[] arr = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size > 0) {
                String current = queue.poll();
                
                if (current.equals(endGene)) {
                    return count;
                }
                
                for (char ch : arr) {
                    char[] charArray = current.toCharArray();
                    
                    for (int i = 0; i < charArray.length; i++) {
                        char originalChar = charArray[i];
                        
                        if (charArray[i] != ch) {
                            charArray[i] = ch;
                            String neighbour = String.valueOf(charArray);
                            
                            if (!visited.contains(neighbour) && hashset.contains(neighbour)) {
                                queue.add(neighbour);
                                visited.add(neighbour);
                            }
                        }
                        
                        charArray[i] = originalChar;  // Revert the change to explore other possibilities
                    }
                }
                size--;
            }
            count++;
        }
        return -1;  // If no valid mutation sequence is found
    }
}
