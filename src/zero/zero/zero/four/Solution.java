package zero.zero.zero.four;

// TODO: come back some day and find an appropriate approach to this because as of now I'm not able to

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if(nums1.length == 0){
            if(nums2.length % 2 == 1) return nums2[nums2.length / 2];
            return (double) (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2;
        }

        int ldown = 0, rdown = nums1.length - 1, mdown, mup;
        int totalLen = nums1.length + nums2.length;

        while (true) {
            mdown = ldown + (rdown - ldown) / 2;
            mup = (totalLen / 2) - mdown - 1;

            if (mdown == rdown) break;

            if (nums2[mup] > nums1[mdown + 1]) {
                ldown = mdown + 1;
            } else if (nums1[mdown] > nums2[mup + 1]) {
                rdown = mdown - 1;
            } else {
                break;
            }

        }

        if (mdown == rdown) {
            if (totalLen % 2 == 0) {
                return (double) (nums2[mup] + nums2[mup - 1]) / 2;
            } else {
                return nums2[mup];
            }
        }

        if (totalLen % 2 == 0) {
            return (double) (Math.max(nums1[mdown], nums2[mup]) + Math.min(nums1[mdown + 1], nums2[mup + 1])) / 2;
        }

        return Math.min(nums1[mdown + 1], nums2[mup + 1]);


    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{0}, new int[]{2, 3, 5, 6, 7}));
    }
}
