class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = nums1.length - 1;
        while (m - 1 >= 0 && n - 1 >= 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[length] = nums1[m - 1];
                m--;
            } else {
                nums1[length] = nums2[n - 1];
                n--;
            }
            length--;
        }
        while (m - 1 >= 0) {
            nums1[length] = nums1[m - 1];
            m--;
            length--;
        }
        while (n - 1 >= 0) {
            nums1[length] = nums2[n - 1];
            n--;
            length--;
        }
    }
}
