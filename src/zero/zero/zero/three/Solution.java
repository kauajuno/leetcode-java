package zero.zero.zero.three;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;

        HashMap<Character, Boolean> hm = new HashMap<>();
        int highscore = 1;
        int start = 0;
        hm.put(s.charAt(0), true);
        for(int i = 1; i < s.length(); i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), true);
            }else{
                if((i - start) > highscore){
                    highscore = i - start;
                }
                while(s.charAt(start) != s.charAt(i)){
                    hm.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        if((s.length() - start) > highscore){
            highscore = s.length() - start;
        }

        return highscore;
    }
}