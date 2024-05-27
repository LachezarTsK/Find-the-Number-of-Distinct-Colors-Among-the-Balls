
#include <vector>
#include <unordered_set>
#include <unordered_map>
using namespace std;

class Solution {

public:
    vector<int> queryResults(int limit, const vector<vector<int>>& queries) const {

        unordered_map<int, int> labelToColor;
        unordered_map<int, int> colorToLabels;
        vector<int> numberOfDistinctColorsPerQuery(queries.size());

        for (size_t i = 0; i < queries.size(); ++i) {
            int label = queries[i][0];
            int color = queries[i][1];

            if (labelToColor.contains(label)) {
                int previousColor = labelToColor[label];

                if (--colorToLabels[previousColor] == 0) {
                    colorToLabels.erase(previousColor);
                }
            }

            labelToColor[label] = color;
            ++colorToLabels[color];

            numberOfDistinctColorsPerQuery[i] = colorToLabels.size();
        }

        return numberOfDistinctColorsPerQuery;
    }
};
