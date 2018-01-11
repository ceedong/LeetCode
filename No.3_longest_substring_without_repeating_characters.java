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

/**
 * Another ituition is to use sliding window (I got it from the solution.)
 * The sliding window is going to be a hashset and then detect whether the given character appears or not.
 * Record the maximum length of the substring at the same time.
 */

class Solution-2 {
    /**
     * The second try is the sliding window method. And the sliding window is going to be
     * a hashSet.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.equals(null) || s.equals("")) return 0;
        char[] array = s.toCharArray();
        if (array.length == 1) return 1;
        Set<Character> set = new HashSet<Character>();
        int i = 0; // record the beginning of the substring
        int j = 0; // record the end of the substring
        int result = 0; // record the maximum length of the substring
        while (i < array.length && j < array.length) {
            if (!set.contains(array[j])) {
                set.add(array[j++]);
                result = Math.max(result, j - i);
            } else set.remove(array[i++]);
        }
        return result;
    }
    
}
/**
 * Note: also another optimal solution is provided but i just skipped :)
 */
