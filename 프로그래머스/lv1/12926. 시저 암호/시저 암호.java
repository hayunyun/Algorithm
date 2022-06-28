class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (Character.isLowerCase(c)) {
                    c = ((char)(c + n) > 'z') ? (char)(c + n - 26) : (char)(c + n);
                }
                else if (Character.isUpperCase(c)) {
                    c = ((char)(c + n) > 'Z') ? (char)(c + n - 26) : (char)(c + n);;
                }
                // c = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ? c : (char)(c - 26);
            }
            answer += c;
        }
        
        return answer;
    }
    
    // public static void test() {
    //     System.out.println(solution("AB", 1));
    //     // System.out.println(solution("z", 1));
    //     // System.out.println(solution("Z", 10));
    //     // System.out.println(solution("a B z", 4));
    //     // System.out.println(solution(" aBZ", 20));
    //     // System.out.println(solution("y X Z", 4));
    //     // System.out.println(solution(" . h z", 20));
    // }
}