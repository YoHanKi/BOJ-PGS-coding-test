import java.util.*;

class Solution {
    public static String[] solution(String[] orders, int[] course) {
        Map<String, Integer> combinationCount = new HashMap<>();

        for (String order : orders) {
            char[] items = order.toCharArray();
            Arrays.sort(items);
            for (int r : course) {
                generateCombinations(items, "", 0, r, combinationCount);
            }
        }

        Map<Integer, List<String>> maxCombinations = new HashMap<>();
        Map<Integer, Integer> maxCount = new HashMap<>();

        for (Map.Entry<String, Integer> entry : combinationCount.entrySet()) {
            String combo = entry.getKey();
            int count = entry.getValue();
            int length = combo.length();

            if (count >= 2) {
                if (!maxCount.containsKey(length) || count > maxCount.get(length)) {
                    maxCount.put(length, count);
                    maxCombinations.put(length, new ArrayList<>(List.of(combo)));
                } else if (count == maxCount.get(length)) {
                    maxCombinations.get(length).add(combo);
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int r : course) {
            if (maxCombinations.containsKey(r)) {
                result.addAll(maxCombinations.get(r));
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);

    }

    public static void generateCombinations(char[] items, String current, int index, int r, Map<String, Integer> combinationCount) {
        if (current.length() == r) {
            combinationCount.put(current, combinationCount.getOrDefault(current, 0) + 1);
            return;
        }
        for (int i = index; i < items.length; i++) {
            generateCombinations(items, current + items[i], i + 1, r, combinationCount);
        }
    }
}