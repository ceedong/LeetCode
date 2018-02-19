/**
 * The code is similar to laicode, the difference is only that, when adding, 
 * result.add(new ArrayList<Integer>(resultPre));
 * do not
 * result.add(resultPre);
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) return result;
        List<Integer> resultPre = new ArrayList<>();
        subsets(nums, 0, result, resultPre);
        return result;
    }
    private void subsets(int[] nums, int index, List<List<Integer>> result, List<Integer> resultPre) {
        // base case
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(resultPre));
            return;
        }
        // case-1: add the number
        resultPre.add(nums[index]);
        subsets(nums, index + 1, result, resultPre);
        resultPre.remove(resultPre.size() - 1);
        
        // case-2: not add the number
        subsets(nums, index + 1, result, resultPre);
    }
}
