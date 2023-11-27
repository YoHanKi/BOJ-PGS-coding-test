package beginner;

//영어가 싫어요
class Solution37 {
    public long solution(String numbers) {
        String[] switchNumbers = {
                  "zero" , "one"  , "two"
                , "three", "four" , "five"
                , "six"  , "seven", "eight", "nine"};

        for (int i = 0; i < switchNumbers.length; i++) {
            numbers = numbers.replaceAll(switchNumbers[i], String.valueOf(i));
        }
        return Long.parseLong(numbers);
    }
}