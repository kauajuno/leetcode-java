package zero.zero.one.three;

import java.util.HashMap;

//class Solution {
//    HashMap<Character, Integer> map = new HashMap<>();
//    public int romanToInt(String s) {
//        map.put('I', 1);
//        map.put('V', 5);
//        map.put('X', 10);
//        map.put('L', 50);
//        map.put('C', 100);
//        map.put('D', 500);
//        map.put('M', 1000);
//        map.put('0', 0);
//
//        int total = 0;
//        int i = 0;
//
//        for(i = 0; i < s.length() - 1; i++){
//            int currValue = map.get(s.charAt(i));
//            int nextValue = map.get(s.charAt(i + 1));
//            if(currValue < nextValue){
//                total += (nextValue - currValue);
//                i++;
//            }else{
//                total += currValue;
//            }
//        }
//
//        if(i == s.length() - 1) total += map.get(s.charAt(s.length() - 1));
//
//        return total;
//    }
//}

// NOT MINE
class Solution {
    public int romanToInt(String s) {
        int result = 0, previous = 0, current = 0;
        char[] chars = s.toCharArray();
        for (char romanChar : chars) {
            switch (romanChar) {
                case 'I' -> current = 1;
                case 'V' -> current = 5;
                case 'X' -> current = 10;
                case 'L' -> current = 50;
                case 'C' -> current = 100;
                case 'D' -> current = 500;
                case 'M' -> current = 1000;
            }
            if (previous < current)
                // because we add previous once before and need to remove that
                result += current - 2 * previous;
            else
                result += current;
            previous = current;
        }
        return result;
    }
}

class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("IV"));
    }
}
