/**
 * The first intuition is to list all the possible solutions and then:
 * 1) judge if it is a substring or not
 * 2) if so, judge whether the length is greater than the existing length or not
 * The solution fails when the string is really large and time out happens.
 *
 */
 
 class Solution-1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals(null) || s.equals("")) return 0;
        char[] array = s.toCharArray();
        if (array.length == 1) return 1;
        int length = 1; // record the maximum length
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (isSubstring(array, i, j)) {
                    if (length < (j - i + 1)) length = j - i + 1;
                }
            }
        }
        return length;
    }
    
    // helper method
    
    private boolean isSubstring(char[] array, int i, int j) {
        Set<Character> set = new HashSet<Character>();
        for (int k = i; k <= j; k++) {
            if (set.contains(array[k])) return false;
            else set.add(array[k]);
        }
        return true;
    }
}

/**
 * Points: 1) for strings use "equals()" rather than "=="
 *         2)initial value of length should be 1, like "bbbbbb"
 */
