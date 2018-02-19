/**
 * The swap edition is really tricky but worth trying. 
 * A good version to keep up.
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) return result;
        permute(nums, 0, result);
        return result;
    }
    private void permute(int[] nums, int index, List<List<Integer>> result) {
        if (nums.length == index) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
               temp.add(nums[i]); 
            }
            result.add(temp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, index + 1, result);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
