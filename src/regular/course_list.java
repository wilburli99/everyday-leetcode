package regular;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class course_list {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(); // 转化为图
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses]; // 计算每个课的度，度为0表示没有前置

        for (int[] p : prerequisites) {
            int a = p[0], b = p[1];
            graph.get(b).add(a);
            indegree[a]++; // 统计每个需要前置课的课的度
        }

        // 让度为0的课入队
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        // 拓扑排序,bfs
        int count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            for (int visited : graph.get(course)) {
                indegree[visited]--;
                if (indegree[visited] == 0) q.offer(visited);
            }
        }
        if (count == numCourses) {
            return true;
        }
        return false;
    }
}
