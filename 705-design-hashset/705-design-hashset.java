class MyHashSet {

    int hashNi = 1001;
    LinkedBucket[] linkedBuckets;

    public MyHashSet() {
        linkedBuckets = new LinkedBucket[hashNi];
        for (int i = 0; i < hashNi; i++) {
            linkedBuckets[i] = new LinkedBucket();
        }
    }

    public void add(int key) {
        int index = key % hashNi;
        linkedBuckets[index].addKey(key);
    }

    public void remove(int key) {
        int index = key % hashNi;
        linkedBuckets[index].delete(key);
    }

    public boolean contains(int key) {
        int index = key % hashNi;
        return linkedBuckets[index].linkedList.contains(key);
    }

    class LinkedBucket {
        LinkedList<Integer> linkedList = new LinkedList<>();

        public void addKey(int key) {
            if (!linkedList.contains(key)) {
                linkedList.addFirst(key);
            }
        }

         public void delete(Integer key) {
            linkedList.remove(key);
        }

        public boolean exists(int key) {
            if (linkedList.contains(key)) {
                return true;
            }
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */