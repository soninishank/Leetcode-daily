class Leaderboard {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public Leaderboard() {}

    public void addScore(int playerId, int score) {
        hashMap.put(playerId, hashMap.getOrDefault(playerId,0) + score);
    }

    public int top(int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int keys : hashMap.keySet()) {
            priorityQueue.add(hashMap.get(keys));
        }
        int sum = 0;
        while (K > 0 && !priorityQueue.isEmpty()) {
            sum += priorityQueue.poll();
            K--;
        }
        return sum;
    }

    public void reset(int playerId) {
        hashMap.remove(playerId);
    }
}
/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
