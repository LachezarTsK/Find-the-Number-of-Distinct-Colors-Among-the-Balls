
/**
 * @param {number} limit
 * @param {number[][]} queries
 * @return {number[]}
 */
var queryResults = function (limit, queries) {

    // Map<number, number>
    const labelToColor = new Map();
    // Map<number, number>
    const colorToLabels = new Map();
    const numberOfDistinctColorsPerQuery = new Array(queries.length);

    for (let i = 0; i < queries.length; ++i) {
        const label = queries[i][0];
        const color = queries[i][1];

        if (labelToColor.has(label)) {
            const previousColor = labelToColor.get(label);
            colorToLabels.set(previousColor, colorToLabels.get(previousColor) - 1);

            if (colorToLabels.get(previousColor) === 0) {
                colorToLabels.delete(previousColor);
            }
        }

        labelToColor.set(label, color);
        if (!colorToLabels.has(color)) {
            colorToLabels.set(color, 0);
        }
        colorToLabels.set(color, colorToLabels.get(color) + 1);

        numberOfDistinctColorsPerQuery[i] = colorToLabels.size;
    }

    return numberOfDistinctColorsPerQuery;
};
