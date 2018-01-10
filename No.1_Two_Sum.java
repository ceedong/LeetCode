/**
 * The first thought is selection sort, but the time complexity is O(n^2).
 */
 
 class Solution-1 {
    public int[] twoSum(int[] nums, int target) {
       if (nums == null || nums.length <= 1) return new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}

/**
 * The second thought is to sort the array and then binary search. 
 * Using API: Arrays.sort().
 * Failed because the return value are the index, can not be changed, which means this question doesn't allow sorting.
 */
 
 /**
  * The third thought is to use HashTable but also failed in choosing the key value pairs in cases when keys are the same.
  * Input: [3,2,4] 6
  * Desired Output: [1,2]
  * I got: [0,0]
  */
  
  class Solution-2 {
    public int[] twoSum(int[] nums, int target) {
        
        // Initialize the map and put key-value pairs
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int toFind = target - nums[j];
            if (map.containsKey(toFind)) {
                return new int[] {map.get(toFind), j};
            }
        }
        throw new IllegalArgumentException("I didn't get the answers!");
    }
}

/**
* The fourth try modifies the condition, when the key corresponding to target value is not equal to the current index, then
* it is done.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
        * Initialize the map and put key-value pairs
        */
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int toFind = target - nums[j];
            if (map.containsKey(toFind) && map.get(toFind) != j) {
                return new int[] {map.get(toFind), j};
            }
        }
        throw new IllegalArgumentException("I didn't get the answers!");
    }
}
