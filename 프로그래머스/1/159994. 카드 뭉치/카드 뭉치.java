class Solution {
    private static String YES = "Yes";
    private static String NO = "No";
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        
        for (String g : goal) {
            if (cards1.length > index1 && g.equals(cards1[index1])) {
                index1++;
            } else if (cards2.length > index2 && g.equals(cards2[index2])) {
                index2++;
            } else {
                return NO;
            }
        }
        return YES;
    }
}