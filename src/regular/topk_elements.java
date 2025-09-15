package regular;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topk_elements {
    public int[] topKFrequent(int[] nums, int k) {
        // 先统计频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 用小顶堆来存放topk，按频率排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
