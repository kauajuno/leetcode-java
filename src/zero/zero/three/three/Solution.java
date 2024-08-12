package zero.zero.three.three;

class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int c = l + (r - l) / 2;
            if (nums[c] == target) {
                return c;
            } else if (nums[c] >= nums[l]) {
                if (target >= nums[l] && target <= nums[c]) {
                    r = c - 1;
                } else {
                    l = c + 1;
                }
            } else {
                if (target >= nums[c] && target <= nums[r]) {
                    l = c + 1;
                } else {
                    r = c - 1;
                }
            }
        }

        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{3, 1}, 1));
    }
}
