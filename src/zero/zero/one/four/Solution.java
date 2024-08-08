package zero.zero.one.four;

// works well cause max size for strs array of strings is 200, would perform trash for bigger sample size
// TODO: create a more effective version
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];

        int minLen = 201;
        StringBuilder ansBuilder = new StringBuilder();

        for(String s : strs){
            minLen = Math.min(minLen, s.length());
        }

        for(int i = 0; i < minLen; i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i) != strs[j-1].charAt(i)){
                    return ansBuilder.toString();
                }
            }
            ansBuilder.append(strs[0].charAt(i));
        }

        return ansBuilder.toString();
    }
}

class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"Java", "Javelin", "Javagger"}));
    }
}