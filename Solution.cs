
using System;
using System.Collections.Generic;

public class Solution
{
    public int[] QueryResults(int limit, int[][] queries)
    {
        Dictionary<int, int> labelToColor = new Dictionary<int, int>();
        Dictionary<int, int> colorToNumberOfLabels = new Dictionary<int, int>();
        int[] numberOfDistinctColorsPerQuery = new int[queries.Length];

        for (int i = 0; i < queries.Length; ++i)
        {
            int label = queries[i][0];
            int color = queries[i][1];

            if (!labelToColor.TryAdd(label, color))
            {
                int previousColor = labelToColor[label];
                if (--colorToNumberOfLabels[previousColor] == 0)
                {
                    colorToNumberOfLabels.Remove(previousColor);
                }
            }
            labelToColor[label] = color;

            colorToNumberOfLabels.TryAdd(color, 0);
            ++colorToNumberOfLabels[color];

            numberOfDistinctColorsPerQuery[i] = colorToNumberOfLabels.Count;
        }

        return numberOfDistinctColorsPerQuery;
    }
}
