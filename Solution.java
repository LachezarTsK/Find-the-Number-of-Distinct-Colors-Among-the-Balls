
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] queryResults(int limit, int[][] queries) {

        Map<Integer, Integer> labelToColor = new HashMap<>();
        Map<Integer, Integer> colorToNumberOfLabels = new HashMap<>();
        int[] numberOfDistinctColorsPerQuery = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int label = queries[i][0];
            int color = queries[i][1];

            if (labelToColor.containsKey(label)) {
                int previousColor = labelToColor.get(label);
                colorToNumberOfLabels.put(previousColor, colorToNumberOfLabels.get(previousColor) - 1);

                if (colorToNumberOfLabels.get(previousColor) == 0) {
                    colorToNumberOfLabels.remove(previousColor);
                }
            }

            labelToColor.put(label, color);
            colorToNumberOfLabels.put(color, colorToNumberOfLabels.getOrDefault(color, 0) + 1);

            numberOfDistinctColorsPerQuery[i] = colorToNumberOfLabels.size();
        }

        return numberOfDistinctColorsPerQuery;
    }
}
