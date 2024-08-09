package zero.zero.zero.four;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 1) return nums2[0];
        if(nums2.length == 0 && nums1.length == 1) return nums1[0];
        int totalLen = (nums1.length + nums2.length);
        int cont = 0, cont1 = 0, cont2 = 0;
        int[] arr = new int[2];
        while(cont < ((totalLen - 1) / 2)){
            if(cont1 == nums1.length){
                cont2++;
            }
            if(cont2 == nums2.length){
                cont1++;
            }
            if(cont1 != nums1.length && cont2 != nums2.length) {
                if (Math.min(nums1[cont1], nums2[cont2]) == nums1[cont1]) {
                    cont1++;
                } else {
                    cont2++;
                }
            }
            cont++;
        }

        for(int i = 0; i < 2; i++){
            if(cont1 == nums1.length){
                arr[i] = nums2[cont2];
                cont2++;
                continue;
            }
            if(cont2 == nums2.length){
                arr[i] = nums1[cont1];
                cont1++;
                continue;
            }
            if (Math.min(nums1[cont1], nums2[cont2]) == nums1[cont1]) {
                arr[i] = nums1[cont1];
                cont1++;
            } else {
                arr[i] = nums2[cont2];
                cont2++;
            }
        }

        if(totalLen % 2 == 0) return (double) (arr[0] + arr[1]) / 2;
        return arr[0];
    }
}

class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
    }
}
