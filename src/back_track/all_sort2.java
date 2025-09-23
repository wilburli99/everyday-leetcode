package back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class all_sort2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 排序，方便后面判断是否重复
        boolean[] used = new boolean[nums.length];
        backTrack(nums, new ArrayList<>(), used, res);
        return res;
    }

    private void backTrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        int n = nums.length;
        if (path.size() == n) { //结束条件
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue; // 该数已经用过
            // 去重
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backTrack(nums, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1); // 撤回
        }
    }
}
