package zero.zero.zero.one;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int cont = 0;
        for(int i : nums){
            int complement = target - i;
            if(hm.containsKey(complement)){
                return new int[]{hm.get(complement), cont};
            }else{
                hm.put(i, cont);
            }
            cont++;
        }
        return new int[]{1, 1};
    }
}
