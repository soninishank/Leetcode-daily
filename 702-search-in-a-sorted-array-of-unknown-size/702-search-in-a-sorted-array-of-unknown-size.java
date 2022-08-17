/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {

    public int search(ArrayReader reader, int target) {
        int high = 1;
        while (reader.get(high) < target) {
            high = high << 1;
        }
        int low = high >> 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = reader.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

 // int hi = 1;
 //    while (reader.get(hi) < target) {
 //        hi = hi << 1;
 //    }
 //    int low = hi >> 1;
 //    while (low <= hi) {
 //        int mid = low+(hi-low)/2;
 //        if (reader.get(mid) > target) {
 //            hi = mid-1;
 //        } else if (reader.get(mid) < target) {
 //            low = mid+1;
 //        } else {
 //            return mid;
 //        }
 //    }
 //    return -1;
