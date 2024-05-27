
package main

import "fmt"

func queryResults(limit int, queries [][]int) []int {

	var labelToColor = map[int]int{}
	var colorToNumberOfLabels = map[int]int{}
	var numberOfDistinctColorsPerQuery = make([]int, len(queries))

	for i := range queries {
		var label = queries[i][0]
		var color = queries[i][1]

		if previousColor, contains := labelToColor[label]; contains {
			colorToNumberOfLabels[previousColor] = colorToNumberOfLabels[previousColor] - 1

			if colorToNumberOfLabels[previousColor] == 0 {
				delete(colorToNumberOfLabels, previousColor)
			}
		}

		labelToColor[label] = color
		colorToNumberOfLabels[color]++

		numberOfDistinctColorsPerQuery[i] = len(colorToNumberOfLabels)
	}

	return numberOfDistinctColorsPerQuery
}
