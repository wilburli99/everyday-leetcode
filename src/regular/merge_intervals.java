package regular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_intervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        //排序，按照起始位置
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            // 列表为空，或者当前区间与上一个不重叠，直接加
            if (res.isEmpty() || res.get(res.size()-1)[1] < interval[0]) {
                res.add(interval);
            } else {
                // 更新区间
                res.get(res.size() - 1)[1] =
                        Math.max(res.get(res.size() - 1)[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
