import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("(\\D+)(\\d+)*");

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Matcher matcher1 = pattern.matcher(o1);
                Matcher matcher2 = pattern.matcher(o2);

                if (matcher1.find() && matcher2.find()) {
                    String head1 = matcher1.group(1).toLowerCase();
                    String head2 = matcher2.group(1).toLowerCase();
                    int number1 = Integer.parseInt(matcher1.group(2));
                    int number2 = Integer.parseInt(matcher2.group(2));

                    int headCompare = head1.compareTo(head2);
                    if (headCompare != 0) {
                        return headCompare;
                    } else {
                        return Integer.compare(number1, number2);
                    }
                }
                return 0;
            }
        });

        return files;
    }
}