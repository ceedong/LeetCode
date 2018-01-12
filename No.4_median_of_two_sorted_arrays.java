/**
 * Merging sort applies to this problem and two pointers are given to each array.
 * Just get a medium performance and it DO passed.
 * The problem is I do not use recursion in this problem and the time complexity is O(m+n).
 */
 
 class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            length = length / 2;
            int i = 0, j = 0;
            int result = 0;
            for (int k = 0; k <= length; k++) {
                if (i >= nums1.length) result = nums2[j++];
                else if (j >= nums2.length) result = nums1[i++];
                else if (nums1[i] < nums2[j]) result = nums1[i++];
                else result = nums2[j++];
            }
            return (double)result;
        }
        else {
            length = length / 2 - 1;
            int i = 0, j = 0;
            int result = 0;
            for (int k = 0; k <= length; k++) {
                if (i >= nums1.length) result = nums2[j++];
                else if (j >= nums2.length) result = nums1[i++];
                else if (nums1[i] < nums2[j]) result = nums1[i++];
                else result = nums2[j++];
            }
            if (i < nums1.length && j < nums2.length)
            return (double)(result + Math.min(nums1[i], nums2[j])) / 2; //note: Math.min() not Math.max()
            else if (i < nums1.length) return (double)(result + nums1[i]) / 2;
            else return (double)(result + nums2[j]) / 2;
        }
    }
}

/**
 * I didn't get the O(log(m + n)) DP solution.... so will be updated a little after.
 */
