
class Solution {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {

        val labelToColor = HashMap<Int, Int>()
        val colorToNumberOfLabels = HashMap<Int, Int>()
        val numberOfDistinctColorsPerQuery = IntArray(queries.size)

        for (i in queries.indices) {
            val label = queries[i][0]
            val color = queries[i][1]

            if (labelToColor.containsKey(label)) {
                val previousColor = labelToColor[label]
                colorToNumberOfLabels[previousColor!!] = colorToNumberOfLabels[previousColor]!! - 1

                if (colorToNumberOfLabels[previousColor] == 0) {
                    colorToNumberOfLabels.remove(previousColor)
                }
            }

            labelToColor[label] = color
            colorToNumberOfLabels[color] = colorToNumberOfLabels.getOrDefault(color, 0) + 1

            numberOfDistinctColorsPerQuery[i] = colorToNumberOfLabels.size
        }

        return numberOfDistinctColorsPerQuery
    }
}
