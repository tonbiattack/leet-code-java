package stack.removeStars;

class Solution {
    public String removeStars(String s) {
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                c.deleteCharAt(c.length() - 1);
            } else {
                c.append(s.charAt(i));
            }
        }
        return c.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeStars("leet**cod*e"));
    }
}

