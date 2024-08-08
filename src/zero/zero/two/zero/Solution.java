package zero.zero.two.zero;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put(']', '[');
        hm.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    st.push(s.charAt(i));
                    break;
                case ')':
                case ']':
                case '}':
                    if (st.isEmpty() || !hm.get(s.charAt(i)).equals(st.pop())) {
                        return false;
                    }
            }
        }
        return st.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid(")"));
    }
}